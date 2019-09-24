package com.mankan.plumad.provider;

import com.github.pagehelper.PageInfo;
import com.mankan.plumad.dubbo.UserWithdrawApi;
import com.mankan.plumad.model.UserWithdraw;
import com.mankan.plumad.service.IUserWithdrawService;
import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;


import java.util.List;
import java.util.Collection;

/**
 * <p>
 * 用户分润提现表 provider
 * </p>
 *
 * @author lq
 * @since 2019-09-24
 */
@Service(version = "1.0.0",
        application = "${dubbo.application.id}",
        protocol = "${dubbo.protocol.id}",
        registry = "${dubbo.registry.id}")
public class UserWithdrawProvider implements UserWithdrawApi {

    @Autowired
    private IUserWithdrawService service;

    @Override
    public PageInfo listUserWithdraw(UserWithdraw entity,int pageNum, int pageSize){
        PageHelper.startPage(pageNum,pageSize);
        List<UserWithdraw> UserWithdraws = service.listUserWithdraw(entity);
        PageInfo<UserWithdraw> pageInfo = new PageInfo<UserWithdraw>(UserWithdraws);
        return pageInfo;
    }

    @Override
    public PageInfo listUserWithdrawWithOrderBy(UserWithdraw entity,Collection<String> columns,Boolean isAsc,int pageNum, int pageSize){
        PageHelper.startPage(pageNum,pageSize);
        List<UserWithdraw> UserWithdraws = service.listUserWithdrawWithOrderBy(entity,columns,isAsc);
        PageInfo<UserWithdraw> pageInfo = new PageInfo<UserWithdraw>(UserWithdraws);
        return pageInfo;
    }

    @Override
    public UserWithdraw getUserWithdraw(String id){
        return service.selectById(id);
    }

    @Override
    public UserWithdraw getUserWithdrawByCondition(UserWithdraw entity){
        return service.getUserWithdrawByCondition(entity);
    }

    @Override
    public Boolean saveUserWithdraw(UserWithdraw entity){
        return service.insertOrUpdate(entity);
    }

    @Override
    public Boolean deleteUserWithdraw(List<String> idlist){
        return service.deleteBatchIds(idlist);
    }

}
