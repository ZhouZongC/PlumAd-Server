package com.mankan.plumad.dubbo;


import com.github.pagehelper.PageInfo;
import com.mankan.plumad.model.AdPromotionMode;

import java.util.List;
import java.util.Collection;

/**
 * <p>
 * 流量主推广方式 api接口
 * </p>
 *
 * @author lq
 * @since 2019-09-24
 */
public interface AdPromotionModeApi {

    /**
     * 获取流量主推广方式
     * @param entity
     * @param pageNum
     * @param pageSize
     * @return
     */
    PageInfo listAdPromotionMode(AdPromotionMode entity, int pageNum, int pageSize);


    /**
     * 获取流量主推广方式按照排序
     * @param entity
     * @param pageNum
     * @param pageSize
     * @return
     */
    PageInfo listAdPromotionModeWithOrderBy(AdPromotionMode entity, Collection<String> columns, Boolean isAsc, int pageNum, int pageSize);

    /**
     * 通过条件查询流量主推广方式
     * @param entity
     * @return
     */
     AdPromotionMode getAdPromotionModeByCondition(AdPromotionMode entity);

    /**
     * 通过id查询流量主推广方式
     * @param id
     * @return
     */
     AdPromotionMode getAdPromotionMode(String id);

    /**
     * 保存或者新增流量主推广方式
     * @param entity
     * @return
     */
    Boolean saveAdPromotionMode(AdPromotionMode entity);


    /**
     * 删除流量主推广方式
     * @param idlist
     * @return
     */
    Boolean deleteAdPromotionMode(List<String> idlist);

}