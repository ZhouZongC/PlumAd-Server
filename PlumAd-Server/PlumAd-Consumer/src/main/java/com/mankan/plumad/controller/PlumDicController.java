package com.mankan.plumad.controller;


import com.github.pagehelper.PageInfo;
import com.mipay.base.common.constant.enums.ReturnCode;
import com.mipay.base.common.dto.ValidationResult;
import com.mipay.base.util.JsonResultUtil;
import com.mipay.base.util.ValidationUtil;
import com.mankan.plumad.consumer.PlumDicConsumer;
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
import org.springframework.stereotype.Controller;
import com.mankan.plumad.model.PlumDic;
/**
 * <p>
 * 字典表 前端控制器
 * </p>
 *
 * @author lq
 * @since 2019-09-26
 */
@Api(tags = "字典表",description="字典表")
@Controller
@RequestMapping("/plumad/plumDic")
public class PlumDicController {

        @Autowired
        private PlumDicConsumer consumer;

        /**
         * 获取字典表列表
         * @param entity
         * @return
         */
        @ResponseBody
        @RequestMapping(value = "listPlumDicForPage",method={RequestMethod.POST})
        @ApiOperation(value="字典表", notes="字典表")
        public String listPlumDicForPage(@RequestBody PlumDic entity){
            //验证查询参数
            ValidationResult result = ValidationUtil.validateEntity(entity);
             if(!result.isHasErrors()) {
                  PageInfo PlumDics = consumer.listPlumDic(entity);
                  DataGrid dataGrid = new DataGrid(PlumDics.getTotal(),PlumDics.getList(),0);
                  return JsonResultUtil.toJson(ReturnCode.SUCCESS, dataGrid);
             }else{
                  return JsonResultUtil.toJson(ReturnCode.ERROR,result.getErrorMsg());
             }

        }



        /**
         * 获取字典表
         * @param id
         * @return
         */
        @RequestMapping(value = "getPlumDic",method={RequestMethod.POST})
        @ResponseBody
        @ApiOperation(value="字典表", notes="字典表")
        @ApiImplicitParams({
                @ApiImplicitParam(name = "id", value = "字典表id", required = true, dataType = "String", paramType = "body")
        })
        public String getPlumDic(@RequestBody String id){
             return JsonResultUtil.toJson(ReturnCode.SUCCESS,consumer.getPlumDic(id));
        }


//        /**
//         * 更新或者新增字典表
//         * @param entity
//         * @return
//         */
//        @ResponseBody
//        @RequestMapping(value = "savePlumDic",method={RequestMethod.POST})
//        @ApiOperation(value="更新或者新增字典表", notes="更新或者新增字典表")
//        public String savePlumDic(@RequestBody PlumDic entity){
//            //验证保存参数
//            ValidationResult result = ValidationUtil.validateEntity(entity);
//            if(!result.isHasErrors()) {
//                 Boolean flag = consumer.savePlumDic(entity);
//                 if (flag) {
//                     return JsonResultUtil.toJson(ReturnCode.SUCCESS);
//                 } else {
//                     return JsonResultUtil.toJson(ReturnCode.ERROR);
//                 }
//            }else{
//                return JsonResultUtil.toJson(ReturnCode.ERROR,result.getErrorMsg());
//            }
//        }


//        /**
//         * 批量删除字典表
//         * @param ids
//         * @return
//         */
//        @RequestMapping(value = "deletePlumDic",method={RequestMethod.POST})
//        @ResponseBody
//        @ApiOperation(value="批量删除字典表", notes="批量删除字典表")
//        @ApiImplicitParams({
//                @ApiImplicitParam(name = "ids", value = "字典表ids", required = true, dataType = "String",paramType="body")
//        })
//        public String deletePlumDic(@RequestBody String ids){
//            String[]arr=ids.split(",");
//            List<String> list=java.util.Arrays.asList(arr);
//            Boolean flag=consumer.deletePlumDic(list);
//            if(flag){
//                return JsonResultUtil.toJson(ReturnCode.SUCCESS);
//            }else{
//                return JsonResultUtil.toJson(ReturnCode.ERROR);
//            }
//        }



}

