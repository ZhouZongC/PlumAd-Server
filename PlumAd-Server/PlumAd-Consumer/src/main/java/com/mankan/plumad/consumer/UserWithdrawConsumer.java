package com.mankan.plumad.consumer;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.github.pagehelper.PageInfo;
import com.mankan.plumad.dubbo.UserWithdrawApi;
import org.springframework.stereotype.Component;
import com.mankan.plumad.model.UserWithdraw;
import com.alibaba.dubbo.config.annotation.Reference;
import com.mankan.plumad.dto.UserWithdrawQuery;


import java.util.List;
import java.util.Collection;

/**
 * <p>
 * 用户分润提现表 api接口
 * </p>
 *
 * @author lq
 * @since 2019-09-24
 */
@Component
public class UserWithdrawConsumer {

    @Reference(version = "1.0.0",
            application = "${dubbo.application.id}",
            cluster = "failover",
            check = false,
            retries = 3,
            timeout = 15000)
    private UserWithdrawApi dubboApi;

    /**
     * 获取用户分润提现表
     * @param entityQuery
     * @return
     */
    public PageInfo listUserWithdraw(UserWithdrawQuery entityQuery){
        UserWithdraw entity = JSON.parseObject(JSON.toJSONString(entityQuery), new TypeReference<UserWithdraw>() {});
        return dubboApi.listUserWithdraw(entity,entityQuery.getPageNum(),entityQuery.getPageSize());
    }


    /**
     * 获取用户分润提现表 按排序
     * @param entityQuery
     * @return
     */
    public PageInfo listUserWithdrawWithOrderBy(UserWithdrawQuery entityQuery,Collection<String> columns,Boolean isAsc){
        UserWithdraw entity = JSON.parseObject(JSON.toJSONString(entityQuery), new TypeReference<UserWithdraw>() {});
        return dubboApi.listUserWithdrawWithOrderBy(entity,columns,isAsc,entityQuery.getPageNum(),entityQuery.getPageSize());
    }

    /**
     * 通过条件查询用户分润提现表
     * @param entity
     * @return
     */
    public  UserWithdraw getUserWithdrawByCondition(UserWithdraw entity){
        return dubboApi.getUserWithdrawByCondition(entity);
    }

    /**
     * 通过id查询用户分润提现表
     * @param id
     * @return
     */
    public  UserWithdraw getUserWithdraw(String id){
        return dubboApi.getUserWithdraw(id);
    }

    /**
     * 保存或者新增用户分润提现表
     * @param entity
     * @return
     */
    public Boolean saveUserWithdraw(UserWithdraw entity){
        return dubboApi.saveUserWithdraw(entity);
    }


    /**
     * 删除用户分润提现表
     * @param idlist
     * @return
     */
    public Boolean deleteUserWithdraw(List<String> idlist){
        return dubboApi.deleteUserWithdraw(idlist);
    }

}
