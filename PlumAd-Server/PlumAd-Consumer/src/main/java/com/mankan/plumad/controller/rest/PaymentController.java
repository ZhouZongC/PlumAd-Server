package com.mankan.plumad.controller.rest;

import com.alibaba.fastjson.JSON;
import com.mankan.plumad.dto.RechargeDTO;
import com.mankan.plumad.dto.WithdrawDTO;
import com.mankan.plumad.handle.PaymentHandle;
import com.mankan.plumad.util.HttpParamUtil;
import com.mankan.plumad.util.NetworkUtil;
import com.mipay.base.common.constant.enums.ReturnCode;
import com.mipay.base.common.dto.ValidationResult;
import com.mipay.base.util.JsonResultUtil;
import com.mipay.base.util.ValidationUtil;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

/**
 * @author: youtiao
 * @create: 2019-10-14 16:16
 * @description:
 **/
@RestController
@RequestMapping("/payment")
public class PaymentController {

    private static Logger log = LoggerFactory.getLogger(PaymentController.class);


    @Autowired
    private PaymentHandle paymentHandle;


    @ResponseBody
    @RequestMapping(value = "/pay",method={RequestMethod.POST})
    @ApiOperation(value="获取支付链接", notes="获取支付链接")
    public String payment(@RequestBody RechargeDTO rechargeDTO, HttpServletRequest request) {
        //验证查询参数
        ValidationResult result = ValidationUtil.validateEntity(rechargeDTO);
        if(!result.isHasErrors()) {
            String ip = NetworkUtil.getIpAddr(request);
            rechargeDTO.setIp(ip);
            return paymentHandle.payment(rechargeDTO);
        }else{
            return JsonResultUtil.toJson(ReturnCode.ERROR,result.getErrorMsg());
        }
    }


    @ResponseBody
    @RequestMapping(value = "/dfPay",method={RequestMethod.POST})
    @ApiOperation(value="获取代付", notes="获取代付")
    public String dfpayment(@RequestBody WithdrawDTO withdrawDTO, HttpServletRequest request) {
        //验证查询参数
        ValidationResult result = ValidationUtil.validateEntity(withdrawDTO);
        if(!result.isHasErrors()) {
        String ip = NetworkUtil.getIpAddr(request);
        withdrawDTO.setIp(ip);
        return paymentHandle.dfpayment(withdrawDTO);
        }else{
            return JsonResultUtil.toJson(ReturnCode.ERROR,result.getErrorMsg());
        }
    }


    @ResponseBody
    @RequestMapping(value = "/async",method={RequestMethod.POST})
    @ApiOperation(value="异步通知", notes="获取支付链接")
    public String async(HttpServletRequest request) {
        try {
            HashMap paraMap = HttpParamUtil.getParams(request);
            log.info("异步通知上游请求参数：{}", JSON.toJSONString(paraMap));
            String resultString = paymentHandle.Async(paraMap);
            log.info("异步通知返回上游参数：{}",resultString);
            return resultString ;
        }catch (Exception e){
            log.info("异步通知错误 {}",e);
            return "error";
        }
    }


    @ResponseBody
    @RequestMapping(value = "/dfAsync",method={RequestMethod.POST})
    @ApiOperation(value="代付异步通知", notes="代付异步通知")
    public String dfAsync(HttpServletRequest request) {
        try {
            HashMap paraMap = HttpParamUtil.getParams(request);
            log.info("异步通知上游请求参数：{}", JSON.toJSONString(paraMap));
            String resultString = paymentHandle.DfAsync(paraMap);
            log.info("异步通知返回上游参数：{}",resultString);
            return resultString ;
        }catch (Exception e){
            log.info("异步通知错误 {}",e);
            return "error";
        }
    }

}
