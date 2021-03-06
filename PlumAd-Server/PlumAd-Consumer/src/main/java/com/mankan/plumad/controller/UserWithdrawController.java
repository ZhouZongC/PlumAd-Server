package com.mankan.plumad.controller;


import com.github.pagehelper.PageInfo;
import com.mipay.base.common.constant.enums.ReturnCode;
import com.mipay.base.common.dto.ValidationResult;
import com.mipay.base.util.JsonResultUtil;
import com.mipay.base.util.ValidationUtil;
import com.mankan.plumad.consumer.UserWithdrawConsumer;
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
import com.mankan.plumad.model.UserWithdraw;
import com.mankan.plumad.dto.UserWithdrawQuery;

/**
 * <p>
 * 用户分润提现表 前端控制器
 * </p>
 *
 * @author lq
 * @since 2019-09-24
 */
@Api(tags = "用户分润提现表",description="用户分润提现表")
@Controller
@RequestMapping("/plumad/userWithdraw")
public class UserWithdrawController {

        @Autowired
        private UserWithdrawConsumer consumer;

        /**
         * 获取用户分润提现表列表
         * @param entity
         * @return
         */
        @ResponseBody
        @RequestMapping(value = "listUserWithdrawForPage",method={RequestMethod.POST})
        @ApiOperation(value="用户分润提现表", notes="用户分润提现表")
        public String listUserWithdrawForPage(@RequestBody UserWithdrawQuery entity){
            //验证查询参数
            ValidationResult result = ValidationUtil.validateEntity(entity);
             if(!result.isHasErrors()) {
                  PageInfo UserWithdraws = consumer.listUserWithdraw(entity);
                  DataGrid dataGrid = new DataGrid(UserWithdraws.getTotal(),UserWithdraws.getList(),0);
                  return JsonResultUtil.toJson(ReturnCode.SUCCESS, dataGrid);
             }else{
                  return JsonResultUtil.toJson(ReturnCode.ERROR,result.getErrorMsg());
             }

        }



        /**
         * 获取用户分润提现表
         * @param id
         * @return
         */
        @RequestMapping(value = "getUserWithdraw",method={RequestMethod.POST})
        @ResponseBody
        @ApiOperation(value="用户分润提现表", notes="用户分润提现表")
        @ApiImplicitParams({
                @ApiImplicitParam(name = "id", value = "用户分润提现表id", required = true, dataType = "String", paramType = "body")
        })
        public String getUserWithdraw(@RequestBody String id){
             return JsonResultUtil.toJson(ReturnCode.SUCCESS,consumer.getUserWithdraw(id));
        }


        /**
         * 更新或者新增用户分润提现表
         * @param entity
         * @return
         */
        @ResponseBody
        @RequestMapping(value = "saveUserWithdraw",method={RequestMethod.POST})
        @ApiOperation(value="更新或者新增用户分润提现表", notes="更新或者新增用户分润提现表")
        public String saveUserWithdraw(@RequestBody UserWithdraw entity){
            //验证保存参数
            ValidationResult result = ValidationUtil.validateEntity(entity);
            if(!result.isHasErrors()) {
                 Boolean flag = consumer.saveUserWithdraw(entity);
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
         * 批量删除用户分润提现表
         * @param ids
         * @return
         */
        @RequestMapping(value = "deleteUserWithdraw",method={RequestMethod.POST})
        @ResponseBody
        @ApiOperation(value="批量删除用户分润提现表", notes="批量删除用户分润提现表")
        @ApiImplicitParams({
                @ApiImplicitParam(name = "ids", value = "用户分润提现表ids", required = true, dataType = "String",paramType="body")
        })
        public String deleteUserWithdraw(@RequestBody String ids){
            String[]arr=ids.split(",");
            List<String> list=java.util.Arrays.asList(arr);
            Boolean flag=consumer.deleteUserWithdraw(list);
            if(flag){
                return JsonResultUtil.toJson(ReturnCode.SUCCESS);
            }else{
                return JsonResultUtil.toJson(ReturnCode.ERROR);
            }
        }



}

