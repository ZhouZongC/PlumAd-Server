package com.mankan.plumad.dubbo;

import com.github.pagehelper.PageInfo;
import com.mankan.plumad.model.AdPromotionPlan;

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
public class AdPromotionPlanApiMock implements AdPromotionPlanApi {

    @Override
    public PageInfo listAdPromotionPlan(AdPromotionPlan entity,int pageNum, int pageSize){
        return null;
    }

    @Override
    public PageInfo listAdPromotionPlanWithOrderBy(AdPromotionPlan entity,Collection<String> columns,Boolean isAsc,int pageNum, int pageSize){
        return null;
    }

    @Override
    public AdPromotionPlan getAdPromotionPlanByCondition(AdPromotionPlan entity){
        return null;
    }

    @Override
    public AdPromotionPlan getAdPromotionPlan(String id){
        return null;
    }

    @Override
    public Boolean saveAdPromotionPlan(AdPromotionPlan entity){
        return null;
    }

    @Override
    public Boolean deleteAdPromotionPlan(List<String> idlist){
        return null;
    }

}