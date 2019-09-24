package com.mankan.plumad.provider;

import com.github.pagehelper.PageInfo;
import com.mankan.plumad.dubbo.AdPromotionInfoApi;
import com.mankan.plumad.model.AdPromotionInfo;
import com.mankan.plumad.service.IAdPromotionInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;


import java.util.List;
import java.util.Collection;

/**
 * <p>
 * 广告推广信息 provider
 * </p>
 *
 * @author lq
 * @since 2019-09-24
 */
@Service(version = "1.0.0",
        application = "${dubbo.application.id}",
        protocol = "${dubbo.protocol.id}",
        registry = "${dubbo.registry.id}")
public class AdPromotionInfoProvider implements AdPromotionInfoApi {

    @Autowired
    private IAdPromotionInfoService service;

    @Override
    public PageInfo listAdPromotionInfo(AdPromotionInfo entity,int pageNum, int pageSize){
        PageHelper.startPage(pageNum,pageSize);
        List<AdPromotionInfo> AdPromotionInfos = service.listAdPromotionInfo(entity);
        PageInfo<AdPromotionInfo> pageInfo = new PageInfo<AdPromotionInfo>(AdPromotionInfos);
        return pageInfo;
    }

    @Override
    public PageInfo listAdPromotionInfoWithOrderBy(AdPromotionInfo entity,Collection<String> columns,Boolean isAsc,int pageNum, int pageSize){
        PageHelper.startPage(pageNum,pageSize);
        List<AdPromotionInfo> AdPromotionInfos = service.listAdPromotionInfoWithOrderBy(entity,columns,isAsc);
        PageInfo<AdPromotionInfo> pageInfo = new PageInfo<AdPromotionInfo>(AdPromotionInfos);
        return pageInfo;
    }

    @Override
    public AdPromotionInfo getAdPromotionInfo(String id){
        return service.selectById(id);
    }

    @Override
    public AdPromotionInfo getAdPromotionInfoByCondition(AdPromotionInfo entity){
        return service.getAdPromotionInfoByCondition(entity);
    }

    @Override
    public Boolean saveAdPromotionInfo(AdPromotionInfo entity){
        return service.insertOrUpdate(entity);
    }

    @Override
    public Boolean deleteAdPromotionInfo(List<String> idlist){
        return service.deleteBatchIds(idlist);
    }

}
