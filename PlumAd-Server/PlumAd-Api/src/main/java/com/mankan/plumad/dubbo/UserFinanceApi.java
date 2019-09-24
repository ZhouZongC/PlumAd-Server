package com.mankan.plumad.dubbo;


import com.github.pagehelper.PageInfo;
import com.mankan.plumad.model.UserFinance;

import java.util.List;
import java.util.Collection;

/**
 * <p>
 * 用户财务表 api接口
 * </p>
 *
 * @author lq
 * @since 2019-09-24
 */
public interface UserFinanceApi {

    /**
     * 获取用户财务表
     * @param entity
     * @param pageNum
     * @param pageSize
     * @return
     */
    PageInfo listUserFinance(UserFinance entity, int pageNum, int pageSize);


    /**
     * 获取用户财务表按照排序
     * @param entity
     * @param pageNum
     * @param pageSize
     * @return
     */
    PageInfo listUserFinanceWithOrderBy(UserFinance entity, Collection<String> columns, Boolean isAsc, int pageNum, int pageSize);

    /**
     * 通过条件查询用户财务表
     * @param entity
     * @return
     */
     UserFinance getUserFinanceByCondition(UserFinance entity);

    /**
     * 通过id查询用户财务表
     * @param id
     * @return
     */
     UserFinance getUserFinance(String id);

    /**
     * 保存或者新增用户财务表
     * @param entity
     * @return
     */
    Boolean saveUserFinance(UserFinance entity);


    /**
     * 删除用户财务表
     * @param idlist
     * @return
     */
    Boolean deleteUserFinance(List<String> idlist);

}