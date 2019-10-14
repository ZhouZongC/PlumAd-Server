package com.mankan.plumad.provider;

import com.github.pagehelper.PageInfo;
import com.mankan.plumad.dubbo.UserConsumeApi;
import com.mankan.plumad.model.UserConsume;
import com.mankan.plumad.service.IUserConsumeService;
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
 * @since 2019-10-14
 */
@Service(version = "1.0.0",
        application = "${dubbo.application.id}",
        protocol = "${dubbo.protocol.id}",
        registry = "${dubbo.registry.id}")
public class UserConsumeProvider implements UserConsumeApi {

    @Autowired
    private IUserConsumeService service;

    @Override
    public PageInfo listUserConsume(UserConsume entity,int pageNum, int pageSize){
        PageHelper.startPage(pageNum,pageSize);
        List<UserConsume> UserConsumes = service.listUserConsume(entity);
        PageInfo<UserConsume> pageInfo = new PageInfo<UserConsume>(UserConsumes);
        return pageInfo;
    }

    @Override
    public PageInfo listUserConsumeWithOrderBy(UserConsume entity,Collection<String> columns,Boolean isAsc,int pageNum, int pageSize){
        PageHelper.startPage(pageNum,pageSize);
        List<UserConsume> UserConsumes = service.listUserConsumeWithOrderBy(entity,columns,isAsc);
        PageInfo<UserConsume> pageInfo = new PageInfo<UserConsume>(UserConsumes);
        return pageInfo;
    }

    @Override
    public UserConsume getUserConsume(String id){
        return service.selectById(id);
    }

    @Override
    public UserConsume getUserConsumeByCondition(UserConsume entity){
        return service.getUserConsumeByCondition(entity);
    }

    @Override
    public Boolean saveUserConsume(UserConsume entity){
        return service.insertOrUpdate(entity);
    }

    @Override
    public Boolean deleteUserConsume(List<String> idlist){
        return service.deleteBatchIds(idlist);
    }

}
