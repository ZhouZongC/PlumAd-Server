package com.mankan.plumad.controller;


import com.github.pagehelper.PageInfo;
import com.mipay.base.common.constant.enums.ReturnCode;
import com.mipay.base.common.dto.ValidationResult;
import com.mipay.base.util.JsonResultUtil;
import com.mipay.base.util.ValidationUtil;
import com.mankan.plumad.consumer.AdPromotionPositionAdConsumer;
import com.mankan.plumad.dto.DataGrid;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;

import org.springframework.stereotype.Controller;
import com.mankan.plumad.model.AdPromotionPositionAd;
import com.mankan.plumad.dto.AdPromotionPositionAdQuery;

/**
 * <p>
 * 流量主推广广告位对应广告 前端控制器
 * </p>
 *
 * @author lq
 * @since 2019-09-24
 */
@Api(tags = "流量主推广广告位对应广告",description="流量主推广广告位对应广告")
@Controller
@RequestMapping("/plumad/adPromotionPositionAd")
public class AdPromotionPositionAdController {

        @Autowired
        private AdPromotionPositionAdConsumer consumer;

        /**
         * 获取流量主推广广告位对应广告列表
         * @param entity
         * @return
         */
        @ResponseBody
        @RequestMapping(value = "listAdPromotionPositionAdForPage",method={RequestMethod.POST})
        @ApiOperation(value="流量主推广广告位对应广告", notes="流量主推广广告位对应广告")
        public String listAdPromotionPositionAdForPage(@RequestBody AdPromotionPositionAdQuery entity){
            //验证查询参数
            ValidationResult result = ValidationUtil.validateEntity(entity);
             if(!result.isHasErrors()) {
                  PageInfo AdPromotionPositionAds = consumer.listAdPromotionPositionAd(entity);
                  DataGrid dataGrid = new DataGrid(AdPromotionPositionAds.getTotal(),AdPromotionPositionAds.getList(),0);
                  return JsonResultUtil.toJson(ReturnCode.SUCCESS, dataGrid);
             }else{
                  return JsonResultUtil.toJson(ReturnCode.ERROR,result.getErrorMsg());
             }

        }



        /**
         * 获取流量主推广广告位对应广告
         * @param id
         * @return
         */
        @RequestMapping(value = "getAdPromotionPositionAd",method={RequestMethod.POST})
        @ResponseBody
        @ApiOperation(value="流量主推广广告位对应广告", notes="流量主推广广告位对应广告")
        @ApiImplicitParams({
                @ApiImplicitParam(name = "id", value = "流量主推广广告位对应广告id", required = true, dataType = "String", paramType = "body")
        })
        public String getAdPromotionPositionAd(@RequestBody String id){
             return JsonResultUtil.toJson(ReturnCode.SUCCESS,consumer.getAdPromotionPositionAd(id));
        }


        /**
         * 更新或者新增流量主推广广告位对应广告
         * @param entity
         * @return
         */
        @ResponseBody
        @RequestMapping(value = "saveAdPromotionPositionAd",method={RequestMethod.POST})
        @ApiOperation(value="更新或者新增流量主推广广告位对应广告", notes="更新或者新增流量主推广广告位对应广告")
        public String saveAdPromotionPositionAd(@RequestBody AdPromotionPositionAd entity){
            //验证保存参数
            ValidationResult result = ValidationUtil.validateEntity(entity);
            if(!result.isHasErrors()) {
                 Boolean flag = consumer.saveAdPromotionPositionAd(entity);
                 if (flag) {
                     return JsonResultUtil.toJson(ReturnCode.SUCCESS);
                 } else {
                     return JsonResultUtil.toJson(ReturnCode.ERROR);
                 }
            }else{
                return JsonResultUtil.toJson(ReturnCode.ERROR,result.getErrorMsg());
            }
        }


        /**
         * 批量删除流量主推广广告位对应广告
         * @param ids
         * @return
         */
        @RequestMapping(value = "deleteAdPromotionPositionAd",method={RequestMethod.POST})
        @ResponseBody
        @ApiOperation(value="批量删除流量主推广广告位对应广告", notes="批量删除流量主推广广告位对应广告")
        @ApiImplicitParams({
                @ApiImplicitParam(name = "ids", value = "流量主推广广告位对应广告ids", required = true, dataType = "String",paramType="body")
        })
        public String deleteAdPromotionPositionAd(@RequestBody String ids){
            String[]arr=ids.split(",");
            List<String> list=java.util.Arrays.asList(arr);
            Boolean flag=consumer.deleteAdPromotionPositionAd(list);
            if(flag){
                return JsonResultUtil.toJson(ReturnCode.SUCCESS);
            }else{
                return JsonResultUtil.toJson(ReturnCode.ERROR);
            }
        }



}

