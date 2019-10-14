package com.mankan.plumad.dubbo;

import com.github.pagehelper.PageInfo;
import com.mankan.plumad.model.UserConsume;

import java.util.List;
import java.util.Collection;

/**
 * <p>
 * 用户分润提现表 api接口
 * </p>
 *
 * @author lq
 * @since 2019-10-14
 */
public class UserConsumeApiMock implements UserConsumeApi {

    @Override
    public PageInfo listUserConsume(UserConsume entity,int pageNum, int pageSize){
        return null;
    }

    @Override
    public PageInfo listUserConsumeWithOrderBy(UserConsume entity,Collection<String> columns,Boolean isAsc,int pageNum, int pageSize){
        return null;
    }

    @Override
    public UserConsume getUserConsumeByCondition(UserConsume entity){
        return null;
    }

    @Override
    public UserConsume getUserConsume(String id){
        return null;
    }

    @Override
    public Boolean saveUserConsume(UserConsume entity){
        return null;
    }

    @Override
    public Boolean deleteUserConsume(List<String> idlist){
        return null;
    }

}