package com.mankan.plumad.dubbo;

import com.github.pagehelper.PageInfo;
import com.mankan.plumad.model.UserWithdraw;

import java.util.List;
import java.util.Collection;

/**
 * <p>
 * 用户分润提现表 api接口
 * </p>
 *
 * @author lq
 * @since 2019-09-24
 */
public class UserWithdrawApiMock implements UserWithdrawApi {

    @Override
    public PageInfo listUserWithdraw(UserWithdraw entity,int pageNum, int pageSize){
        return null;
    }

    @Override
    public PageInfo listUserWithdrawWithOrderBy(UserWithdraw entity,Collection<String> columns,Boolean isAsc,int pageNum, int pageSize){
        return null;
    }

    @Override
    public UserWithdraw getUserWithdrawByCondition(UserWithdraw entity){
        return null;
    }

    @Override
    public UserWithdraw getUserWithdraw(String id){
        return null;
    }

    @Override
    public Boolean saveUserWithdraw(UserWithdraw entity){
        return null;
    }

    @Override
    public Boolean deleteUserWithdraw(List<String> idlist){
        return null;
    }

}