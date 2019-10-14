package com.mankan.plumad.controller.rest;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @author: youtiao
 * @create: 2019-10-14 16:16
 * @description:
 **/
@RequestMapping("/payment")
public class PaymentController {


    @ResponseBody
    @RequestMapping(value = "/pay",method={RequestMethod.POST})
    @ApiOperation(value="获取支付链接", notes="获取支付链接")
    public String payment(HttpServletRequest request) {
        return null;
    }


    @ResponseBody
    @RequestMapping(value = "/dfPay",method={RequestMethod.POST})
    @ApiOperation(value="获取代付", notes="获取代付")
    public String dfpayment(HttpServletRequest request) {
        return null;
    }


    @ResponseBody
    @RequestMapping(value = "/async",method={RequestMethod.POST})
    @ApiOperation(value="异步通知", notes="获取支付链接")
    public String async(HttpServletRequest request) {
        return null;
    }


    @ResponseBody
    @RequestMapping(value = "/dfAsync",method={RequestMethod.POST})
    @ApiOperation(value="代付异步通知", notes="代付异步通知")
    public String dfAsync(HttpServletRequest request) {
        return null;
    }

}
