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
public interface UserRechargeApi {

    /**
     * 获取用户充值记录表
     * @param entity
     * @param pageNum
     * @param pageSize
     * @return
     */
    PageInfo listUserRecharge(UserRecharge entity, int pageNum, int pageSize);


    /**
     * 获取用户充值记录表按照排序
     * @param entity
     * @param pageNum
     * @param pageSize
     * @return
     */
    PageInfo listUserRechargeWithOrderBy(UserRecharge entity, Collection<String> columns, Boolean isAsc, int pageNum, int pageSize);

    /**
     * 通过条件查询用户充值记录表
     * @param entity
     * @return
     */
     UserRecharge getUserRechargeByCondition(UserRecharge entity);

    /**
     * 通过id查询用户充值记录表
     * @param id
     * @return
     */
     UserRecharge getUserRecharge(String id);

    /**
     * 保存或者新增用户充值记录表
     * @param entity
     * @return
     */
    Boolean saveUserRecharge(UserRecharge entity);


    /**
     * 删除用户充值记录表
     * @param idlist
     * @return
     */
    Boolean deleteUserRecharge(List<String> idlist);

}