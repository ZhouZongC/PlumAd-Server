package com.mankan.plumad.provider;

import com.github.pagehelper.PageInfo;
import com.mankan.plumad.dubbo.UserRechargeApi;
import com.mankan.plumad.model.UserRecharge;
import com.mankan.plumad.service.IUserRechargeService;
import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;


import java.util.List;
import java.util.Collection;

/**
 * <p>
 * 用户充值记录表 provider
 * </p>
 *
 * @author lq
 * @since 2019-09-24
 */
@Service(version = "1.0.0",
        application = "${dubbo.application.id}",
        protocol = "${dubbo.protocol.id}",
        registry = "${dubbo.registry.id}")
public class UserRechargeProvider implements UserRechargeApi {

    @Autowired
    private IUserRechargeService service;

    @Override
    public PageInfo listUserRecharge(UserRecharge entity,int pageNum, int pageSize){
        PageHelper.startPage(pageNum,pageSize);
        List<UserRecharge> UserRecharges = service.listUserRecharge(entity);
        PageInfo<UserRecharge> pageInfo = new PageInfo<UserRecharge>(UserRecharges);
        return pageInfo;
    }

    @Override
    public PageInfo listUserRechargeWithOrderBy(UserRecharge entity,Collection<String> columns,Boolean isAsc,int pageNum, int pageSize){
        PageHelper.startPage(pageNum,pageSize);
        List<UserRecharge> UserRecharges = service.listUserRechargeWithOrderBy(entity,columns,isAsc);
        PageInfo<UserRecharge> pageInfo = new PageInfo<UserRecharge>(UserRecharges);
        return pageInfo;
    }

    @Override
    public UserRecharge getUserRecharge(String id){
        return service.selectById(id);
    }

    @Override
    public UserRecharge getUserRechargeByCondition(UserRecharge entity){
        return service.getUserRechargeByCondition(entity);
    }

    @Override
    public Boolean saveUserRecharge(UserRecharge entity){
        return service.insertOrUpdate(entity);
    }

    @Override
    public Boolean deleteUserRecharge(List<String> idlist){
        return service.deleteBatchIds(idlist);
    }

}
