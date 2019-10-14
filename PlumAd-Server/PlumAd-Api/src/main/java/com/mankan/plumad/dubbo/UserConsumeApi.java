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
public interface UserConsumeApi {

    /**
     * 获取用户分润提现表
     * @param entity
     * @param pageNum
     * @param pageSize
     * @return
     */
    PageInfo listUserConsume(UserConsume entity, int pageNum, int pageSize);


    /**
     * 获取用户分润提现表按照排序
     * @param entity
     * @param pageNum
     * @param pageSize
     * @return
     */
    PageInfo listUserConsumeWithOrderBy(UserConsume entity, Collection<String> columns, Boolean isAsc, int pageNum, int pageSize);

    /**
     * 通过条件查询用户分润提现表
     * @param entity
     * @return
     */
     UserConsume getUserConsumeByCondition(UserConsume entity);

    /**
     * 通过id查询用户分润提现表
     * @param id
     * @return
     */
     UserConsume getUserConsume(String id);

    /**
     * 保存或者新增用户分润提现表
     * @param entity
     * @return
     */
    Boolean saveUserConsume(UserConsume entity);


    /**
     * 删除用户分润提现表
     * @param idlist
     * @return
     */
    Boolean deleteUserConsume(List<String> idlist);

}