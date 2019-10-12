package com.mankan.plumad.controller;


import com.mankan.plumad.consumer.AddressCodeConsumer;
import com.mipay.base.common.constant.enums.ReturnCode;
import com.mipay.base.util.JsonResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * <p>
 * 地址字典表 前端控制器
 * </p>
 *
 * @author lq
 * @since 2018-09-28
 */
@Controller
@RequestMapping("/jianzhi/addressCode")
@Api(tags="地址字典表管理",description="地址字典表管理")
public class AddressCodeController {
    @Autowired
    private AddressCodeConsumer addressCodeConsumer;


    /**
     * 获取省份编码列表
     * @return
     */
    @RequestMapping(value = "getAddressCodeProvince",method={RequestMethod.POST})
    @ResponseBody
    @ApiOperation(value="省编码列表", notes="省编码列表")
    public String getAddressCodeProvince(){
        return JsonResultUtil.toJson(ReturnCode.SUCCESS, addressCodeConsumer.getAddressCodeProvince("1"));
    }

    /**
     * 获取市编码列表
     * @return
     */
    @RequestMapping(value = "getAddressCodeCity",method={RequestMethod.POST})
    @ResponseBody
    @ApiOperation(value="市编码列表", notes="市编码列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "code", value = "市编码列表", required = true, dataType = "String", paramType = "body")
    })
    public String getAddressCodeCity(@RequestBody String code){
        return JsonResultUtil.toJson(ReturnCode.SUCCESS, addressCodeConsumer.getAddressCodeCity(code));
    }

    /**
     * 获取区编码列表
     * @return
     */
    @RequestMapping(value = "getAddressCodeCountry",method={RequestMethod.POST})
    @ResponseBody
    @ApiOperation(value="区编码列表", notes="区编码列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "code", value = "区编码列表", required = true, dataType = "String", paramType = "body")
    })
    public String getAddressCodeCountry(@RequestBody String code){
        return JsonResultUtil.toJson(ReturnCode.SUCCESS, addressCodeConsumer.getAddressCodeCountry(code));
    }


    /**
     * 根据编码获取地区
     * @return
     */
    @RequestMapping(value = "getAddressCodeByCode",method={RequestMethod.POST})
    @ResponseBody
    @ApiOperation(value="根据编码获取地区", notes="根据编码获取地区")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "code", value = "编码", required = true, dataType = "String", paramType = "body")
    })
    public String getAddressCodeByCode(@RequestBody String code){
        return JsonResultUtil.toJson(ReturnCode.SUCCESS, addressCodeConsumer.getAddressCodeByCode(code));
    }
}

