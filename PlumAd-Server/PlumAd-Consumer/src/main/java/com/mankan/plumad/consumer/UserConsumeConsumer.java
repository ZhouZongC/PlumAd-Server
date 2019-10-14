package com.mankan.plumad.consumer;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.github.pagehelper.PageInfo;
import com.mankan.plumad.dubbo.UserConsumeApi;
import org.springframework.stereotype.Component;
import com.mankan.plumad.model.UserConsume;
import com.alibaba.dubbo.config.annotation.Reference;
import com.mankan.plumad.dto.UserConsumeQuery;


import java.util.List;
import java.util.Collection;

/**
 * <p>
 * 用户分润提现表 api接口
 * </p>
 *
 * @author lq
 * @since 2019-10-14
 */
@Component
public class UserConsumeConsumer {

    @Reference(version = "1.0.0",
            application = "${dubbo.application.id}",
            cluster = "failover",
            check = false,
            retries = 3,
            timeout = 15000)
    private UserConsumeApi dubboApi;

    /**
     * 获取用户分润提现表
     * @param entityQuery
     * @return
     */
    public PageInfo listUserConsume(UserConsumeQuery entityQuery){
        UserConsume entity = JSON.parseObject(JSON.toJSONString(entityQuery), new TypeReference<UserConsume>() {});
        return dubboApi.listUserConsume(entity,entityQuery.getPageNum(),entityQuery.getPageSize());
    }


    /**
     * 获取用户分润提现表 按排序
     * @param entityQuery
     * @return
     */
    public PageInfo listUserConsumeWithOrderBy(UserConsumeQuery entityQuery,Collection<String> columns,Boolean isAsc){
        UserConsume entity = JSON.parseObject(JSON.toJSONString(entityQuery), new TypeReference<UserConsume>() {});
        return dubboApi.listUserConsumeWithOrderBy(entity,columns,isAsc,entityQuery.getPageNum(),entityQuery.getPageSize());
    }

    /**
     * 通过条件查询用户分润提现表
     * @param entity
     * @return
     */
    public  UserConsume getUserConsumeByCondition(UserConsume entity){
        return dubboApi.getUserConsumeByCondition(entity);
    }

    /**
     * 通过id查询用户分润提现表
     * @param id
     * @return
     */
    public  UserConsume getUserConsume(String id){
        return dubboApi.getUserConsume(id);
    }

    /**
     * 保存或者新增用户分润提现表
     * @param entity
     * @return
     */
    public Boolean saveUserConsume(UserConsume entity){
        return dubboApi.saveUserConsume(entity);
    }


    /**
     * 删除用户分润提现表
     * @param idlist
     * @return
     */
    public Boolean deleteUserConsume(List<String> idlist){
        return dubboApi.deleteUserConsume(idlist);
    }

}
