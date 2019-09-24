package com.mankan.plumad.controller;


import com.github.pagehelper.PageInfo;
import com.mipay.base.common.constant.enums.ReturnCode;
import com.mipay.base.common.dto.ValidationResult;
import com.mipay.base.util.JsonResultUtil;
import com.mipay.base.util.ValidationUtil;
import com.mankan.plumad.consumer.AdPromotionInfoConsumer;
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
import com.mankan.plumad.model.AdPromotionInfo;
import com.mankan.plumad.dto.AdPromotionInfoQuery;

/**
 * <p>
 * 广告推广信息 前端控制器
 * </p>
 *
 * @author lq
 * @since 2019-09-24
 */
@Api(tags = "广告推广信息",description="广告推广信息")
@Controller
@RequestMapping("/plumad/adPromotionInfo")
public class AdPromotionInfoController {

        @Autowired
        private AdPromotionInfoConsumer consumer;

        /**
         * 获取广告推广信息列表
         * @param entity
         * @return
         */
        @ResponseBody
        @RequestMapping(value = "listAdPromotionInfoForPage",method={RequestMethod.POST})
        @ApiOperation(value="广告推广信息", notes="广告推广信息")
        public String listAdPromotionInfoForPage(@RequestBody AdPromotionInfoQuery entity){
            //验证查询参数
            ValidationResult result = ValidationUtil.validateEntity(entity);
             if(!result.isHasErrors()) {
                  PageInfo AdPromotionInfos = consumer.listAdPromotionInfo(entity);
                  DataGrid dataGrid = new DataGrid(AdPromotionInfos.getTotal(),AdPromotionInfos.getList(),0);
                  return JsonResultUtil.toJson(ReturnCode.SUCCESS, dataGrid);
             }else{
                  return JsonResultUtil.toJson(ReturnCode.ERROR,result.getErrorMsg());
             }

        }



        /**
         * 获取广告推广信息
         * @param id
         * @return
         */
        @RequestMapping(value = "getAdPromotionInfo",method={RequestMethod.POST})
        @ResponseBody
        @ApiOperation(value="广告推广信息", notes="广告推广信息")
        @ApiImplicitParams({
                @ApiImplicitParam(name = "id", value = "广告推广信息id", required = true, dataType = "String", paramType = "body")
        })
        public String getAdPromotionInfo(@RequestBody String id){
             return JsonResultUtil.toJson(ReturnCode.SUCCESS,consumer.getAdPromotionInfo(id));
        }


        /**
         * 更新或者新增广告推广信息
         * @param entity
         * @return
         */
        @ResponseBody
        @RequestMapping(value = "saveAdPromotionInfo",method={RequestMethod.POST})
        @ApiOperation(value="更新或者新增广告推广信息", notes="更新或者新增广告推广信息")
        public String saveAdPromotionInfo(@RequestBody AdPromotionInfo entity){
            //验证保存参数
            ValidationResult result = ValidationUtil.validateEntity(entity);
            if(!result.isHasErrors()) {
                 Boolean flag = consumer.saveAdPromotionInfo(entity);
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
         * 批量删除广告推广信息
         * @param ids
         * @return
         */
        @RequestMapping(value = "deleteAdPromotionInfo",method={RequestMethod.POST})
        @ResponseBody
        @ApiOperation(value="批量删除广告推广信息", notes="批量删除广告推广信息")
        @ApiImplicitParams({
                @ApiImplicitParam(name = "ids", value = "广告推广信息ids", required = true, dataType = "String",paramType="body")
        })
        public String deleteAdPromotionInfo(@RequestBody String ids){
            String[]arr=ids.split(",");
            List<String> list=java.util.Arrays.asList(arr);
            Boolean flag=consumer.deleteAdPromotionInfo(list);
            if(flag){
                return JsonResultUtil.toJson(ReturnCode.SUCCESS);
            }else{
                return JsonResultUtil.toJson(ReturnCode.ERROR);
            }
        }



}

