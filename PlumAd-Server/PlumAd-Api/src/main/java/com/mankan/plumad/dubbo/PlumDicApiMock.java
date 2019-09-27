package com.mankan.plumad.dubbo;

import com.github.pagehelper.PageInfo;
import com.mankan.plumad.model.PlumDic;

import java.util.List;
import java.util.Collection;

/**
 * <p>
 * 字典表 api接口
 * </p>
 *
 * @author lq
 * @since 2019-09-26
 */
public class PlumDicApiMock implements PlumDicApi {


    @Override
    public PageInfo listPlumDic(PlumDic entity) {
        return null;
    }

    @Override
    public PageInfo listPlumDicWithOrderBy(PlumDic entity, Collection<String> columns, Boolean isAsc) {
        return null;
    }

    @Override
    public PlumDic getPlumDicByCondition(PlumDic entity) {
        return null;
    }

    @Override
    public PlumDic getPlumDic(String id) {
        return null;
    }

    @Override
    public Boolean savePlumDic(PlumDic entity) {
        return null;
    }

    @Override
    public Boolean deletePlumDic(List<String> idlist) {
        return null;
    }
}