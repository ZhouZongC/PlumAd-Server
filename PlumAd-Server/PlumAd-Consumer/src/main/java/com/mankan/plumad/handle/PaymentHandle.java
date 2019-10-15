package com.mankan.plumad.handle;

import cn.hutool.core.util.NumberUtil;
import cn.hutool.json.JSONUtil;
import com.alibaba.fastjson.JSONObject;
import com.mankan.plumad.consumer.UserFinanceConsumer;
import com.mankan.plumad.consumer.UserRechargeConsumer;
import com.mankan.plumad.consumer.UserWithdrawConsumer;
import com.mankan.plumad.controller.rest.PaymentController;
import com.mankan.plumad.dto.RechargeDTO;
import com.mankan.plumad.dto.RechargeVO;
import com.mankan.plumad.dto.WithdrawDTO;
import com.mankan.plumad.dto.WithdrawVO;
import com.mankan.plumad.model.UserFinance;
import com.mankan.plumad.model.UserRecharge;
import com.mankan.plumad.model.UserWithdraw;
import com.mipay.base.common.constant.enums.ReturnCode;
import com.mipay.base.common.dto.DecodeResult;
import com.mipay.base.util.JsonResultUtil;
import com.mipay.base.util.OrderNumUtil;
import com.mipay.base.util.RSAUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;

/**
 * @author: youtiao
 * @create: 2019-10-14 16:19
 * @description:
 **/
@Component
public class PaymentHandle {

    private static Logger log = LoggerFactory.getLogger(PaymentController.class);

    @Autowired
    private OrderNumUtil orderNumUtil;

    @Autowired
    private UserRechargeConsumer userRechargeConsumer;

    @Autowired
    private UserWithdrawConsumer userWithdrawConsumer;

    @Autowired
    private UserFinanceConsumer userFinanceConsumer;

    public String DfAsync(HashMap hashMap) {

        log.info("铁锤支付—异步通知:" + hashMap);
        DecodeResult decryptStr = RSAUtil.getDecode((String) hashMap.get("encrtptKey"), (String)hashMap.get("encryptData"),
                "signData","");
        log.info("铁锤支付解密参数:" + decryptStr);
        JSONObject dataJSON = JSONObject.parseObject(decryptStr.getDecodeData());

        if(dataJSON.getString("responseCode").equals("20000")){
            //将状态改成 S001/E001
            String orderNum = dataJSON.getString("orderNum");
            UserWithdraw searchUserWithdraw = new UserWithdraw();
            searchUserWithdraw.setOrderNum(orderNum);
            UserWithdraw userWithdraw = userWithdrawConsumer.getUserWithdrawByCondition(searchUserWithdraw);
            searchUserWithdraw.setId(userWithdraw.getId());
            searchUserWithdraw.setStatus("S001");
            Boolean flag = userWithdrawConsumer.saveUserWithdraw(searchUserWithdraw);
            if(flag) {
                //将处理中金额改成已处理
                UserFinance searchUserFinance = new UserFinance();
                searchUserFinance.setUserId(userWithdraw.getUserId());
                UserFinance userFinance = userFinanceConsumer.getUserFinanceByCondition(searchUserFinance);
                flag = userFinanceConsumer.updateUserFinanceForS001(userFinance.getUserId(),userWithdraw.getTotalAmount());
                if(flag) {
                    return "000000";
                }else{
                    return "error";
                }
            }else{
                return "error";
            }
        }else if(dataJSON.getString("responseCode").equals("60000")) {
            //将状态改成 S001/E001
            String orderNum = dataJSON.getString("orderNum");
            UserWithdraw searchUserWithdraw = new UserWithdraw();
            searchUserWithdraw.setOrderNum(orderNum);
            UserWithdraw userWithdraw = userWithdrawConsumer.getUserWithdrawByCondition(searchUserWithdraw);
            searchUserWithdraw.setId(userWithdraw.getId());
            searchUserWithdraw.setStatus("E001");
            Boolean flag = userWithdrawConsumer.saveUserWithdraw(searchUserWithdraw);
            if(flag) {
                //将处理中金额改成可提现
                UserFinance searchUserFinance = new UserFinance();
                searchUserFinance.setUserId(userWithdraw.getUserId());
                UserFinance userFinance = userFinanceConsumer.getUserFinanceByCondition(searchUserFinance);
                flag = userFinanceConsumer.updateUserFinanceForE001(userFinance.getUserId(),userWithdraw.getTotalAmount());
                if(flag) {
                    return "000000";
                }else{
                    return "error";
                }
            }else{
                return "error";
            }
        }

        return "error";
    }

    public String Async(HashMap hashMap) {
        log.info("铁锤支付—异步通知:" + hashMap);
        DecodeResult decryptStr = RSAUtil.getDecode((String) hashMap.get("encrtptKey"), (String)hashMap.get("encryptData"),
                "signData","");
        log.info("铁锤支付解密参数:" + decryptStr);
        JSONObject dataJSON = JSONObject.parseObject(decryptStr.getDecodeData());
        if(dataJSON.getString("responseCode").equals("20000")){
            //将状态改成 S001
            String orderNum = dataJSON.getString("orderNum");
            UserRecharge searchUserRecharge = new UserRecharge();
            searchUserRecharge.setOrderNum(orderNum);
            UserRecharge userRecharge1 = userRechargeConsumer.getUserRechargeByCondition(searchUserRecharge);
            searchUserRecharge.setId(userRecharge1.getId());
            searchUserRecharge.setStatus("S001");
            Boolean flag = userRechargeConsumer.saveUserRecharge(searchUserRecharge);
            if(flag) {
                //将可用金额加上
                UserFinance searchUserFinance = new UserFinance();
                searchUserFinance.setUserId(userRecharge1.getUserId());
                UserFinance userFinance = userFinanceConsumer.getUserFinanceByCondition(searchUserFinance);
                flag = userFinanceConsumer.updateUserFinanceForRecharge(userFinance.getUserId(),userRecharge1.getRechargeAmount());
                if(flag) {
                    return "000000";
                }else{
                    return "error";
                }
            }else{

                return "error";
            }
        }

        return "error";
    }

    public String payment(RechargeDTO rechargeDTO) {

        RechargeVO rechargeVO =new RechargeVO();
        //插入订单 R001
        UserRecharge userRecharge = new UserRecharge();
        userRecharge.setIpAddress(rechargeDTO.getIp());
        userRecharge.setUserId(rechargeDTO.getUserId());
        String ordernum = "996" + orderNumUtil.getOrderNum("GGLM");
        userRecharge.setOrderNum(ordernum);
        userRecharge.setRechargeAmount(rechargeDTO.getRechargeAmount());
        userRecharge.setPayType(rechargeDTO.getPayType());
        userRecharge.setRequestTime(new Date());
        userRecharge.setStatus("R001");
        Boolean flag = userRechargeConsumer.saveUserRecharge(userRecharge);

        if(flag){
            //请求上游
            String responseJson =  this.paymentForIsv(userRecharge);
            JSONObject json = JSONObject.parseObject(responseJson);
            if (!json.getString("code").equals("20000")) {
                rechargeVO.setResponseMsg(json.getString("msg"));
                rechargeVO.setResponseCode(json.getString("code"));
                UserRecharge searchUserRecharge = new UserRecharge();
                searchUserRecharge.setOrderNum(ordernum);
                UserRecharge userRecharge1 = userRechargeConsumer.getUserRechargeByCondition(searchUserRecharge);
                searchUserRecharge.setId(userRecharge1.getId());
                searchUserRecharge.setStatus("E001");
                userRechargeConsumer.saveUserRecharge(searchUserRecharge);
                return JsonResultUtil.toJson(ReturnCode.ERROR, rechargeVO);
            } else {
                //调用接口成功
                JSONObject dataJson = JSONObject.parseObject(json.getString("data"));;
                rechargeVO.setPayUrl(dataJson.getString("payUrl"));
                rechargeVO.setResponseCode(dataJson.getString("responseCode"));
                rechargeVO.setResponseMsg(dataJson.getString("responseMsg"));
                UserRecharge searchUserRecharge = new UserRecharge();
                searchUserRecharge.setOrderNum(ordernum);
                UserRecharge userRecharge1 = userRechargeConsumer.getUserRechargeByCondition(searchUserRecharge);
                searchUserRecharge.setId(userRecharge1.getId());
                searchUserRecharge.setStatus("R002");
                userRechargeConsumer.saveUserRecharge(searchUserRecharge);
                return JsonResultUtil.toJson(ReturnCode.SUCCESS, rechargeVO);
            }

        }

        //将状态改成 R002

        return JsonResultUtil.toJson(ReturnCode.ERROR);
    }

    public String dfpayment(WithdrawDTO withdrawDTO) {
        WithdrawVO withdrawVO = new WithdrawVO();
        //插入订单 R001
        UserWithdraw userRecharge = new UserWithdraw();
        userRecharge.setIpAddress(withdrawDTO.getIp());
        userRecharge.setUserId(withdrawDTO.getUserId());
        String ordernum = "996" + orderNumUtil.getOrderNum("GGXF");
        userRecharge.setOrderNum(ordernum);
        userRecharge.setTotalAmount(withdrawDTO.getTotalAmount());
        userRecharge.setWithdrawAmount(withdrawDTO.getTotalAmount());
        userRecharge.setRequestTime(new Date());
        userRecharge.setStatus("R001");
        Boolean flag = userWithdrawConsumer.saveUserWithdraw(userRecharge);
        if(flag) {
            //将交易金额写入处理中金额
            UserFinance searchUserFinance = new UserFinance();
            searchUserFinance.setUserId(withdrawDTO.getUserId());
            UserFinance userFinance = userFinanceConsumer.getUserFinanceByCondition(searchUserFinance);
            if(NumberUtil.isGreater(userFinance.getWithdrawAmount(),withdrawDTO.getTotalAmount())){
                //请求上游
                String responseJson = this.dfpaymentForIsv(userRecharge);
                JSONObject json = JSONObject.parseObject(responseJson);
                if (!json.getString("code").equals("20000")) {
                    withdrawVO.setResponseMsg(json.getString("msg"));
                    withdrawVO.setResponseCode(json.getString("code"));
                    UserWithdraw searchUserWithdraw = new UserWithdraw();
                    searchUserWithdraw.setOrderNum(ordernum);
                    UserWithdraw userWithdraw = userWithdrawConsumer.getUserWithdrawByCondition(searchUserWithdraw);
                    searchUserWithdraw.setId(userWithdraw.getId());
                    searchUserWithdraw.setStatus("E001");
                    userWithdrawConsumer.saveUserWithdraw(searchUserWithdraw);
                    return JsonResultUtil.toJson(ReturnCode.ERROR, withdrawVO);
                } else {
                    //调用接口成功
                    JSONObject dataJson = JSONObject.parseObject(json.getString("data"));;
                    withdrawVO.setResponseCode(dataJson.getString("responseCode"));
                    withdrawVO.setResponseMsg(dataJson.getString("responseMsg"));
                    UserWithdraw searchUserWithdraw = new UserWithdraw();
                    searchUserWithdraw.setOrderNum(ordernum);
                    UserWithdraw userWithdraw = userWithdrawConsumer.getUserWithdrawByCondition(searchUserWithdraw);
                    searchUserWithdraw.setId(userWithdraw.getId());
                    searchUserWithdraw.setStatus("R002");
                    userWithdrawConsumer.saveUserWithdraw(searchUserWithdraw);
                    return JsonResultUtil.toJson(ReturnCode.SUCCESS, withdrawVO);
                }
            }else{
                UserWithdraw searchUserWithdraw = new UserWithdraw();
                searchUserWithdraw.setOrderNum(ordernum);
                UserWithdraw userWithdraw = userWithdrawConsumer.getUserWithdrawByCondition(searchUserWithdraw);
                searchUserWithdraw.setId(userWithdraw.getId());
                searchUserWithdraw.setStatus("E001");
                userWithdrawConsumer.saveUserWithdraw(searchUserWithdraw);
                return JsonResultUtil.toJson(ReturnCode.ERROR,"提现余额不足");
            }
        }

        return JsonResultUtil.toJson(ReturnCode.ERROR);
    }

    /**
     * 代付请求
     * @param userRecharge
     * @return
     */
    private String dfpaymentForIsv(UserWithdraw userRecharge) {
        return null;
    }


    /**
     * 支付请求
     * @param userRecharge
     * @return
     */
    private String paymentForIsv(UserRecharge userRecharge) {
        return null;
    }
}
