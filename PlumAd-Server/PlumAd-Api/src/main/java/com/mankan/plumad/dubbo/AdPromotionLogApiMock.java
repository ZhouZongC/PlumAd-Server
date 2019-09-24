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
public class AdPromotionLogApiMock implements AdPromotionLogApi {

    @Override
    public PageInfo listAdPromotionLog(AdPromotionLog entity,int pageNum, int pageSize){
        return null;
    }

    @Override
    public PageInfo listAdPromotionLogWithOrderBy(AdPromotionLog entity,Collection<String> columns,Boolean isAsc,int pageNum, int pageSize){
        return null;
    }

    @Override
    public AdPromotionLog getAdPromotionLogByCondition(AdPromotionLog entity){
        return null;
    }

    @Override
    public AdPromotionLog getAdPromotionLog(String id){
        return null;
    }

    @Override
    public Boolean saveAdPromotionLog(AdPromotionLog entity){
        return null;
    }

    @Override
    public Boolean deleteAdPromotionLog(List<String> idlist){
        return null;
    }

}