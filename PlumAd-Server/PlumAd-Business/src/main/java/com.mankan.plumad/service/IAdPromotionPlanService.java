package com.mankan.plumad.service;

import java.util.List;
import com.mankan.plumad.model.AdPromotionPlan;
import com.baomidou.mybatisplus.service.IService;
import java.util.List;
import java.util.Collection;

/**
 * <p>
 * 广告推广计划 服务类
 * </p>
 *
 * @author lq
 * @since 2019-09-24
 */
public interface IAdPromotionPlanService extends IService<AdPromotionPlan> {

        /**
         * 获取广告推广计划列表
         * @param entity
         * @return
         */
        List<AdPromotionPlan> listAdPromotionPlan(AdPromotionPlan entity);


        /**
         * 获取广告推广计划列表 按排序
         * @param entity
         * @return
         */
        List<AdPromotionPlan> listAdPromotionPlanWithOrderBy(AdPromotionPlan entity, Collection<String> columns, Boolean isAsc);


        /**
         * 获取广告推广计划数据
         * @param entity
         * @return
         */
        AdPromotionPlan getAdPromotionPlanByCondition(AdPromotionPlan entity);
}
