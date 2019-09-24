package com.mankan.plumad.service;

import java.util.List;
import com.mankan.plumad.model.AdPromotionMode;
import com.baomidou.mybatisplus.service.IService;
import java.util.List;
import java.util.Collection;

/**
 * <p>
 * 流量主推广方式 服务类
 * </p>
 *
 * @author lq
 * @since 2019-09-24
 */
public interface IAdPromotionModeService extends IService<AdPromotionMode> {

        /**
         * 获取流量主推广方式列表
         * @param entity
         * @return
         */
        List<AdPromotionMode> listAdPromotionMode(AdPromotionMode entity);


        /**
         * 获取流量主推广方式列表 按排序
         * @param entity
         * @return
         */
        List<AdPromotionMode> listAdPromotionModeWithOrderBy(AdPromotionMode entity, Collection<String> columns, Boolean isAsc);


        /**
         * 获取流量主推广方式数据
         * @param entity
         * @return
         */
        AdPromotionMode getAdPromotionModeByCondition(AdPromotionMode entity);
}
