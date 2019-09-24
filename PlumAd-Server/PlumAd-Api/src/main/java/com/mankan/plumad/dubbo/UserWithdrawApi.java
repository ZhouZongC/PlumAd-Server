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
public interface UserWithdrawApi {

    /**
     * 获取用户分润提现表
     * @param entity
     * @param pageNum
     * @param pageSize
     * @return
     */
    PageInfo listUserWithdraw(UserWithdraw entity, int pageNum, int pageSize);


    /**
     * 获取用户分润提现表按照排序
     * @param entity
     * @param pageNum
     * @param pageSize
     * @return
     */
    PageInfo listUserWithdrawWithOrderBy(UserWithdraw entity, Collection<String> columns, Boolean isAsc, int pageNum, int pageSize);

    /**
     * 通过条件查询用户分润提现表
     * @param entity
     * @return
     */
     UserWithdraw getUserWithdrawByCondition(UserWithdraw entity);

    /**
     * 通过id查询用户分润提现表
     * @param id
     * @return
     */
     UserWithdraw getUserWithdraw(String id);

    /**
     * 保存或者新增用户分润提现表
     * @param entity
     * @return
     */
    Boolean saveUserWithdraw(UserWithdraw entity);


    /**
     * 删除用户分润提现表
     * @param idlist
     * @return
     */
    Boolean deleteUserWithdraw(List<String> idlist);

}