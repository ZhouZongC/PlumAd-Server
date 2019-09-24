package com.mankan.plumad.consumer;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.github.pagehelper.PageInfo;
import com.mankan.plumad.dubbo.UserRechargeApi;
import org.springframework.stereotype.Component;
import com.mankan.plumad.model.UserRecharge;
import com.alibaba.dubbo.config.annotation.Reference;
import com.mankan.plumad.dto.UserRechargeQuery;


import java.util.List;
import java.util.Collection;

/**
 * <p>
 * 用户充值记录表 api接口
 * </p>
 *
 * @author lq
 * @since 2019-09-24
 */
@Component
public class UserRechargeConsumer {

    @Reference(version = "1.0.0",
            application = "${dubbo.application.id}",
            cluster = "failover",
            check = false,
            retries = 3,
            timeout = 15000)
    private UserRechargeApi dubboApi;

    /**
     * 获取用户充值记录表
     * @param entityQuery
     * @return
     */
    public PageInfo listUserRecharge(UserRechargeQuery entityQuery){
        UserRecharge entity = JSON.parseObject(JSON.toJSONString(entityQuery), new TypeReference<UserRecharge>() {});
        return dubboApi.listUserRecharge(entity,entityQuery.getPageNum(),entityQuery.getPageSize());
    }


    /**
     * 获取用户充值记录表 按排序
     * @param entityQuery
     * @return
     */
    public PageInfo listUserRechargeWithOrderBy(UserRechargeQuery entityQuery,Collection<String> columns,Boolean isAsc){
        UserRecharge entity = JSON.parseObject(JSON.toJSONString(entityQuery), new TypeReference<UserRecharge>() {});
        return dubboApi.listUserRechargeWithOrderBy(entity,columns,isAsc,entityQuery.getPageNum(),entityQuery.getPageSize());
    }

    /**
     * 通过条件查询用户充值记录表
     * @param entity
     * @return
     */
    public  UserRecharge getUserRechargeByCondition(UserRecharge entity){
        return dubboApi.getUserRechargeByCondition(entity);
    }

    /**
     * 通过id查询用户充值记录表
     * @param id
     * @return
     */
    public  UserRecharge getUserRecharge(String id){
        return dubboApi.getUserRecharge(id);
    }

    /**
     * 保存或者新增用户充值记录表
     * @param entity
     * @return
     */
    public Boolean saveUserRecharge(UserRecharge entity){
        return dubboApi.saveUserRecharge(entity);
    }


    /**
     * 删除用户充值记录表
     * @param idlist
     * @return
     */
    public Boolean deleteUserRecharge(List<String> idlist){
        return dubboApi.deleteUserRecharge(idlist);
    }

}
