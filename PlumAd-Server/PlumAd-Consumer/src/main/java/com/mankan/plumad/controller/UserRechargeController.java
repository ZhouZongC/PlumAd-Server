package com.mankan.plumad.controller;


import com.github.pagehelper.PageInfo;
import com.mipay.base.common.constant.enums.ReturnCode;
import com.mipay.base.common.dto.ValidationResult;
import com.mipay.base.util.JsonResultUtil;
import com.mipay.base.util.ValidationUtil;
import com.mankan.plumad.consumer.UserRechargeConsumer;
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
import com.mankan.plumad.model.UserRecharge;
import com.mankan.plumad.dto.UserRechargeQuery;

/**
 * <p>
 * 用户充值记录表 前端控制器
 * </p>
 *
 * @author lq
 * @since 2019-09-24
 */
@Api(tags = "用户充值记录表",description="用户充值记录表")
@Controller
@RequestMapping("/plumad/userRecharge")
public class UserRechargeController {

        @Autowired
        private UserRechargeConsumer consumer;

        /**
         * 获取用户充值记录表列表
         * @param entity
         * @return
         */
        @ResponseBody
        @RequestMapping(value = "listUserRechargeForPage",method={RequestMethod.POST})
        @ApiOperation(value="用户充值记录表", notes="用户充值记录表")
        public String listUserRechargeForPage(@RequestBody UserRechargeQuery entity){
            //验证查询参数
            ValidationResult result = ValidationUtil.validateEntity(entity);
             if(!result.isHasErrors()) {
                  PageInfo UserRecharges = consumer.listUserRecharge(entity);
                  DataGrid dataGrid = new DataGrid(UserRecharges.getTotal(),UserRecharges.getList(),0);
                  return JsonResultUtil.toJson(ReturnCode.SUCCESS, dataGrid);
             }else{
                  return JsonResultUtil.toJson(ReturnCode.ERROR,result.getErrorMsg());
             }

        }



        /**
         * 获取用户充值记录表
         * @param id
         * @return
         */
        @RequestMapping(value = "getUserRecharge",method={RequestMethod.POST})
        @ResponseBody
        @ApiOperation(value="用户充值记录表", notes="用户充值记录表")
        @ApiImplicitParams({
                @ApiImplicitParam(name = "id", value = "用户充值记录表id", required = true, dataType = "String", paramType = "body")
        })
        public String getUserRecharge(@RequestBody String id){
             return JsonResultUtil.toJson(ReturnCode.SUCCESS,consumer.getUserRecharge(id));
        }


        /**
         * 更新或者新增用户充值记录表
         * @param entity
         * @return
         */
        @ResponseBody
        @RequestMapping(value = "saveUserRecharge",method={RequestMethod.POST})
        @ApiOperation(value="更新或者新增用户充值记录表", notes="更新或者新增用户充值记录表")
        public String saveUserRecharge(@RequestBody UserRecharge entity){
            //验证保存参数
            ValidationResult result = ValidationUtil.validateEntity(entity);
            if(!result.isHasErrors()) {
                 Boolean flag = consumer.saveUserRecharge(entity);
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
         * 批量删除用户充值记录表
         * @param ids
         * @return
         */
        @RequestMapping(value = "deleteUserRecharge",method={RequestMethod.POST})
        @ResponseBody
        @ApiOperation(value="批量删除用户充值记录表", notes="批量删除用户充值记录表")
        @ApiImplicitParams({
                @ApiImplicitParam(name = "ids", value = "用户充值记录表ids", required = true, dataType = "String",paramType="body")
        })
        public String deleteUserRecharge(@RequestBody String ids){
            String[]arr=ids.split(",");
            List<String> list=java.util.Arrays.asList(arr);
            Boolean flag=consumer.deleteUserRecharge(list);
            if(flag){
                return JsonResultUtil.toJson(ReturnCode.SUCCESS);
            }else{
                return JsonResultUtil.toJson(ReturnCode.ERROR);
            }
        }



}

