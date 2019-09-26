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
public class PicInfoApiMock implements PicInfoApi {

    @Override
    public PageInfo listPicInfo(PicInfo entity,int pageNum, int pageSize){
        return null;
    }

    @Override
    public PageInfo listPicInfoWithOrderBy(PicInfo entity,Collection<String> columns,Boolean isAsc,int pageNum, int pageSize){
        return null;
    }

    @Override
    public PicInfo getPicInfoByCondition(PicInfo entity){
        return null;
    }

    @Override
    public PicInfo getPicInfo(String id){
        return null;
    }

    @Override
    public Boolean savePicInfo(PicInfo entity){
        return null;
    }

    @Override
    public Boolean deletePicInfo(List<String> idlist){
        return null;
    }

}