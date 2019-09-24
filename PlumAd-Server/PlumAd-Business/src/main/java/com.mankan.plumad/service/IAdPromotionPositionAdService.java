package com.mankan.plumad.service;

import java.util.List;
import com.mankan.plumad.model.AdPromotionPositionAd;
import com.baomidou.mybatisplus.service.IService;
import java.util.List;
import java.util.Collection;

/**
 * <p>
 * 流量主推广广告位对应广告 服务类
 * </p>
 *
 * @author lq
 * @since 2019-09-24
 */
public interface IAdPromotionPositionAdService extends IService<AdPromotionPositionAd> {

        /**
         * 获取流量主推广广告位对应广告列表
         * @param entity
         * @return
         */
        List<AdPromotionPositionAd> listAdPromotionPositionAd(AdPromotionPositionAd entity);


        /**
         * 获取流量主推广广告位对应广告列表 按排序
         * @param entity
         * @return
         */
        List<AdPromotionPositionAd> listAdPromotionPositionAdWithOrderBy(AdPromotionPositionAd entity, Collection<String> columns, Boolean isAsc);


        /**
         * 获取流量主推广广告位对应广告数据
         * @param entity
         * @return
         */
        AdPromotionPositionAd getAdPromotionPositionAdByCondition(AdPromotionPositionAd entity);
}
