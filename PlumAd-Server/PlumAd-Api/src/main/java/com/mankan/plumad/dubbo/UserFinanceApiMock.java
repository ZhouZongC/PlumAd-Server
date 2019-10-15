package com.mankan.plumad.dubbo;

import com.github.pagehelper.PageInfo;
import com.mankan.plumad.model.UserFinance;

import java.math.BigDecimal;
import java.util.List;
import java.util.Collection;

/**
 * <p>
 * 用户财务表 api接口
 * </p>
 *
 * @author lq
 * @since 2019-09-24
 */
public class UserFinanceApiMock implements UserFinanceApi {

    @Override
    public PageInfo listUserFinance(UserFinance entity,int pageNum, int pageSize){
        return null;
    }

    @Override
    public PageInfo listUserFinanceWithOrderBy(UserFinance entity,Collection<String> columns,Boolean isAsc,int pageNum, int pageSize){
        return null;
    }

    @Override
    public UserFinance getUserFinanceByCondition(UserFinance entity){
        return null;
    }

    @Override
    public UserFinance getUserFinance(String id){
        return null;
    }

    @Override
    public Boolean saveUserFinance(UserFinance entity){
        return null;
    }

    @Override
    public Boolean deleteUserFinance(List<String> idlist){
        return null;
    }

    @Override
    public Boolean updateUserFinanceForS001(String userId, BigDecimal totalAmount) {
        return null;
    }

    @Override
    public Boolean updateUserFinanceForE001(String userId, BigDecimal totalAmount) {
        return null;
    }

    @Override
    public Boolean updateUserFinanceForRecharge(String userId, BigDecimal rechargeAmount) {
        return null;
    }

}
