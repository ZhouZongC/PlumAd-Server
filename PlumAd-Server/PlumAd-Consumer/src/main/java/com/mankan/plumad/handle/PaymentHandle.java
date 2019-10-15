package com.mankan.plumad.handle;

import cn.hutool.core.util.NumberUtil;
import com.alibaba.fastjson.JSONObject;
import com.mankan.plumad.consumer.UserFinanceConsumer;
import com.mankan.plumad.consumer.UserRechargeConsumer;
import com.mankan.plumad.consumer.UserWithdrawConsumer;
import com.mankan.plumad.controller.rest.PaymentController;
import com.mankan.plumad.dto.*;
import com.mankan.plumad.model.UserFinance;
import com.mankan.plumad.model.UserRecharge;
import com.mankan.plumad.model.UserWithdraw;
import com.mankan.plumad.util.DFConfig;
import com.mankan.plumad.util.PayConfig;
import com.mankan.plumad.util.PostUtil;
import com.mankan.plumad.util.RSAUtil;
import com.mipay.base.common.constant.enums.ReturnCode;
import com.mipay.base.common.dto.DecodeResult;
import com.mipay.base.util.JsonResultUtil;
import com.mipay.base.util.OrderNumUtil;
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

    @Autowired
    PostUtil post;

    public String DfAsync(HashMap hashMap) {

        log.info("铁锤支付—异步通知:" + hashMap);
        DecodeResult decryptStr = com.mipay.base.util.RSAUtil.getDecode((String) hashMap.get("encrtptKey"), (String)hashMap.get("encryptData"),
                "signData",DFConfig.PRIVATEKEY);
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
        DecodeResult decryptStr = com.mipay.base.util.RSAUtil.getDecode((String) hashMap.get("encrtptKey"), (String)hashMap.get("encryptData"),
                "signData",PayConfig.PRIVATEKEY);
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
            if(responseJson == null){
                return JsonResultUtil.toJson(ReturnCode.ERROR,"服务异常");
            }
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
                String responseJson = this.dfpaymentForIsv(userRecharge,searchUserFinance);
                if(responseJson == null){
                    return JsonResultUtil.toJson(ReturnCode.ERROR,"服务异常");
                }
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
     * @param userWithdrawu
     * @return
     */
    private String dfpaymentForIsv(UserWithdraw userWithdrawu,UserFinance userFinance) {
        log.info("代付请求 userRecharge:" + userWithdrawu);
        log.info("代付请求 userFinance:" + userFinance);

        JSONObject transactionLog = new JSONObject();
        transactionLog.put("tradeAmount",userWithdrawu.getTotalAmount());
        transactionLog.put("downOrderNum",userWithdrawu.getOrderNum());
        transactionLog.put("subjectCard",userFinance.getCardnum());
        transactionLog.put("subjectName",userFinance.getCardName());
        transactionLog.put("subjectPhone",userFinance.getPhone());     //手机号
        transactionLog.put("certType","1");
        transactionLog.put("certNo",userFinance.getIdCode());            //身份证
        transactionLog.put("toPrivate","0");
        transactionLog.put("bankCode",userFinance.getBankCode());             //银行编码
        transactionLog.put("bankGeneralName",userFinance.getBankName());//银行名称
        transactionLog.put("bankgeneralCode",userFinance.getBranchCode());//总联行号
        transactionLog.put("bankBranchCode",userFinance.getBranchCode());  //支行联行号
        transactionLog.put("bankBranchNmae",userFinance.getBankInfo());  //支行名称

        JSONObject requestJSON = new JSONObject();
        requestJSON.put("agentCode", DFConfig.AGENTCODE);
        requestJSON.put("merchantCode", DFConfig.MERCHANTCODE);
        requestJSON.put("channelCode",DFConfig.CHANNELCODE);
        requestJSON.put("transactionLog",transactionLog);
        log.info("请求参数 {}" ,requestJSON);
        //加密
        EncryptionResult encryption = RSAUtil.getencryption(DFConfig.PUBLICKEY, requestJSON.toJSONString(), DFConfig.PRIVATEKEY);
        //请求参数
        JSONObject encryptionMap = new JSONObject();
        encryptionMap.put("encryptData", encryption.getEncryptData());
        encryptionMap.put("encrtptKey", encryption.getEncrtptKey());
        encryptionMap.put("signData", encryption.getSignData());
        encryptionMap.put("merchantCode",DFConfig.MERCHANTCODE);
        encryptionMap.put("agentCode",DFConfig.AGENTCODE);
        encryptionMap.put("version", "3.0.0");

        log.info("代付请求参数 {}" ,encryptionMap);
        String result = post.get(encryptionMap, "http://zhifu.tiechuipay.com/dfpay/dfPayOut");
        log.info("代付响应参数：" + result);

        if(result == null){
            return null;
        }

        JSONObject respJSON = JSONObject.parseObject(result);
        if (respJSON.containsKey("code") && !respJSON.getString("code").equals("20000")) {
            return respJSON.toJSONString();
        }

        String respStr = RSAUtil.getdecode(respJSON.getString("encrtptKey"), respJSON.getString("encryptData"), "signData", DFConfig.PRIVATEKEY);
        log.info("铁锤代付解密参数:" + respStr);



        return respStr;
    }


    /**
     * 支付请求
     * @param userRecharge
     * @return
     */
    private String paymentForIsv(UserRecharge userRecharge) {
        log.info("支付请求 userRecharge:" + userRecharge);

        JSONObject requestJSON = new JSONObject();
        requestJSON.put("agentCode", PayConfig.AGENTCODE);
        requestJSON.put("merchantCode",PayConfig.MERCHANTCODE);
        requestJSON.put("downOrderNum",userRecharge.getOrderNum());
        requestJSON.put("totalAmount",userRecharge.getRechargeAmount());
        requestJSON.put("channelCode",PayConfig.CHANNELCODE);
        requestJSON.put("interfaceType","P001");
        requestJSON.put("uniqueUserId",userRecharge.getOrderNum());
        requestJSON.put("payType",userRecharge.getPayType().equals("1")?"T001":userRecharge.getPayType().equals("2")?"T002":"");
        requestJSON.put("goodsName","充值");
        requestJSON.put("ip",userRecharge.getIpAddress());
        requestJSON.put("describe",userRecharge.getRemarks());
        requestJSON.put("callBackUrl",PayConfig.CALLBACKURL);
        requestJSON.put("successUrl",PayConfig.SUCCESSURL);
        log.info("请求参数 {}" ,requestJSON);
        //加密
        EncryptionResult encryption = RSAUtil.getencryption(PayConfig.PUBLICKEY, requestJSON.toJSONString(),PayConfig.PRIVATEKEY);
        //请求参数
        JSONObject encryptionMap = new JSONObject();
        encryptionMap.put("encryptData", encryption.getEncryptData());
        encryptionMap.put("encrtptKey", encryption.getEncrtptKey());
        encryptionMap.put("signData", encryption.getSignData());
        encryptionMap.put("merchantCode",PayConfig.MERCHANTCODE);
        encryptionMap.put("agentCode",PayConfig.AGENTCODE);
        encryptionMap.put("version", "3.0.0");

        log.info("支付请求参数 {}" ,encryptionMap);
        String result = post.get(encryptionMap, "http://zhifu.tiechuipay.com/pay/Pay");
        log.info("支付响应参数 {}" ,encryptionMap);

        if (result == null){
            //未知错误处理
            return null;
        }

        JSONObject respJSON = JSONObject.parseObject(result);
        if (respJSON.containsKey("code") && !respJSON.getString("code").equals("20000")) {
            return respJSON.toJSONString();
        }

        String decryptStr = RSAUtil.getdecode(respJSON.getString("encrtptKey"), respJSON.getString("encryptData"), "signData",PayConfig.PRIVATEKEY);
        log.info("支付解密参数:" + decryptStr);

        return decryptStr;
    }
}
