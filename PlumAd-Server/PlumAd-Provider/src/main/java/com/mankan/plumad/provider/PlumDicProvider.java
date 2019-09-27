package com.mankan.plumad.provider;

import com.github.pagehelper.PageInfo;
import com.mankan.plumad.dubbo.PlumDicApi;
import com.mankan.plumad.model.PlumDic;
import com.mankan.plumad.service.IPlumDicService;
import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.dubbo.config.annotation.Service;

import java.util.List;
import java.util.Collection;

/**
 * <p>
 * 字典表 provider
 * </p>
 *
 * @author lq
 * @since 2019-09-26
 */
@Service(version = "1.0.0",
        application = "${dubbo.application.id}",
        protocol = "${dubbo.protocol.id}",
        registry = "${dubbo.registry.id}")
public class PlumDicProvider implements PlumDicApi {

    @Autowired
    private IPlumDicService service;

    @Override
    public PageInfo listPlumDic(PlumDic entity){
//        PageHelper.startPage(pageNum,pageSize);
        List<PlumDic> PlumDics = service.listPlumDic(entity);
        PageInfo<PlumDic> pageInfo = new PageInfo<PlumDic>(PlumDics);
        return pageInfo;
    }

    @Override
    public PageInfo listPlumDicWithOrderBy(PlumDic entity,Collection<String> columns,Boolean isAsc){
//        PageHelper.startPage(pageNum,pageSize);
        List<PlumDic> PlumDics = service.listPlumDicWithOrderBy(entity,columns,isAsc);
        PageInfo<PlumDic> pageInfo = new PageInfo<PlumDic>(PlumDics);
        return pageInfo;
    }

    @Override
    public PlumDic getPlumDic(String id){
        return service.selectById(id);
    }

    @Override
    public PlumDic getPlumDicByCondition(PlumDic entity){
        return service.getPlumDicByCondition(entity);
    }

    @Override
    public Boolean savePlumDic(PlumDic entity){
        return service.insertOrUpdate(entity);
    }

    @Override
    public Boolean deletePlumDic(List<String> idlist){
        return service.deleteBatchIds(idlist);
    }

}
