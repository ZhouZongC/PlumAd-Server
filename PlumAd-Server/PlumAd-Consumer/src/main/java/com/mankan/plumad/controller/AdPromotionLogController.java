package com.mankan.plumad.controller;


import com.github.pagehelper.PageInfo;
import com.mipay.base.common.constant.enums.ReturnCode;
import com.mipay.base.common.dto.ValidationResult;
import com.mipay.base.util.JsonResultUtil;
import com.mipay.base.util.ValidationUtil;
import com.mankan.plumad.consumer.AdPromotionLogConsumer;
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
import com.mankan.plumad.model.AdPromotionLog;
import com.mankan.plumad.dto.AdPromotionLogQuery;

/**
 * <p>
 * 流量主推广日志 前端控制器
 * </p>
 *
 * @author lq
 * @since 2019-09-24
 */
@Api(tags = "流量主推广日志",description="流量主推广日志")
@Controller
@RequestMapping("/plumad/adPromotionLog")
public class AdPromotionLogController {

        @Autowired
        private AdPromotionLogConsumer consumer;

        /**
         * 获取流量主推广日志列表
         * @param entity
         * @return
         */
        @ResponseBody
        @RequestMapping(value = "listAdPromotionLogForPage",method={RequestMethod.POST})
        @ApiOperation(value="流量主推广日志", notes="流量主推广日志")
        public String listAdPromotionLogForPage(@RequestBody AdPromotionLogQuery entity){
            //验证查询参数
            ValidationResult result = ValidationUtil.validateEntity(entity);
             if(!result.isHasErrors()) {
                  PageInfo AdPromotionLogs = consumer.listAdPromotionLog(entity);
                  DataGrid dataGrid = new DataGrid(AdPromotionLogs.getTotal(),AdPromotionLogs.getList(),0);
                  return JsonResultUtil.toJson(ReturnCode.SUCCESS, dataGrid);
             }else{
                  return JsonResultUtil.toJson(ReturnCode.ERROR,result.getErrorMsg());
             }

        }



        /**
         * 获取流量主推广日志
         * @param id
         * @return
         */
        @RequestMapping(value = "getAdPromotionLog",method={RequestMethod.POST})
        @ResponseBody
        @ApiOperation(value="流量主推广日志", notes="流量主推广日志")
        @ApiImplicitParams({
                @ApiImplicitParam(name = "id", value = "流量主推广日志id", required = true, dataType = "String", paramType = "body")
        })
        public String getAdPromotionLog(@RequestBody String id){
             return JsonResultUtil.toJson(ReturnCode.SUCCESS,consumer.getAdPromotionLog(id));
        }


        /**
         * 更新或者新增流量主推广日志
         * @param entity
         * @return
         */
        @ResponseBody
        @RequestMapping(value = "saveAdPromotionLog",method={RequestMethod.POST})
        @ApiOperation(value="更新或者新增流量主推广日志", notes="更新或者新增流量主推广日志")
        public String saveAdPromotionLog(@RequestBody AdPromotionLog entity){
            //验证保存参数
            ValidationResult result = ValidationUtil.validateEntity(entity);
            if(!result.isHasErrors()) {
                 Boolean flag = consumer.saveAdPromotionLog(entity);
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
         * 批量删除流量主推广日志
         * @param ids
         * @return
         */
        @RequestMapping(value = "deleteAdPromotionLog",method={RequestMethod.POST})
        @ResponseBody
        @ApiOperation(value="批量删除流量主推广日志", notes="批量删除流量主推广日志")
        @ApiImplicitParams({
                @ApiImplicitParam(name = "ids", value = "流量主推广日志ids", required = true, dataType = "String",paramType="body")
        })
        public String deleteAdPromotionLog(@RequestBody String ids){
            String[]arr=ids.split(",");
            List<String> list=java.util.Arrays.asList(arr);
            Boolean flag=consumer.deleteAdPromotionLog(list);
            if(flag){
                return JsonResultUtil.toJson(ReturnCode.SUCCESS);
            }else{
                return JsonResultUtil.toJson(ReturnCode.ERROR);
            }
        }



}

