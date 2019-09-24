package com.mankan.plumad.provider;

import com.github.pagehelper.PageInfo;
import com.mankan.plumad.dubbo.AdPromotionPositionApi;
import com.mankan.plumad.model.AdPromotionPosition;
import com.mankan.plumad.service.IAdPromotionPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;


import java.util.List;
import java.util.Collection;

/**
 * <p>
 * 流量主推广广告位 provider
 * </p>
 *
 * @author lq
 * @since 2019-09-24
 */
@Service(version = "1.0.0",
        application = "${dubbo.application.id}",
        protocol = "${dubbo.protocol.id}",
        registry = "${dubbo.registry.id}")
public class AdPromotionPositionProvider implements AdPromotionPositionApi {

    @Autowired
    private IAdPromotionPositionService service;

    @Override
    public PageInfo listAdPromotionPosition(AdPromotionPosition entity,int pageNum, int pageSize){
        PageHelper.startPage(pageNum,pageSize);
        List<AdPromotionPosition> AdPromotionPositions = service.listAdPromotionPosition(entity);
        PageInfo<AdPromotionPosition> pageInfo = new PageInfo<AdPromotionPosition>(AdPromotionPositions);
        return pageInfo;
    }

    @Override
    public PageInfo listAdPromotionPositionWithOrderBy(AdPromotionPosition entity,Collection<String> columns,Boolean isAsc,int pageNum, int pageSize){
        PageHelper.startPage(pageNum,pageSize);
        List<AdPromotionPosition> AdPromotionPositions = service.listAdPromotionPositionWithOrderBy(entity,columns,isAsc);
        PageInfo<AdPromotionPosition> pageInfo = new PageInfo<AdPromotionPosition>(AdPromotionPositions);
        return pageInfo;
    }

    @Override
    public AdPromotionPosition getAdPromotionPosition(String id){
        return service.selectById(id);
    }

    @Override
    public AdPromotionPosition getAdPromotionPositionByCondition(AdPromotionPosition entity){
        return service.getAdPromotionPositionByCondition(entity);
    }

    @Override
    public Boolean saveAdPromotionPosition(AdPromotionPosition entity){
        return service.insertOrUpdate(entity);
    }

    @Override
    public Boolean deleteAdPromotionPosition(List<String> idlist){
        return service.deleteBatchIds(idlist);
    }

}
