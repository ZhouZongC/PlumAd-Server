package com.mankan.plumad.dubbo;


import com.github.pagehelper.PageInfo;
import com.mankan.plumad.dto.AdPromotionDTO;
import com.mankan.plumad.model.AdPromotionPosition;

import java.util.List;
import java.util.Collection;

/**
 * <p>
 * 流量主推广广告位 api接口
 * </p>
 *
 * @author lq
 * @since 2019-09-24
 */
public interface AdPromotionPositionApi {

    /**
     * 获取流量主推广广告位
     * @param entity
     * @param pageNum
     * @param pageSize
     * @return
     */
    PageInfo listAdPromotionPosition(AdPromotionPosition entity, int pageNum, int pageSize);


    /**
     * 获取流量主推广广告位按照排序
     * @param entity
     * @param pageNum
     * @param pageSize
     * @return
     */
    PageInfo listAdPromotionPositionWithOrderBy(AdPromotionPosition entity, Collection<String> columns, Boolean isAsc, int pageNum, int pageSize);

    /**
     * 通过条件查询流量主推广广告位
     * @param entity
     * @return
     */
     AdPromotionPosition getAdPromotionPositionByCondition(AdPromotionPosition entity);

    /**
     * 通过id查询流量主推广广告位
     * @param id
     * @return
     */
     AdPromotionPosition getAdPromotionPosition(String id);

    /**
     * 保存或者新增流量主推广广告位
     * @param entity
     * @return
     */
    Boolean saveAdPromotionPosition(AdPromotionPosition entity);


    /**
     * 删除流量主推广广告位
     * @param idlist
     * @return
     */
    Boolean deleteAdPromotionPosition(List<String> idlist);

    /**
     * @param positionCode
     * @return
     */
    AdPromotionDTO getAdPromotionDTO(String positionCode);
}
