package com.mankan.plumad.dubbo;


import com.github.pagehelper.PageInfo;
import com.mankan.plumad.model.AdPromotionPlan;

import java.util.List;
import java.util.Collection;

/**
 * <p>
 * 广告推广计划 api接口
 * </p>
 *
 * @author lq
 * @since 2019-09-24
 */
public interface AdPromotionPlanApi {

    /**
     * 获取广告推广计划
     * @param entity
     * @param pageNum
     * @param pageSize
     * @return
     */
    PageInfo listAdPromotionPlan(AdPromotionPlan entity, int pageNum, int pageSize);


    /**
     * 获取广告推广计划按照排序
     * @param entity
     * @param pageNum
     * @param pageSize
     * @return
     */
    PageInfo listAdPromotionPlanWithOrderBy(AdPromotionPlan entity, Collection<String> columns, Boolean isAsc, int pageNum, int pageSize);

    /**
     * 通过条件查询广告推广计划
     * @param entity
     * @return
     */
     AdPromotionPlan getAdPromotionPlanByCondition(AdPromotionPlan entity);

    /**
     * 通过id查询广告推广计划
     * @param id
     * @return
     */
     AdPromotionPlan getAdPromotionPlan(String id);

    /**
     * 保存或者新增广告推广计划
     * @param entity
     * @return
     */
    Boolean saveAdPromotionPlan(AdPromotionPlan entity);


    /**
     * 删除广告推广计划
     * @param idlist
     * @return
     */
    Boolean deleteAdPromotionPlan(List<String> idlist);

}