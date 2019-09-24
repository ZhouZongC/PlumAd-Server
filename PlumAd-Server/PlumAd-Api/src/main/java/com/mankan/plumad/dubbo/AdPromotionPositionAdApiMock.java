package com.mankan.plumad.dubbo;

import com.github.pagehelper.PageInfo;
import com.mankan.plumad.model.AdPromotionPositionAd;

import java.util.List;
import java.util.Collection;

/**
 * <p>
 * 流量主推广广告位对应广告 api接口
 * </p>
 *
 * @author lq
 * @since 2019-09-24
 */
public class AdPromotionPositionAdApiMock implements AdPromotionPositionAdApi {

    @Override
    public PageInfo listAdPromotionPositionAd(AdPromotionPositionAd entity,int pageNum, int pageSize){
        return null;
    }

    @Override
    public PageInfo listAdPromotionPositionAdWithOrderBy(AdPromotionPositionAd entity,Collection<String> columns,Boolean isAsc,int pageNum, int pageSize){
        return null;
    }

    @Override
    public AdPromotionPositionAd getAdPromotionPositionAdByCondition(AdPromotionPositionAd entity){
        return null;
    }

    @Override
    public AdPromotionPositionAd getAdPromotionPositionAd(String id){
        return null;
    }

    @Override
    public Boolean saveAdPromotionPositionAd(AdPromotionPositionAd entity){
        return null;
    }

    @Override
    public Boolean deleteAdPromotionPositionAd(List<String> idlist){
        return null;
    }

}