package com.mankan.plumad.dubbo;

import com.github.pagehelper.PageInfo;
import com.mankan.plumad.model.AdPromotionMode;

import java.util.List;
import java.util.Collection;

/**
 * <p>
 * 流量主推广方式 api接口
 * </p>
 *
 * @author lq
 * @since 2019-09-24
 */
public class AdPromotionModeApiMock implements AdPromotionModeApi {

    @Override
    public PageInfo listAdPromotionMode(AdPromotionMode entity,int pageNum, int pageSize){
        return null;
    }

    @Override
    public PageInfo listAdPromotionModeWithOrderBy(AdPromotionMode entity,Collection<String> columns,Boolean isAsc,int pageNum, int pageSize){
        return null;
    }

    @Override
    public AdPromotionMode getAdPromotionModeByCondition(AdPromotionMode entity){
        return null;
    }

    @Override
    public AdPromotionMode getAdPromotionMode(String id){
        return null;
    }

    @Override
    public Boolean saveAdPromotionMode(AdPromotionMode entity){
        return null;
    }

    @Override
    public Boolean deleteAdPromotionMode(List<String> idlist){
        return null;
    }

}