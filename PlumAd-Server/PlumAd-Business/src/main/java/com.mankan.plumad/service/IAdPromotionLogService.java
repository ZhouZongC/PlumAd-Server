package com.mankan.plumad.service;

import java.util.List;
import com.mankan.plumad.model.AdPromotionLog;
import com.baomidou.mybatisplus.service.IService;
import java.util.List;
import java.util.Collection;

/**
 * <p>
 * 流量主推广日志 服务类
 * </p>
 *
 * @author lq
 * @since 2019-09-24
 */
public interface IAdPromotionLogService extends IService<AdPromotionLog> {

        /**
         * 获取流量主推广日志列表
         * @param entity
         * @return
         */
        List<AdPromotionLog> listAdPromotionLog(AdPromotionLog entity);


        /**
         * 获取流量主推广日志列表 按排序
         * @param entity
         * @return
         */
        List<AdPromotionLog> listAdPromotionLogWithOrderBy(AdPromotionLog entity, Collection<String> columns, Boolean isAsc);


        /**
         * 获取流量主推广日志数据
         * @param entity
         * @return
         */
        AdPromotionLog getAdPromotionLogByCondition(AdPromotionLog entity);
}
