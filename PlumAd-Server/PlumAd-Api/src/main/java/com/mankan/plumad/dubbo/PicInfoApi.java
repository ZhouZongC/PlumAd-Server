package com.mankan.plumad.dubbo;


import com.github.pagehelper.PageInfo;
import com.mankan.plumad.model.PicInfo;

import java.util.List;
import java.util.Collection;

/**
 * <p>
 * 图片文件表 api接口
 * </p>
 *
 * @author lq
 * @since 2019-09-26
 */
public interface PicInfoApi {

    /**
     * 获取图片文件表
     * @param entity
     * @param pageNum
     * @param pageSize
     * @return
     */
    PageInfo listPicInfo(PicInfo entity, int pageNum, int pageSize);


    /**
     * 获取图片文件表按照排序
     * @param entity
     * @param pageNum
     * @param pageSize
     * @return
     */
    PageInfo listPicInfoWithOrderBy(PicInfo entity, Collection<String> columns, Boolean isAsc, int pageNum, int pageSize);

    /**
     * 通过条件查询图片文件表
     * @param entity
     * @return
     */
     PicInfo getPicInfoByCondition(PicInfo entity);

    /**
     * 通过id查询图片文件表
     * @param id
     * @return
     */
     PicInfo getPicInfo(String id);

    /**
     * 保存或者新增图片文件表
     * @param entity
     * @return
     */
    Boolean savePicInfo(PicInfo entity);


    /**
     * 删除图片文件表
     * @param idlist
     * @return
     */
    Boolean deletePicInfo(List<String> idlist);

}