package com.mankan.plumad.service;

import java.util.List;
import com.mankan.plumad.model.AdPromotionInfo;
import com.baomidou.mybatisplus.service.IService;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Collection;

/**
 * <p>
 * 广告推广信息 服务类
 * </p>
 *
 * @author lq
 * @since 2019-09-24
 */
public interface IAdPromotionInfoService extends IService<AdPromotionInfo> {

        /**
         * 获取广告推广信息列表
         * @param entity
         * @return
         */
        List<AdPromotionInfo> listAdPromotionInfo(AdPromotionInfo entity);


        /**
         * 获取广告推广信息列表 按排序
         * @param entity
         * @return
         */
        List<AdPromotionInfo> listAdPromotionInfoWithOrderBy(AdPromotionInfo entity, Collection<String> columns, Boolean isAsc);


        /**
         * 获取广告推广信息数据
         * @param entity
         * @return
         */
        AdPromotionInfo getAdPromotionInfoByCondition(AdPromotionInfo entity);

        /**
         * 根据广告位编码查询广告推广信息
         */
        List<AdPromotionInfo> listAdvertisingDisplay(@RequestBody String positionCode);
}
