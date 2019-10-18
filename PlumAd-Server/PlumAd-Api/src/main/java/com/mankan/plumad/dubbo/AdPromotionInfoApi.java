package com.mankan.plumad.dubbo;


import com.github.pagehelper.PageInfo;
import com.mankan.plumad.model.AdPromotionInfo;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Collection;

/**
 * <p>
 * 广告推广信息 api接口
 * </p>
 *
 * @author lq
 * @since 2019-09-24
 */
public interface AdPromotionInfoApi {

    /**
     * 获取广告推广信息
     * @param entity
     * @param pageNum
     * @param pageSize
     * @return
     */
    PageInfo listAdPromotionInfo(AdPromotionInfo entity, int pageNum, int pageSize);


    /**
     * 获取广告推广信息按照排序
     * @param entity
     * @param pageNum
     * @param pageSize
     * @return
     */
    PageInfo listAdPromotionInfoWithOrderBy(AdPromotionInfo entity, Collection<String> columns, Boolean isAsc, int pageNum, int pageSize);

    /**
     * 通过条件查询广告推广信息
     * @param entity
     * @return
     */
     AdPromotionInfo getAdPromotionInfoByCondition(AdPromotionInfo entity);

    /**
     * 通过id查询广告推广信息
     * @param id
     * @return
     */
     AdPromotionInfo getAdPromotionInfo(String id);

    /**
     * 保存或者新增广告推广信息
     * @param entity
     * @return
     */
    Boolean saveAdPromotionInfo(AdPromotionInfo entity);


    /**
     * 删除广告推广信息
     * @param idlist
     * @return
     */
    Boolean deleteAdPromotionInfo(List<String> idlist);

    /**
     * 根据广告位编码查询广告推广信息
     */
    PageInfo listAdvertisingDisplay(@RequestBody String positionCode);

}