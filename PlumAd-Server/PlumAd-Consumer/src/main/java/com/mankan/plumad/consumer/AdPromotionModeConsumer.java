package com.mankan.plumad.consumer;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.github.pagehelper.PageInfo;
import com.mankan.plumad.dubbo.AdPromotionModeApi;
import org.springframework.stereotype.Component;
import com.mankan.plumad.model.AdPromotionMode;
import com.alibaba.dubbo.config.annotation.Reference;
import com.mankan.plumad.dto.AdPromotionModeQuery;


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
@Component
public class AdPromotionModeConsumer {

    @Reference(version = "1.0.0",
            application = "${dubbo.application.id}",
            cluster = "failover",
            check = false,
            retries = 3,
            timeout = 15000)
    private AdPromotionModeApi dubboApi;

    /**
     * 获取流量主推广方式
     * @param entityQuery
     * @return
     */
    public PageInfo listAdPromotionMode(AdPromotionModeQuery entityQuery){
        AdPromotionMode entity = JSON.parseObject(JSON.toJSONString(entityQuery), new TypeReference<AdPromotionMode>() {});
        return dubboApi.listAdPromotionMode(entity,entityQuery.getPageNum(),entityQuery.getPageSize());
    }


    /**
     * 获取流量主推广方式 按排序
     * @param entityQuery
     * @return
     */
    public PageInfo listAdPromotionModeWithOrderBy(AdPromotionModeQuery entityQuery,Collection<String> columns,Boolean isAsc){
        AdPromotionMode entity = JSON.parseObject(JSON.toJSONString(entityQuery), new TypeReference<AdPromotionMode>() {});
        return dubboApi.listAdPromotionModeWithOrderBy(entity,columns,isAsc,entityQuery.getPageNum(),entityQuery.getPageSize());
    }

    /**
     * 通过条件查询流量主推广方式
     * @param entity
     * @return
     */
    public  AdPromotionMode getAdPromotionModeByCondition(AdPromotionMode entity){
        return dubboApi.getAdPromotionModeByCondition(entity);
    }

    /**
     * 通过id查询流量主推广方式
     * @param id
     * @return
     */
    public  AdPromotionMode getAdPromotionMode(String id){
        return dubboApi.getAdPromotionMode(id);
    }

    /**
     * 保存或者新增流量主推广方式
     * @param entity
     * @return
     */
    public Boolean saveAdPromotionMode(AdPromotionMode entity){
        return dubboApi.saveAdPromotionMode(entity);
    }


    /**
     * 删除流量主推广方式
     * @param idlist
     * @return
     */
    public Boolean deleteAdPromotionMode(List<String> idlist){
        return dubboApi.deleteAdPromotionMode(idlist);
    }

}
