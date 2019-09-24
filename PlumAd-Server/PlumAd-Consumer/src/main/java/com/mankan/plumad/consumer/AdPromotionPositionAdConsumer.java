package com.mankan.plumad.consumer;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.github.pagehelper.PageInfo;
import com.mankan.plumad.dubbo.AdPromotionPositionAdApi;
import org.springframework.stereotype.Component;
import com.mankan.plumad.model.AdPromotionPositionAd;
import com.alibaba.dubbo.config.annotation.Reference;
import com.mankan.plumad.dto.AdPromotionPositionAdQuery;


import java.util.List;
import java.util.Collection;

/**
 * <p>
 * 流量主推广广告位对应广告 api接口
 * </p>
 *
 * @author lq
 * @since 2019-09-24
 */
@Component
public class AdPromotionPositionAdConsumer {

    @Reference(version = "1.0.0",
            application = "${dubbo.application.id}",
            cluster = "failover",
            check = false,
            retries = 3,
            timeout = 15000)
    private AdPromotionPositionAdApi dubboApi;

    /**
     * 获取流量主推广广告位对应广告
     * @param entityQuery
     * @return
     */
    public PageInfo listAdPromotionPositionAd(AdPromotionPositionAdQuery entityQuery){
        AdPromotionPositionAd entity = JSON.parseObject(JSON.toJSONString(entityQuery), new TypeReference<AdPromotionPositionAd>() {});
        return dubboApi.listAdPromotionPositionAd(entity,entityQuery.getPageNum(),entityQuery.getPageSize());
    }


    /**
     * 获取流量主推广广告位对应广告 按排序
     * @param entityQuery
     * @return
     */
    public PageInfo listAdPromotionPositionAdWithOrderBy(AdPromotionPositionAdQuery entityQuery,Collection<String> columns,Boolean isAsc){
        AdPromotionPositionAd entity = JSON.parseObject(JSON.toJSONString(entityQuery), new TypeReference<AdPromotionPositionAd>() {});
        return dubboApi.listAdPromotionPositionAdWithOrderBy(entity,columns,isAsc,entityQuery.getPageNum(),entityQuery.getPageSize());
    }

    /**
     * 通过条件查询流量主推广广告位对应广告
     * @param entity
     * @return
     */
    public  AdPromotionPositionAd getAdPromotionPositionAdByCondition(AdPromotionPositionAd entity){
        return dubboApi.getAdPromotionPositionAdByCondition(entity);
    }

    /**
     * 通过id查询流量主推广广告位对应广告
     * @param id
     * @return
     */
    public  AdPromotionPositionAd getAdPromotionPositionAd(String id){
        return dubboApi.getAdPromotionPositionAd(id);
    }

    /**
     * 保存或者新增流量主推广广告位对应广告
     * @param entity
     * @return
     */
    public Boolean saveAdPromotionPositionAd(AdPromotionPositionAd entity){
        return dubboApi.saveAdPromotionPositionAd(entity);
    }


    /**
     * 删除流量主推广广告位对应广告
     * @param idlist
     * @return
     */
    public Boolean deleteAdPromotionPositionAd(List<String> idlist){
        return dubboApi.deleteAdPromotionPositionAd(idlist);
    }

}
