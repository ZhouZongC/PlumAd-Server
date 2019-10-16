package com.mankan.plumad.controller;


import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import com.mipay.base.common.constant.enums.ReturnCode;
import com.mipay.base.common.dto.ValidationResult;
import com.mipay.base.util.JsonResultUtil;
import com.mipay.base.util.StringUtil;
import com.mipay.base.util.ValidationUtil;
import com.mankan.plumad.consumer.UserFinanceConsumer;
import com.mankan.plumad.dto.DataGrid;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.http.HttpHeaders;
import com.alibaba.fastjson.TypeReference;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import com.mankan.plumad.model.UserFinance;
import com.mankan.plumad.dto.UserFinanceQuery;
import org.springframework.web.client.RestTemplate;

/**
 * <p>
 * 用户财务表 前端控制器
 * </p>
 *
 * @author lq
 * @since 2019-09-24
 */
@Api(tags = "用户财务表",description="用户财务表")
@Controller
@RequestMapping("/plumad/userFinance")
public class UserFinanceController {

    @Value("${sys.url}")
    private String sysUrl;
    @Autowired
    private UserFinanceConsumer consumer;
    @Autowired
    private RestTemplate restTemplate;

        /**
         * 获取用户财务表列表
         * @param entity
         * @return
         */
        @ResponseBody
        @RequestMapping(value = "listUserFinanceForPage",method={RequestMethod.POST})
        @ApiOperation(value="用户财务表", notes="用户财务表")
        public String listUserFinanceForPage(@RequestBody UserFinanceQuery entity){
            //验证查询参数
            ValidationResult result = ValidationUtil.validateEntity(entity);
             if(!result.isHasErrors()) {
                  PageInfo UserFinances = consumer.listUserFinance(entity);
                  DataGrid dataGrid = new DataGrid(UserFinances.getTotal(),UserFinances.getList(),0);
                  return JsonResultUtil.toJson(ReturnCode.SUCCESS, dataGrid);
             }else{
                  return JsonResultUtil.toJson(ReturnCode.ERROR,result.getErrorMsg());
             }

        }



        /**
         * 获取用户财务表
         * @param id
         * @return
         */
        @RequestMapping(value = "getUserFinance",method={RequestMethod.POST})
        @ResponseBody
        @ApiOperation(value="用户财务表", notes="用户财务表")
        @ApiImplicitParams({
                @ApiImplicitParam(name = "id", value = "用户财务表id", required = true, dataType = "String", paramType = "body")
        })
        public String getUserFinance(@RequestBody String id){
             return JsonResultUtil.toJson(ReturnCode.SUCCESS,consumer.getUserFinance(id));
        }


    /**
     * 更新或者新增用户财务表
     * @param entity
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "saveUserFinance",method={RequestMethod.POST})
    @ApiOperation(value="更新或者新增用户财务表", notes="更新或者新增用户财务表")
    public String saveUserFinance(@RequestBody UserFinance entity){
        //验证保存参数
        ValidationResult result = ValidationUtil.validateEntity(entity);
        if(!result.isHasErrors()) {
            if(!StringUtil.isNotBlank(entity.getId())) {
                Boolean flag = consumer.saveUserFinance(entity);
                if(flag){
                    Map<String, String> map = new HashMap<>();
                    map.put("userid",entity.getUserId());
                    map.put("username",entity.getUsername());
                    map.put("sex",entity.getSex());
                    map.put("email",entity.getEmail());
                    map.put("idcard",entity.getIdCode());
                    map.put("mobile",entity.getPhone());
                    if(entity.getType().equals("L")){
                        map.put("orgid","2c97ca56f1b64721b897b4b0ec0be79a");   // 流量主
                    }else if(entity.getType().equals("G")){
                        map.put("orgid","ca905d743ab94c2097b23eb0be884a31");   // 广告主
                    }else {
                        return JsonResultUtil.toJson(ReturnCode.ERROR);
                    }
                    if(entity.getType().equals("L")){
                        map.put("roleId","1637a5311ab747ffacf4b5e1464b3ce6");   // 流量主
                    }else if(entity.getType().equals("G")){
                        map.put("roleId","63bf2c60bf8a4df9841dd34ea36c983a");   // 广告主
                    }else {
                        return JsonResultUtil.toJson(ReturnCode.ERROR);
                    }
                    map.put("zhanxinCode",entity.getZhanxinCode());

                    HttpHeaders headers = new HttpHeaders();
                    headers.setContentType(MediaType.parseMediaType("application/json; charset=UTF-8"));
                    headers.add("Accept", MediaType.APPLICATION_JSON.toString());
                    HttpEntity<String> formEntity = new HttpEntity(JSON.toJSONString(map), headers);
                    String sresult = restTemplate.postForObject(sysUrl+"synch/synchUser", formEntity, String.class);
                    HashMap resultMap = JSON.parseObject(sresult, new TypeReference<HashMap>() {
                    });
//                    logger.info("返回参数:" + JSON.toJSONString(resultMap));
                    if ("20000".equals(resultMap.get("code").toString())) {
                        return JsonResultUtil.toJson(ReturnCode.SUCCESS);
                    } else {
                        return JsonResultUtil.toJson(ReturnCode.ERROR, "请联系管理员处理");
                    }
                }else {
                    return JsonResultUtil.toJson(ReturnCode.ERROR);
                }
            }else {
                Boolean flag = consumer.saveUserFinance(entity);
                if (flag) {
                    return JsonResultUtil.toJson(ReturnCode.SUCCESS);
                } else {
                    return JsonResultUtil.toJson(ReturnCode.ERROR);
                }
            }
        }else{
            return JsonResultUtil.toJson(ReturnCode.ERROR,result.getErrorMsg());
        }
    }


        /**
         * 批量删除用户财务表
         * @param ids
         * @return
         */
        @RequestMapping(value = "deleteUserFinance",method={RequestMethod.POST})
        @ResponseBody
        @ApiOperation(value="批量删除用户财务表", notes="批量删除用户财务表")
        @ApiImplicitParams({
                @ApiImplicitParam(name = "ids", value = "用户财务表ids", required = true, dataType = "String",paramType="body")
        })
        public String deleteUserFinance(@RequestBody String ids){
            String[]arr=ids.split(",");
            List<String> list=java.util.Arrays.asList(arr);
            Boolean flag=consumer.deleteUserFinance(list);
            if(flag){
                return JsonResultUtil.toJson(ReturnCode.SUCCESS);
            }else{
                return JsonResultUtil.toJson(ReturnCode.ERROR);
            }
        }



}

