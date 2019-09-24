package com.mankan.plumad.provider;

import com.github.pagehelper.PageInfo;
import com.mankan.plumad.dubbo.AdPromotionPlanApi;
import com.mankan.plumad.model.AdPromotionPlan;
import com.mankan.plumad.service.IAdPromotionPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;


import java.util.List;
import java.util.Collection;

/**
 * <p>
 * 广告推广计划 provider
 * </p>
 *
 * @author lq
 * @since 2019-09-24
 */
@Service(version = "1.0.0",
        application = "${dubbo.application.id}",
        protocol = "${dubbo.protocol.id}",
        registry = "${dubbo.registry.id}")
public class AdPromotionPlanProvider implements AdPromotionPlanApi {

    @Autowired
    private IAdPromotionPlanService service;

    @Override
    public PageInfo listAdPromotionPlan(AdPromotionPlan entity,int pageNum, int pageSize){
        PageHelper.startPage(pageNum,pageSize);
        List<AdPromotionPlan> AdPromotionPlans = service.listAdPromotionPlan(entity);
        PageInfo<AdPromotionPlan> pageInfo = new PageInfo<AdPromotionPlan>(AdPromotionPlans);
        return pageInfo;
    }

    @Override
    public PageInfo listAdPromotionPlanWithOrderBy(AdPromotionPlan entity,Collection<String> columns,Boolean isAsc,int pageNum, int pageSize){
        PageHelper.startPage(pageNum,pageSize);
        List<AdPromotionPlan> AdPromotionPlans = service.listAdPromotionPlanWithOrderBy(entity,columns,isAsc);
        PageInfo<AdPromotionPlan> pageInfo = new PageInfo<AdPromotionPlan>(AdPromotionPlans);
        return pageInfo;
    }

    @Override
    public AdPromotionPlan getAdPromotionPlan(String id){
        return service.selectById(id);
    }

    @Override
    public AdPromotionPlan getAdPromotionPlanByCondition(AdPromotionPlan entity){
        return service.getAdPromotionPlanByCondition(entity);
    }

    @Override
    public Boolean saveAdPromotionPlan(AdPromotionPlan entity){
        return service.insertOrUpdate(entity);
    }

    @Override
    public Boolean deleteAdPromotionPlan(List<String> idlist){
        return service.deleteBatchIds(idlist);
    }

}
