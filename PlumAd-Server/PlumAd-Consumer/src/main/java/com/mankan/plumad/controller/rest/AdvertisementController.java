package com.mankan.plumad.controller.rest;

import com.github.pagehelper.PageInfo;
import com.mankan.plumad.consumer.AdvertisementConsumer;
import com.mankan.plumad.dto.DataGrid;
import com.mipay.base.common.constant.enums.ReturnCode;
import com.mipay.base.util.JsonResultUtil;
import com.mipay.base.util.StringUtil;
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
 * 广告 前端控制器
 * </p>
 *
 * @author lq
 * @since 2018-09-28
 */
@Controller
@RequestMapping("/jianzhi/addressCode")
@Api(tags="广告",description="广告")
public class AdvertisementController {

    @Autowired
    private AdvertisementConsumer advertisementConsumer;

    /**
     * 获取广告信息列表
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "listAdvertisementForPage",method={RequestMethod.POST})
    @ApiOperation(value="获取广告信息列表", notes="获取广告信息列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "流量主推广广告位ID", required = true, dataType = "String", paramType = "body")
    })
    public String listAdvertisementForPage(@RequestBody String id){
        if(StringUtil.isNotEmpty(id)) {
            PageInfo advertisement = advertisementConsumer.listAdvertisement(id);
            DataGrid dataGrid = new DataGrid(advertisement.getTotal(),advertisement.getList(),0);
            return JsonResultUtil.toJson(ReturnCode.SUCCESS, dataGrid);
        }else{
            return JsonResultUtil.toJson(ReturnCode.ERROR,"请求参数有误");
        }
    }
}
