package com.mankan.plumad.controller;


import com.github.pagehelper.PageInfo;
import com.mipay.base.common.constant.enums.ReturnCode;
import com.mipay.base.common.dto.ValidationResult;
import com.mipay.base.util.JsonResultUtil;
import com.mipay.base.util.ValidationUtil;
import com.mankan.plumad.consumer.AdPromotionPositionConsumer;
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
import com.mankan.plumad.model.AdPromotionPosition;
import com.mankan.plumad.dto.AdPromotionPositionQuery;

/**
 * <p>
 * 流量主推广广告位 前端控制器
 * </p>
 *
 * @author lq
 * @since 2019-09-24
 */
@Api(tags = "流量主推广广告位",description="流量主推广广告位")
@Controller
@RequestMapping("/plumad/adPromotionPosition")
public class AdPromotionPositionController {

        @Autowired
        private AdPromotionPositionConsumer consumer;

        /**
         * 获取流量主推广广告位列表
         * @param entity
         * @return
         */
        @ResponseBody
        @RequestMapping(value = "listAdPromotionPositionForPage",method={RequestMethod.POST})
        @ApiOperation(value="流量主推广广告位", notes="流量主推广广告位")
        public String listAdPromotionPositionForPage(@RequestBody AdPromotionPositionQuery entity){
            //验证查询参数
            ValidationResult result = ValidationUtil.validateEntity(entity);
             if(!result.isHasErrors()) {
                  PageInfo AdPromotionPositions = consumer.listAdPromotionPosition(entity);
                  DataGrid dataGrid = new DataGrid(AdPromotionPositions.getTotal(),AdPromotionPositions.getList(),0);
                  return JsonResultUtil.toJson(ReturnCode.SUCCESS, dataGrid);
             }else{
                  return JsonResultUtil.toJson(ReturnCode.ERROR,result.getErrorMsg());
             }

        }



        /**
         * 获取流量主推广广告位
         * @param id
         * @return
         */
        @RequestMapping(value = "getAdPromotionPosition",method={RequestMethod.POST})
        @ResponseBody
        @ApiOperation(value="流量主推广广告位", notes="流量主推广广告位")
        @ApiImplicitParams({
                @ApiImplicitParam(name = "id", value = "流量主推广广告位id", required = true, dataType = "String", paramType = "body")
        })
        public String getAdPromotionPosition(@RequestBody String id){
             return JsonResultUtil.toJson(ReturnCode.SUCCESS,consumer.getAdPromotionPosition(id));
        }


        /**
         * 更新或者新增流量主推广广告位
         * @param entity
         * @return
         */
        @ResponseBody
        @RequestMapping(value = "saveAdPromotionPosition",method={RequestMethod.POST})
        @ApiOperation(value="更新或者新增流量主推广广告位", notes="更新或者新增流量主推广广告位")
        public String saveAdPromotionPosition(@RequestBody AdPromotionPosition entity){
            //验证保存参数
            ValidationResult result = ValidationUtil.validateEntity(entity);
            if(!result.isHasErrors()) {
                 Boolean flag = consumer.saveAdPromotionPosition(entity);
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
         * 批量删除流量主推广广告位
         * @param ids
         * @return
         */
        @RequestMapping(value = "deleteAdPromotionPosition",method={RequestMethod.POST})
        @ResponseBody
        @ApiOperation(value="批量删除流量主推广广告位", notes="批量删除流量主推广广告位")
        @ApiImplicitParams({
                @ApiImplicitParam(name = "ids", value = "流量主推广广告位ids", required = true, dataType = "String",paramType="body")
        })
        public String deleteAdPromotionPosition(@RequestBody String ids){
            String[]arr=ids.split(",");
            List<String> list=java.util.Arrays.asList(arr);
            Boolean flag=consumer.deleteAdPromotionPosition(list);
            if(flag){
                return JsonResultUtil.toJson(ReturnCode.SUCCESS);
            }else{
                return JsonResultUtil.toJson(ReturnCode.ERROR);
            }
        }



}

