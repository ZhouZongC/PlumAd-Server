package com.mankan.plumad.service;

import java.util.List;
import com.mankan.plumad.model.PlumDic;
import com.baomidou.mybatisplus.service.IService;
import java.util.List;
import java.util.Collection;

/**
 * <p>
 * 字典表 服务类
 * </p>
 *
 * @author lq
 * @since 2019-09-26
 */
public interface IPlumDicService extends IService<PlumDic> {

        /**
         * 获取字典表列表
         * @param entity
         * @return
         */
        List<PlumDic> listPlumDic(PlumDic entity);


        /**
         * 获取字典表列表 按排序
         * @param entity
         * @return
         */
        List<PlumDic> listPlumDicWithOrderBy(PlumDic entity, Collection<String> columns, Boolean isAsc);


        /**
         * 获取字典表数据
         * @param entity
         * @return
         */
        PlumDic getPlumDicByCondition(PlumDic entity);
}
