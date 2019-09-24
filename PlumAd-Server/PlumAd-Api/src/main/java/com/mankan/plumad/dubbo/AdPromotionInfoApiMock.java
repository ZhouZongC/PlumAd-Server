package com.mankan.plumad.dubbo;

import com.github.pagehelper.PageInfo;
import com.mankan.plumad.model.AdPromotionInfo;

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
public class AdPromotionInfoApiMock implements AdPromotionInfoApi {

    @Override
    public PageInfo listAdPromotionInfo(AdPromotionInfo entity,int pageNum, int pageSize){
        return null;
    }

    @Override
    public PageInfo listAdPromotionInfoWithOrderBy(AdPromotionInfo entity,Collection<String> columns,Boolean isAsc,int pageNum, int pageSize){
        return null;
    }

    @Override
    public AdPromotionInfo getAdPromotionInfoByCondition(AdPromotionInfo entity){
        return null;
    }

    @Override
    public AdPromotionInfo getAdPromotionInfo(String id){
        return null;
    }

    @Override
    public Boolean saveAdPromotionInfo(AdPromotionInfo entity){
        return null;
    }

    @Override
    public Boolean deleteAdPromotionInfo(List<String> idlist){
        return null;
    }

}