package com.mankan.plumad.provider;

import com.github.pagehelper.PageInfo;
import com.mankan.plumad.dubbo.AdPromotionModeApi;
import com.mankan.plumad.model.AdPromotionMode;
import com.mankan.plumad.service.IAdPromotionModeService;
import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;


import java.util.List;
import java.util.Collection;

/**
 * <p>
 * 流量主推广方式 provider
 * </p>
 *
 * @author lq
 * @since 2019-09-24
 */
@Service(version = "1.0.0",
        application = "${dubbo.application.id}",
        protocol = "${dubbo.protocol.id}",
        registry = "${dubbo.registry.id}")
public class AdPromotionModeProvider implements AdPromotionModeApi {

    @Autowired
    private IAdPromotionModeService service;

    @Override
    public PageInfo listAdPromotionMode(AdPromotionMode entity,int pageNum, int pageSize){
        PageHelper.startPage(pageNum,pageSize);
        List<AdPromotionMode> AdPromotionModes = service.listAdPromotionMode(entity);
        PageInfo<AdPromotionMode> pageInfo = new PageInfo<AdPromotionMode>(AdPromotionModes);
        return pageInfo;
    }

    @Override
    public PageInfo listAdPromotionModeWithOrderBy(AdPromotionMode entity,Collection<String> columns,Boolean isAsc,int pageNum, int pageSize){
        PageHelper.startPage(pageNum,pageSize);
        List<AdPromotionMode> AdPromotionModes = service.listAdPromotionModeWithOrderBy(entity,columns,isAsc);
        PageInfo<AdPromotionMode> pageInfo = new PageInfo<AdPromotionMode>(AdPromotionModes);
        return pageInfo;
    }

    @Override
    public AdPromotionMode getAdPromotionMode(String id){
        return service.selectById(id);
    }

    @Override
    public AdPromotionMode getAdPromotionModeByCondition(AdPromotionMode entity){
        return service.getAdPromotionModeByCondition(entity);
    }

    @Override
    public Boolean saveAdPromotionMode(AdPromotionMode entity){
        return service.insertOrUpdate(entity);
    }

    @Override
    public Boolean deleteAdPromotionMode(List<String> idlist){
        return service.deleteBatchIds(idlist);
    }

}
