package com.mankan.plumad.provider;

import com.github.pagehelper.PageInfo;
import com.mankan.plumad.dubbo.UserFinanceApi;
import com.mankan.plumad.model.UserFinance;
import com.mankan.plumad.service.IUserFinanceService;
import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;


import java.util.List;
import java.util.Collection;

/**
 * <p>
 * 用户财务表 provider
 * </p>
 *
 * @author lq
 * @since 2019-09-24
 */
@Service(version = "1.0.0",
        application = "${dubbo.application.id}",
        protocol = "${dubbo.protocol.id}",
        registry = "${dubbo.registry.id}")
public class UserFinanceProvider implements UserFinanceApi {

    @Autowired
    private IUserFinanceService service;

    @Override
    public PageInfo listUserFinance(UserFinance entity,int pageNum, int pageSize){
        PageHelper.startPage(pageNum,pageSize);
        List<UserFinance> UserFinances = service.listUserFinance(entity);
        PageInfo<UserFinance> pageInfo = new PageInfo<UserFinance>(UserFinances);
        return pageInfo;
    }

    @Override
    public PageInfo listUserFinanceWithOrderBy(UserFinance entity,Collection<String> columns,Boolean isAsc,int pageNum, int pageSize){
        PageHelper.startPage(pageNum,pageSize);
        List<UserFinance> UserFinances = service.listUserFinanceWithOrderBy(entity,columns,isAsc);
        PageInfo<UserFinance> pageInfo = new PageInfo<UserFinance>(UserFinances);
        return pageInfo;
    }

    @Override
    public UserFinance getUserFinance(String id){
        return service.selectById(id);
    }

    @Override
    public UserFinance getUserFinanceByCondition(UserFinance entity){
        return service.getUserFinanceByCondition(entity);
    }

    @Override
    public Boolean saveUserFinance(UserFinance entity){
        return service.insertOrUpdate(entity);
    }

    @Override
    public Boolean deleteUserFinance(List<String> idlist){
        return service.deleteBatchIds(idlist);
    }

}
