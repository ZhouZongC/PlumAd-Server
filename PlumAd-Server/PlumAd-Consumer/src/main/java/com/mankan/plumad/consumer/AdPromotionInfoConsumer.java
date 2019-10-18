package com.mankan.plumad.consumer;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.github.pagehelper.PageInfo;
import com.mankan.plumad.dubbo.AdPromotionInfoApi;
import org.springframework.stereotype.Component;
import com.mankan.plumad.model.AdPromotionInfo;
import com.alibaba.dubbo.config.annotation.Reference;
import com.mankan.plumad.dto.AdPromotionInfoQuery;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Collection;

/**
 * <p>
 * 广告推广信息 api接口
 * </p>
 *
 * @author lq
 * @since 2019-09-24
 */
@Component
public class AdPromotionInfoConsumer {

    @Reference(version = "1.0.0",
            application = "${dubbo.application.id}",
            cluster = "failover",
            check = false,
            retries = 3,
            timeout = 15000)
    private AdPromotionInfoApi dubboApi;

    /**
     * 获取广告推广信息
     * @param entityQuery
     * @return
     */
    public PageInfo listAdPromotionInfo(AdPromotionInfoQuery entityQuery){
        AdPromotionInfo entity = JSON.parseObject(JSON.toJSONString(entityQuery), new TypeReference<AdPromotionInfo>() {});
        return dubboApi.listAdPromotionInfo(entity,entityQuery.getPageNum(),entityQuery.getPageSize());
    }


    /**
     * 获取广告推广信息 按排序
     * @param entityQuery
     * @return
     */
    public PageInfo listAdPromotionInfoWithOrderBy(AdPromotionInfoQuery entityQuery,Collection<String> columns,Boolean isAsc){
        AdPromotionInfo entity = JSON.parseObject(JSON.toJSONString(entityQuery), new TypeReference<AdPromotionInfo>() {});
        return dubboApi.listAdPromotionInfoWithOrderBy(entity,columns,isAsc,entityQuery.getPageNum(),entityQuery.getPageSize());
    }

    /**
     * 通过条件查询广告推广信息
     * @param entity
     * @return
     */
    public  AdPromotionInfo getAdPromotionInfoByCondition(AdPromotionInfo entity){
        return dubboApi.getAdPromotionInfoByCondition(entity);
    }

    /**
     * 通过id查询广告推广信息
     * @param id
     * @return
     */
    public  AdPromotionInfo getAdPromotionInfo(String id){
        return dubboApi.getAdPromotionInfo(id);
    }

    /**
     * 保存或者新增广告推广信息
     * @param entity
     * @return
     */
    public Boolean saveAdPromotionInfo(AdPromotionInfo entity){
        return dubboApi.saveAdPromotionInfo(entity);
    }


    /**
     * 删除广告推广信息
     * @param idlist
     * @return
     */
    public Boolean deleteAdPromotionInfo(List<String> idlist){
        return dubboApi.deleteAdPromotionInfo(idlist);
    }

    /**
     * 根据广告位编码查询广告推广信息
     */
    public PageInfo listAdvertisingDisplay(@RequestBody String positionCode){
        return dubboApi.listAdvertisingDisplay(positionCode);
    }
}
