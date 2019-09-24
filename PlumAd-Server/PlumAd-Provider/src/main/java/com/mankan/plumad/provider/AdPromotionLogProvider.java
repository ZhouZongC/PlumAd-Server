package com.mankan.plumad.provider;

import com.github.pagehelper.PageInfo;
import com.mankan.plumad.dubbo.AdPromotionLogApi;
import com.mankan.plumad.model.AdPromotionLog;
import com.mankan.plumad.service.IAdPromotionLogService;
import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;


import java.util.List;
import java.util.Collection;

/**
 * <p>
 * 流量主推广日志 provider
 * </p>
 *
 * @author lq
 * @since 2019-09-24
 */
@Service(version = "1.0.0",
        application = "${dubbo.application.id}",
        protocol = "${dubbo.protocol.id}",
        registry = "${dubbo.registry.id}")
public class AdPromotionLogProvider implements AdPromotionLogApi {

    @Autowired
    private IAdPromotionLogService service;

    @Override
    public PageInfo listAdPromotionLog(AdPromotionLog entity,int pageNum, int pageSize){
        PageHelper.startPage(pageNum,pageSize);
        List<AdPromotionLog> AdPromotionLogs = service.listAdPromotionLog(entity);
        PageInfo<AdPromotionLog> pageInfo = new PageInfo<AdPromotionLog>(AdPromotionLogs);
        return pageInfo;
    }

    @Override
    public PageInfo listAdPromotionLogWithOrderBy(AdPromotionLog entity,Collection<String> columns,Boolean isAsc,int pageNum, int pageSize){
        PageHelper.startPage(pageNum,pageSize);
        List<AdPromotionLog> AdPromotionLogs = service.listAdPromotionLogWithOrderBy(entity,columns,isAsc);
        PageInfo<AdPromotionLog> pageInfo = new PageInfo<AdPromotionLog>(AdPromotionLogs);
        return pageInfo;
    }

    @Override
    public AdPromotionLog getAdPromotionLog(String id){
        return service.selectById(id);
    }

    @Override
    public AdPromotionLog getAdPromotionLogByCondition(AdPromotionLog entity){
        return service.getAdPromotionLogByCondition(entity);
    }

    @Override
    public Boolean saveAdPromotionLog(AdPromotionLog entity){
        return service.insertOrUpdate(entity);
    }

    @Override
    public Boolean deleteAdPromotionLog(List<String> idlist){
        return service.deleteBatchIds(idlist);
    }

}
