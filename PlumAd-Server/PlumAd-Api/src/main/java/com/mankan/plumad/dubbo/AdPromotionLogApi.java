package com.mankan.plumad.dubbo;


import com.github.pagehelper.PageInfo;
import com.mankan.plumad.model.AdPromotionLog;

import java.util.List;
import java.util.Collection;

/**
 * <p>
 * 流量主推广日志 api接口
 * </p>
 *
 * @author lq
 * @since 2019-09-24
 */
public interface AdPromotionLogApi {

    /**
     * 获取流量主推广日志
     * @param entity
     * @param pageNum
     * @param pageSize
     * @return
     */
    PageInfo listAdPromotionLog(AdPromotionLog entity, int pageNum, int pageSize);


    /**
     * 获取流量主推广日志按照排序
     * @param entity
     * @param pageNum
     * @param pageSize
     * @return
     */
    PageInfo listAdPromotionLogWithOrderBy(AdPromotionLog entity, Collection<String> columns, Boolean isAsc, int pageNum, int pageSize);

    /**
     * 通过条件查询流量主推广日志
     * @param entity
     * @return
     */
     AdPromotionLog getAdPromotionLogByCondition(AdPromotionLog entity);

    /**
     * 通过id查询流量主推广日志
     * @param id
     * @return
     */
     AdPromotionLog getAdPromotionLog(String id);

    /**
     * 保存或者新增流量主推广日志
     * @param entity
     * @return
     */
    Boolean saveAdPromotionLog(AdPromotionLog entity);


    /**
     * 删除流量主推广日志
     * @param idlist
     * @return
     */
    Boolean deleteAdPromotionLog(List<String> idlist);

}