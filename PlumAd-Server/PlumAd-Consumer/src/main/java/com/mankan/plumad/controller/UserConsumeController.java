package com.mankan.plumad.controller;


import com.github.pagehelper.PageInfo;
import com.mipay.base.common.constant.enums.ReturnCode;
import com.mipay.base.common.dto.ValidationResult;
import com.mipay.base.util.JsonResultUtil;
import com.mipay.base.util.ValidationUtil;
import com.mankan.plumad.consumer.UserConsumeConsumer;
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
import com.mankan.plumad.model.UserConsume;
import com.mankan.plumad.dto.UserConsumeQuery;

/**
 * <p>
 * 用户分润提现表 前端控制器
 * </p>
 *
 * @author lq
 * @since 2019-10-14
 */
@Api(tags = "用户分润提现表",description="用户分润提现表")
@Controller
@RequestMapping("/plumad/userConsume")
public class UserConsumeController {

        @Autowired
        private UserConsumeConsumer consumer;

        /**
         * 获取用户分润提现表列表
         * @param entity
         * @return
         */
        @ResponseBody
        @RequestMapping(value = "listUserConsumeForPage",method={RequestMethod.POST})
        @ApiOperation(value="用户分润提现表", notes="用户分润提现表")
        public String listUserConsumeForPage(@RequestBody UserConsumeQuery entity){
            //验证查询参数
            ValidationResult result = ValidationUtil.validateEntity(entity);
             if(!result.isHasErrors()) {
                  PageInfo UserConsumes = consumer.listUserConsume(entity);
                  DataGrid dataGrid = new DataGrid(UserConsumes.getTotal(),UserConsumes.getList(),0);
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
        @RequestMapping(value = "getUserConsume",method={RequestMethod.POST})
        @ResponseBody
        @ApiOperation(value="用户分润提现表", notes="用户分润提现表")
        @ApiImplicitParams({
                @ApiImplicitParam(name = "id", value = "用户分润提现表id", required = true, dataType = "String", paramType = "body")
        })
        public String getUserConsume(@RequestBody String id){
             return JsonResultUtil.toJson(ReturnCode.SUCCESS,consumer.getUserConsume(id));
        }


        /**
         * 更新或者新增用户分润提现表
         * @param entity
         * @return
         */
        @ResponseBody
        @RequestMapping(value = "saveUserConsume",method={RequestMethod.POST})
        @ApiOperation(value="更新或者新增用户分润提现表", notes="更新或者新增用户分润提现表")
        public String saveUserConsume(@RequestBody UserConsume entity){
            //验证保存参数
            ValidationResult result = ValidationUtil.validateEntity(entity);
            if(!result.isHasErrors()) {
                 Boolean flag = consumer.saveUserConsume(entity);
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
        @RequestMapping(value = "deleteUserConsume",method={RequestMethod.POST})
        @ResponseBody
        @ApiOperation(value="批量删除用户分润提现表", notes="批量删除用户分润提现表")
        @ApiImplicitParams({
                @ApiImplicitParam(name = "ids", value = "用户分润提现表ids", required = true, dataType = "String",paramType="body")
        })
        public String deleteUserConsume(@RequestBody String ids){
            String[]arr=ids.split(",");
            List<String> list=java.util.Arrays.asList(arr);
            Boolean flag=consumer.deleteUserConsume(list);
            if(flag){
                return JsonResultUtil.toJson(ReturnCode.SUCCESS);
            }else{
                return JsonResultUtil.toJson(ReturnCode.ERROR);
            }
        }



}

