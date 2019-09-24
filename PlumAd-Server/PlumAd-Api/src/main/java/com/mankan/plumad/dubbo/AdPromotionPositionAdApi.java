package com.mankan.plumad.dubbo;


import com.github.pagehelper.PageInfo;
import com.mankan.plumad.model.AdPromotionPositionAd;

import java.util.List;
import java.util.Collection;

/**
 * <p>
 * 流量主推广广告位对应广告 api接口
 * </p>
 *
 * @author lq
 * @since 2019-09-24
 */
public interface AdPromotionPositionAdApi {

    /**
     * 获取流量主推广广告位对应广告
     * @param entity
     * @param pageNum
     * @param pageSize
     * @return
     */
    PageInfo listAdPromotionPositionAd(AdPromotionPositionAd entity, int pageNum, int pageSize);


    /**
     * 获取流量主推广广告位对应广告按照排序
     * @param entity
     * @param pageNum
     * @param pageSize
     * @return
     */
    PageInfo listAdPromotionPositionAdWithOrderBy(AdPromotionPositionAd entity, Collection<String> columns, Boolean isAsc, int pageNum, int pageSize);

    /**
     * 通过条件查询流量主推广广告位对应广告
     * @param entity
     * @return
     */
     AdPromotionPositionAd getAdPromotionPositionAdByCondition(AdPromotionPositionAd entity);

    /**
     * 通过id查询流量主推广广告位对应广告
     * @param id
     * @return
     */
     AdPromotionPositionAd getAdPromotionPositionAd(String id);

    /**
     * 保存或者新增流量主推广广告位对应广告
     * @param entity
     * @return
     */
    Boolean saveAdPromotionPositionAd(AdPromotionPositionAd entity);


    /**
     * 删除流量主推广广告位对应广告
     * @param idlist
     * @return
     */
    Boolean deleteAdPromotionPositionAd(List<String> idlist);

}