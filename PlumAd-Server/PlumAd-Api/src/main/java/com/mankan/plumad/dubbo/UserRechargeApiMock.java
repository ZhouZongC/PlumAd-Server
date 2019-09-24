package com.mankan.plumad.dubbo;

import com.github.pagehelper.PageInfo;
import com.mankan.plumad.model.UserRecharge;

import java.util.List;
import java.util.Collection;

/**
 * <p>
 * 用户充值记录表 api接口
 * </p>
 *
 * @author lq
 * @since 2019-09-24
 */
public class UserRechargeApiMock implements UserRechargeApi {

    @Override
    public PageInfo listUserRecharge(UserRecharge entity,int pageNum, int pageSize){
        return null;
    }

    @Override
    public PageInfo listUserRechargeWithOrderBy(UserRecharge entity,Collection<String> columns,Boolean isAsc,int pageNum, int pageSize){
        return null;
    }

    @Override
    public UserRecharge getUserRechargeByCondition(UserRecharge entity){
        return null;
    }

    @Override
    public UserRecharge getUserRecharge(String id){
        return null;
    }

    @Override
    public Boolean saveUserRecharge(UserRecharge entity){
        return null;
    }

    @Override
    public Boolean deleteUserRecharge(List<String> idlist){
        return null;
    }

}