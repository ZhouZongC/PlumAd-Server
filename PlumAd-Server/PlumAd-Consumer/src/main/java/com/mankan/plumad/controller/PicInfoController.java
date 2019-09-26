package com.mankan.plumad.controller;


import com.github.pagehelper.PageInfo;
import com.mipay.base.common.constant.enums.ReturnCode;
import com.mipay.base.common.dto.ValidationResult;
import com.mipay.base.util.JsonResultUtil;
import com.mipay.base.util.ValidationUtil;
import com.mankan.plumad.consumer.PicInfoConsumer;
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
import com.mankan.plumad.model.PicInfo;
import com.mankan.plumad.dto.PicInfoQuery;

/**
 * <p>
 * 图片文件表 前端控制器
 * </p>
 *
 * @author lq
 * @since 2019-09-26
 */
@Api(tags = "图片文件表",description="图片文件表")
@Controller
@RequestMapping("/plumad/picInfo")
public class PicInfoController {

        @Autowired
        private PicInfoConsumer consumer;

        /**
         * 获取图片文件表列表
         * @param entity
         * @return
         */
        @ResponseBody
        @RequestMapping(value = "listPicInfoForPage",method={RequestMethod.POST})
        @ApiOperation(value="图片文件表", notes="图片文件表")
        public String listPicInfoForPage(@RequestBody PicInfoQuery entity){
            //验证查询参数
            ValidationResult result = ValidationUtil.validateEntity(entity);
             if(!result.isHasErrors()) {
                  PageInfo PicInfos = consumer.listPicInfo(entity);
                  DataGrid dataGrid = new DataGrid(PicInfos.getTotal(),PicInfos.getList(),0);
                  return JsonResultUtil.toJson(ReturnCode.SUCCESS, dataGrid);
             }else{
                  return JsonResultUtil.toJson(ReturnCode.ERROR,result.getErrorMsg());
             }

        }



        /**
         * 获取图片文件表
         * @param id
         * @return
         */
        @RequestMapping(value = "getPicInfo",method={RequestMethod.POST})
        @ResponseBody
        @ApiOperation(value="图片文件表", notes="图片文件表")
        @ApiImplicitParams({
                @ApiImplicitParam(name = "id", value = "图片文件表id", required = true, dataType = "String", paramType = "body")
        })
        public String getPicInfo(@RequestBody String id){
             return JsonResultUtil.toJson(ReturnCode.SUCCESS,consumer.getPicInfo(id));
        }


        /**
         * 更新或者新增图片文件表
         * @param entity
         * @return
         */
        @ResponseBody
        @RequestMapping(value = "savePicInfo",method={RequestMethod.POST})
        @ApiOperation(value="更新或者新增图片文件表", notes="更新或者新增图片文件表")
        public String savePicInfo(@RequestBody PicInfo entity){
            //验证保存参数
            ValidationResult result = ValidationUtil.validateEntity(entity);
            if(!result.isHasErrors()) {
                 Boolean flag = consumer.savePicInfo(entity);
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
         * 批量删除图片文件表
         * @param ids
         * @return
         */
        @RequestMapping(value = "deletePicInfo",method={RequestMethod.POST})
        @ResponseBody
        @ApiOperation(value="批量删除图片文件表", notes="批量删除图片文件表")
        @ApiImplicitParams({
                @ApiImplicitParam(name = "ids", value = "图片文件表ids", required = true, dataType = "String",paramType="body")
        })
        public String deletePicInfo(@RequestBody String ids){
            String[]arr=ids.split(",");
            List<String> list=java.util.Arrays.asList(arr);
            Boolean flag=consumer.deletePicInfo(list);
            if(flag){
                return JsonResultUtil.toJson(ReturnCode.SUCCESS);
            }else{
                return JsonResultUtil.toJson(ReturnCode.ERROR);
            }
        }



}

