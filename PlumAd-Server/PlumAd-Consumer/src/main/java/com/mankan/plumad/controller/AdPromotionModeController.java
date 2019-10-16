package com.mankan.plumad.controller;


import com.github.pagehelper.PageInfo;
import com.mipay.base.common.constant.enums.ReturnCode;
import com.mipay.base.common.dto.ValidationResult;
import com.mipay.base.util.BaseCodeUtil;
import com.mipay.base.util.JsonResultUtil;
import com.mipay.base.util.StringUtil;
import com.mipay.base.util.ValidationUtil;
import com.mankan.plumad.consumer.AdPromotionModeConsumer;
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
import com.mankan.plumad.model.AdPromotionMode;
import com.mankan.plumad.dto.AdPromotionModeQuery;

/**
 * <p>
 * 流量主推广方式 前端控制器
 * </p>
 *
 * @author lq
 * @since 2019-09-24
 */
@Api(tags = "流量主推广方式",description="流量主推广方式")
@Controller
@RequestMapping("/plumad/adPromotionMode")
public class AdPromotionModeController {

        @Autowired
        private AdPromotionModeConsumer consumer;
        @Autowired
        private BaseCodeUtil baseCodeUtil;

        /**
         * 获取流量主推广方式列表
         * @param entity
         * @return
         */
        @ResponseBody
        @RequestMapping(value = "listAdPromotionModeForPage",method={RequestMethod.POST})
        @ApiOperation(value="流量主推广方式", notes="流量主推广方式")
        public String listAdPromotionModeForPage(@RequestBody AdPromotionModeQuery entity){
            //验证查询参数
            ValidationResult result = ValidationUtil.validateEntity(entity);
             if(!result.isHasErrors()) {
                  PageInfo AdPromotionModes = consumer.listAdPromotionMode(entity);
                  DataGrid dataGrid = new DataGrid(AdPromotionModes.getTotal(),AdPromotionModes.getList(),0);
                  return JsonResultUtil.toJson(ReturnCode.SUCCESS, dataGrid);
             }else{
                  return JsonResultUtil.toJson(ReturnCode.ERROR,result.getErrorMsg());
             }

        }



        /**
         * 获取流量主推广方式
         * @param id
         * @return
         */
        @RequestMapping(value = "getAdPromotionMode",method={RequestMethod.POST})
        @ResponseBody
        @ApiOperation(value="流量主推广方式", notes="流量主推广方式")
        @ApiImplicitParams({
                @ApiImplicitParam(name = "id", value = "流量主推广方式id", required = true, dataType = "String", paramType = "body")
        })
        public String getAdPromotionMode(@RequestBody String id){
             return JsonResultUtil.toJson(ReturnCode.SUCCESS,consumer.getAdPromotionMode(id));
        }


        /**
         * 更新或者新增流量主推广方式
         * @param entity
         * @return
         */
        @ResponseBody
        @RequestMapping(value = "saveAdPromotionMode",method={RequestMethod.POST})
        @ApiOperation(value="更新或者新增流量主推广方式", notes="更新或者新增流量主推广方式")
        public String saveAdPromotionMode(@RequestBody AdPromotionMode entity){
            //验证保存参数
            ValidationResult result = ValidationUtil.validateEntity(entity);
            if(!result.isHasErrors()) {
                if(!StringUtil.isNotBlank(entity.getId())) {
                    //自动生成code
                    String code = baseCodeUtil.getCode("CM");
                    //自动填充code
                    entity.setPromotionCode(code);
                }
                 Boolean flag = consumer.saveAdPromotionMode(entity);
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
         * 批量删除流量主推广方式
         * @param ids
         * @return
         */
        @RequestMapping(value = "deleteAdPromotionMode",method={RequestMethod.POST})
        @ResponseBody
        @ApiOperation(value="批量删除流量主推广方式", notes="批量删除流量主推广方式")
        @ApiImplicitParams({
                @ApiImplicitParam(name = "ids", value = "流量主推广方式ids", required = true, dataType = "String",paramType="body")
        })
        public String deleteAdPromotionMode(@RequestBody String ids){
            String[]arr=ids.split(",");
            List<String> list=java.util.Arrays.asList(arr);
            Boolean flag=consumer.deleteAdPromotionMode(list);
            if(flag){
                return JsonResultUtil.toJson(ReturnCode.SUCCESS);
            }else{
                return JsonResultUtil.toJson(ReturnCode.ERROR);
            }
        }



}

