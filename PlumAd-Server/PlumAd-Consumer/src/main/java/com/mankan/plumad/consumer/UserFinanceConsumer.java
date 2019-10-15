package com.mankan.plumad.consumer;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.github.pagehelper.PageInfo;
import com.mankan.plumad.dubbo.UserFinanceApi;
import org.springframework.stereotype.Component;
import com.mankan.plumad.model.UserFinance;
import com.alibaba.dubbo.config.annotation.Reference;
import com.mankan.plumad.dto.UserFinanceQuery;


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
@Component
public class UserFinanceConsumer {

    @Reference(version = "1.0.0",
            application = "${dubbo.application.id}",
            cluster = "failover",
            check = false,
            retries = 3,
            timeout = 15000)
    private UserFinanceApi dubboApi;

    /**
     * 获取用户财务表
     * @param entityQuery
     * @return
     */
    public PageInfo listUserFinance(UserFinanceQuery entityQuery){
        UserFinance entity = JSON.parseObject(JSON.toJSONString(entityQuery), new TypeReference<UserFinance>() {});
        return dubboApi.listUserFinance(entity,entityQuery.getPageNum(),entityQuery.getPageSize());
    }


    /**
     * 获取用户财务表 按排序
     * @param entityQuery
     * @return
     */
    public PageInfo listUserFinanceWithOrderBy(UserFinanceQuery entityQuery,Collection<String> columns,Boolean isAsc){
        UserFinance entity = JSON.parseObject(JSON.toJSONString(entityQuery), new TypeReference<UserFinance>() {});
        return dubboApi.listUserFinanceWithOrderBy(entity,columns,isAsc,entityQuery.getPageNum(),entityQuery.getPageSize());
    }

    /**
     * 通过条件查询用户财务表
     * @param entity
     * @return
     */
    public  UserFinance getUserFinanceByCondition(UserFinance entity){
        return dubboApi.getUserFinanceByCondition(entity);
    }

    /**
     * 通过id查询用户财务表
     * @param id
     * @return
     */
    public  UserFinance getUserFinance(String id){
        return dubboApi.getUserFinance(id);
    }

    /**
     * 保存或者新增用户财务表
     * @param entity
     * @return
     */
    public Boolean saveUserFinance(UserFinance entity){
        return dubboApi.saveUserFinance(entity);
    }


    /**
     * 删除用户财务表
     * @param idlist
     * @return
     */
    public Boolean deleteUserFinance(List<String> idlist){
        return dubboApi.deleteUserFinance(idlist);
    }

    public Boolean updateUserFinanceForS001(String userId, BigDecimal totalAmount) {
        return dubboApi.updateUserFinanceForS001(userId,totalAmount);
    }

    public Boolean updateUserFinanceForE001(String userId, BigDecimal totalAmount) {
        return dubboApi.updateUserFinanceForE001(userId,totalAmount);
    }

    public Boolean updateUserFinanceForRecharge(String userId, BigDecimal rechargeAmount) {
        return dubboApi.updateUserFinanceForRecharge(userId,rechargeAmount);
    }
}
