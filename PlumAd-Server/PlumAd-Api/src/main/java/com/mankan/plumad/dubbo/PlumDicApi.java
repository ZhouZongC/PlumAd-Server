package com.mankan.plumad.dubbo;


import com.github.pagehelper.PageInfo;
import com.mankan.plumad.model.PlumDic;

import java.util.List;
import java.util.Collection;

/**
 * <p>
 * 字典表 api接口
 * </p>
 *
 * @author lq
 * @since 2019-09-26
 */
public interface PlumDicApi {

    /**
     * 获取字典表
     * @param entity
     * @return
     */
    PageInfo listPlumDic(PlumDic entity);


    /**
     * 获取字典表按照排序
     * @param entity
     * @return
     */
    PageInfo listPlumDicWithOrderBy(PlumDic entity, Collection<String> columns, Boolean isAsc);

    /**
     * 通过条件查询字典表
     * @param entity
     * @return
     */
     PlumDic getPlumDicByCondition(PlumDic entity);

    /**
     * 通过id查询字典表
     * @param id
     * @return
     */
     PlumDic getPlumDic(String id);

    /**
     * 保存或者新增字典表
     * @param entity
     * @return
     */
    Boolean savePlumDic(PlumDic entity);


    /**
     * 删除字典表
     * @param idlist
     * @return
     */
    Boolean deletePlumDic(List<String> idlist);

}