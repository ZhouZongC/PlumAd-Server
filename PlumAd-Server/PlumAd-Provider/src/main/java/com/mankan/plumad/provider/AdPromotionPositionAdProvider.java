package com.mankan.plumad.provider;

import com.github.pagehelper.PageInfo;
import com.mankan.plumad.dubbo.AdPromotionPositionAdApi;
import com.mankan.plumad.model.AdPromotionPositionAd;
import com.mankan.plumad.service.IAdPromotionPositionAdService;
import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;


import java.util.List;
import java.util.Collection;

/**
 * <p>
 * 流量主推广广告位对应广告 provider
 * </p>
 *
 * @author lq
 * @since 2019-09-24
 */
@Service(version = "1.0.0",
        application = "${dubbo.application.id}",
        protocol = "${dubbo.protocol.id}",
        registry = "${dubbo.registry.id}")
public class AdPromotionPositionAdProvider implements AdPromotionPositionAdApi {

    @Autowired
    private IAdPromotionPositionAdService service;

    @Override
    public PageInfo listAdPromotionPositionAd(AdPromotionPositionAd entity,int pageNum, int pageSize){
        PageHelper.startPage(pageNum,pageSize);
        List<AdPromotionPositionAd> AdPromotionPositionAds = service.listAdPromotionPositionAd(entity);
        PageInfo<AdPromotionPositionAd> pageInfo = new PageInfo<AdPromotionPositionAd>(AdPromotionPositionAds);
        return pageInfo;
    }

    @Override
    public PageInfo listAdPromotionPositionAdWithOrderBy(AdPromotionPositionAd entity,Collection<String> columns,Boolean isAsc,int pageNum, int pageSize){
        PageHelper.startPage(pageNum,pageSize);
        List<AdPromotionPositionAd> AdPromotionPositionAds = service.listAdPromotionPositionAdWithOrderBy(entity,columns,isAsc);
        PageInfo<AdPromotionPositionAd> pageInfo = new PageInfo<AdPromotionPositionAd>(AdPromotionPositionAds);
        return pageInfo;
    }

    @Override
    public AdPromotionPositionAd getAdPromotionPositionAd(String id){
        return service.selectById(id);
    }

    @Override
    public AdPromotionPositionAd getAdPromotionPositionAdByCondition(AdPromotionPositionAd entity){
        return service.getAdPromotionPositionAdByCondition(entity);
    }

    @Override
    public Boolean saveAdPromotionPositionAd(AdPromotionPositionAd entity){
        return service.insertOrUpdate(entity);
    }

    @Override
    public Boolean deleteAdPromotionPositionAd(List<String> idlist){
        return service.deleteBatchIds(idlist);
    }

}
