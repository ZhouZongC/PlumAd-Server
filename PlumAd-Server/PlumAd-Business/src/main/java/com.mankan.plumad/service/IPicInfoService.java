package com.mankan.plumad.service;

import java.util.List;
import com.mankan.plumad.model.PicInfo;
import com.baomidou.mybatisplus.service.IService;
import java.util.List;
import java.util.Collection;

/**
 * <p>
 * 图片文件表 服务类
 * </p>
 *
 * @author lq
 * @since 2019-09-26
 */
public interface IPicInfoService extends IService<PicInfo> {

        /**
         * 获取图片文件表列表
         * @param entity
         * @return
         */
        List<PicInfo> listPicInfo(PicInfo entity);


        /**
         * 获取图片文件表列表 按排序
         * @param entity
         * @return
         */
        List<PicInfo> listPicInfoWithOrderBy(PicInfo entity, Collection<String> columns, Boolean isAsc);


        /**
         * 获取图片文件表数据
         * @param entity
         * @return
         */
        PicInfo getPicInfoByCondition(PicInfo entity);
}
