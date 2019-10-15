package com.mankan.plumad.controller.rest;

import com.alibaba.fastjson.JSON;
import com.mankan.plumad.dto.RechargeDTO;
import com.mankan.plumad.dto.WithdrawDTO;
import com.mankan.plumad.handle.PaymentHandle;
import com.mankan.plumad.util.HttpParamUtil;
import com.mankan.plumad.util.NetworkUtil;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

/**
 * @author: youtiao
 * @create: 2019-10-14 16:16
 * @description:
 **/
@RequestMapping("/payment")
public class PaymentController {

    private static Logger log = LoggerFactory.getLogger(PaymentController.class);


    @Autowired
    private PaymentHandle paymentHandle;


    @ResponseBody
    @RequestMapping(value = "/pay",method={RequestMethod.POST})
    @ApiOperation(value="获取支付链接", notes="获取支付链接")
    public String payment(RechargeDTO rechargeDTO, HttpServletRequest request) {
        String ip = NetworkUtil.getIpAddr(request);
        rechargeDTO.setIp(ip);
        return paymentHandle.payment(rechargeDTO);
    }


    @ResponseBody
    @RequestMapping(value = "/dfPay",method={RequestMethod.POST})
    @ApiOperation(value="获取代付", notes="获取代付")
    public String dfpayment(WithdrawDTO withdrawDTO, HttpServletRequest request) {
        String ip = NetworkUtil.getIpAddr(request);
        withdrawDTO.setIp(ip);
        return paymentHandle.dfpayment(withdrawDTO);
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
