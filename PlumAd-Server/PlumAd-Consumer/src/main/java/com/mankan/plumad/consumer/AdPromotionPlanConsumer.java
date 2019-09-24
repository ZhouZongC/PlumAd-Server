package com.mankan.plumad.consumer;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.github.pagehelper.PageInfo;
import com.mankan.plumad.dubbo.AdPromotionPlanApi;
import org.springframework.stereotype.Component;
import com.mankan.plumad.model.AdPromotionPlan;
import com.alibaba.dubbo.config.annotation.Reference;
import com.mankan.plumad.dto.AdPromotionPlanQuery;


import java.util.List;
import java.util.Collection;

/**
 * <p>
 * 广告推广计划 api接口
 * </p>
 *
 * @author lq
 * @since 2019-09-24
 */
@Component
public class AdPromotionPlanConsumer {

    @Reference(version = "1.0.0",
            application = "${dubbo.application.id}",
            cluster = "failover",
            check = false,
            retries = 3,
            timeout = 15000)
    private AdPromotionPlanApi dubboApi;

    /**
     * 获取广告推广计划
     * @param entityQuery
     * @return
     */
    public PageInfo listAdPromotionPlan(AdPromotionPlanQuery entityQuery){
        AdPromotionPlan entity = JSON.parseObject(JSON.toJSONString(entityQuery), new TypeReference<AdPromotionPlan>() {});
        return dubboApi.listAdPromotionPlan(entity,entityQuery.getPageNum(),entityQuery.getPageSize());
    }


    /**
     * 获取广告推广计划 按排序
     * @param entityQuery
     * @return
     */
    public PageInfo listAdPromotionPlanWithOrderBy(AdPromotionPlanQuery entityQuery,Collection<String> columns,Boolean isAsc){
        AdPromotionPlan entity = JSON.parseObject(JSON.toJSONString(entityQuery), new TypeReference<AdPromotionPlan>() {});
        return dubboApi.listAdPromotionPlanWithOrderBy(entity,columns,isAsc,entityQuery.getPageNum(),entityQuery.getPageSize());
    }

    /**
     * 通过条件查询广告推广计划
     * @param entity
     * @return
     */
    public  AdPromotionPlan getAdPromotionPlanByCondition(AdPromotionPlan entity){
        return dubboApi.getAdPromotionPlanByCondition(entity);
    }

    /**
     * 通过id查询广告推广计划
     * @param id
     * @return
     */
    public  AdPromotionPlan getAdPromotionPlan(String id){
        return dubboApi.getAdPromotionPlan(id);
    }

    /**
     * 保存或者新增广告推广计划
     * @param entity
     * @return
     */
    public Boolean saveAdPromotionPlan(AdPromotionPlan entity){
        return dubboApi.saveAdPromotionPlan(entity);
    }


    /**
     * 删除广告推广计划
     * @param idlist
     * @return
     */
    public Boolean deleteAdPromotionPlan(List<String> idlist){
        return dubboApi.deleteAdPromotionPlan(idlist);
    }

}
