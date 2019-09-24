package com.mankan.plumad.service;

import java.util.List;
import com.mankan.plumad.model.AdPromotionPosition;
import com.baomidou.mybatisplus.service.IService;
import java.util.List;
import java.util.Collection;

/**
 * <p>
 * 流量主推广广告位 服务类
 * </p>
 *
 * @author lq
 * @since 2019-09-24
 */
public interface IAdPromotionPositionService extends IService<AdPromotionPosition> {

        /**
         * 获取流量主推广广告位列表
         * @param entity
         * @return
         */
        List<AdPromotionPosition> listAdPromotionPosition(AdPromotionPosition entity);


        /**
         * 获取流量主推广广告位列表 按排序
         * @param entity
         * @return
         */
        List<AdPromotionPosition> listAdPromotionPositionWithOrderBy(AdPromotionPosition entity, Collection<String> columns, Boolean isAsc);


        /**
         * 获取流量主推广广告位数据
         * @param entity
         * @return
         */
        AdPromotionPosition getAdPromotionPositionByCondition(AdPromotionPosition entity);
}
