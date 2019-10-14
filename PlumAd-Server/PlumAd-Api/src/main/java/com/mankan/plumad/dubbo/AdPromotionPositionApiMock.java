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
public class AdPromotionPositionApiMock implements AdPromotionPositionApi {

    @Override
    public PageInfo listAdPromotionPosition(AdPromotionPosition entity,int pageNum, int pageSize){
        return null;
    }

    @Override
    public PageInfo listAdPromotionPositionWithOrderBy(AdPromotionPosition entity,Collection<String> columns,Boolean isAsc,int pageNum, int pageSize){
        return null;
    }

    @Override
    public AdPromotionPosition getAdPromotionPositionByCondition(AdPromotionPosition entity){
        return null;
    }

    @Override
    public AdPromotionPosition getAdPromotionPosition(String id){
        return null;
    }

    @Override
    public Boolean saveAdPromotionPosition(AdPromotionPosition entity){
        return null;
    }

    @Override
    public Boolean deleteAdPromotionPosition(List<String> idlist){
        return null;
    }

    @Override
    public AdPromotionDTO getAdPromotionDTO(String positionCode) {
        return null;
    }

}
