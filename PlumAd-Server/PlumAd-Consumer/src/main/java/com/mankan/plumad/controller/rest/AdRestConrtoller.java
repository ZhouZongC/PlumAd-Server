package com.mankan.plumad.controller.rest;

import com.mankan.plumad.handle.AdRestHandle;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;

/**
 * @author: youtiao
 * @create: 2019-10-10 10:22
 * @description:
 **/
@Controller
@RequestMapping("/ad")
@Api(tags="广告",description="广告")
public class AdRestConrtoller {

    @Autowired
    private AdRestHandle adRestHandle;

    /**
     * 获取建议广告列表
     * @param promotionCode
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/api/listAd",method={RequestMethod.POST})
    @ApiOperation(value="获取广告推广列表", notes="获取广告推广列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "positionCode", value = "位置code", required = true, dataType = "String", paramType = "query")
    })
    public String listAd(@RequestParam("positionCode") String promotionCode) throws Throwable {
        return adRestHandle.listAd(promotionCode);
    }



    @ResponseBody
    @RequestMapping(value = "/api/getAd",method={RequestMethod.POST})
    @ApiOperation(value="获取广告推广信息", notes="获取广告推广信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "positionCode", value = "位置code", required = true, dataType = "String", paramType = "query")
    })
    public String getAd(@RequestParam("positionCode") String promotionCode, HttpServletRequest request) throws Throwable {
        return adRestHandle.getAd(promotionCode,request,0);
    }




    @RequestMapping(value = "/{shorturl}")
//    @ApiOperation(value="跳转广告推广内容", notes="跳转广告推广内容")
//    @ApiImplicitParams({
//            @ApiImplicitParam(name = "shorturl", value = "短链接Url", required = true, dataType = "String", paramType = "path")
//    })
    public ModelAndView translateAd(@PathVariable String shorturl, HttpServletRequest request){
        String returnUrl = adRestHandle.translateAd(shorturl,request);
        return new ModelAndView(new RedirectView(returnUrl));
    }




}
