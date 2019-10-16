package com.mankan.plumad.controller;


import com.github.pagehelper.PageInfo;
import com.mipay.base.common.constant.enums.ReturnCode;
import com.mipay.base.common.dto.ValidationResult;
import com.mipay.base.util.BaseCodeUtil;
import com.mipay.base.util.JsonResultUtil;
import com.mipay.base.util.StringUtil;
import com.mipay.base.util.ValidationUtil;
import com.mankan.plumad.consumer.AdPromotionPlanConsumer;
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
import com.mankan.plumad.model.AdPromotionPlan;
import com.mankan.plumad.dto.AdPromotionPlanQuery;

/**
 * <p>
 * 广告推广计划 前端控制器
 * </p>
 *
 * @author lq
 * @since 2019-09-24
 */
@Api(tags = "广告推广计划",description="广告推广计划")
@Controller
@RequestMapping("/plumad/adPromotionPlan")
public class AdPromotionPlanController {

        @Autowired
        private AdPromotionPlanConsumer consumer;
        @Autowired
        private BaseCodeUtil baseCodeUtil;

        /**
         * 获取广告推广计划列表
         * @param entity
         * @return
         */
        @ResponseBody
        @RequestMapping(value = "listAdPromotionPlanForPage",method={RequestMethod.POST})
        @ApiOperation(value="广告推广计划", notes="广告推广计划")
        public String listAdPromotionPlanForPage(@RequestBody AdPromotionPlanQuery entity){
            //验证查询参数
            ValidationResult result = ValidationUtil.validateEntity(entity);
             if(!result.isHasErrors()) {
                  PageInfo AdPromotionPlans = consumer.listAdPromotionPlan(entity);
                  DataGrid dataGrid = new DataGrid(AdPromotionPlans.getTotal(),AdPromotionPlans.getList(),0);
                  return JsonResultUtil.toJson(ReturnCode.SUCCESS, dataGrid);
             }else{
                  return JsonResultUtil.toJson(ReturnCode.ERROR,result.getErrorMsg());
             }

        }



        /**
         * 获取广告推广计划
         * @param id
         * @return
         */
        @RequestMapping(value = "getAdPromotionPlan",method={RequestMethod.POST})
        @ResponseBody
        @ApiOperation(value="广告推广计划", notes="广告推广计划")
        @ApiImplicitParams({
                @ApiImplicitParam(name = "id", value = "广告推广计划id", required = true, dataType = "String", paramType = "body")
        })
        public String getAdPromotionPlan(@RequestBody String id){
             return JsonResultUtil.toJson(ReturnCode.SUCCESS,consumer.getAdPromotionPlan(id));
        }


        /**
         * 更新或者新增广告推广计划
         * @param entity
         * @return
         */
        @ResponseBody
        @RequestMapping(value = "saveAdPromotionPlan",method={RequestMethod.POST})
        @ApiOperation(value="更新或者新增广告推广计划", notes="更新或者新增广告推广计划")
        public String saveAdPromotionPlan(@RequestBody AdPromotionPlan entity){
            //验证保存参数
            ValidationResult result = ValidationUtil.validateEntity(entity);
            if(!result.isHasErrors()) {
                if(!StringUtil.isNotBlank(entity.getId())) {
                    //自动生成code
                    String code = baseCodeUtil.getCode("CM");
                    //自动填充code
                    entity.setPlanCode(code);
                }
                 Boolean flag = consumer.saveAdPromotionPlan(entity);
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
         * 批量删除广告推广计划
         * @param ids
         * @return
         */
        @RequestMapping(value = "deleteAdPromotionPlan",method={RequestMethod.POST})
        @ResponseBody
        @ApiOperation(value="批量删除广告推广计划", notes="批量删除广告推广计划")
        @ApiImplicitParams({
                @ApiImplicitParam(name = "ids", value = "广告推广计划ids", required = true, dataType = "String",paramType="body")
        })
        public String deleteAdPromotionPlan(@RequestBody String ids){
            String[]arr=ids.split(",");
            List<String> list=java.util.Arrays.asList(arr);
            Boolean flag=consumer.deleteAdPromotionPlan(list);
            if(flag){
                return JsonResultUtil.toJson(ReturnCode.SUCCESS);
            }else{
                return JsonResultUtil.toJson(ReturnCode.ERROR);
            }
        }



}

