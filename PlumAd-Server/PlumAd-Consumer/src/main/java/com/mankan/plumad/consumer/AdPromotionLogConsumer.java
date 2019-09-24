package com.mankan.plumad.consumer;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.github.pagehelper.PageInfo;
import com.mankan.plumad.dubbo.AdPromotionLogApi;
import org.springframework.stereotype.Component;
import com.mankan.plumad.model.AdPromotionLog;
import com.alibaba.dubbo.config.annotation.Reference;
import com.mankan.plumad.dto.AdPromotionLogQuery;


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
@Component
public class AdPromotionLogConsumer {

    @Reference(version = "1.0.0",
            application = "${dubbo.application.id}",
            cluster = "failover",
            check = false,
            retries = 3,
            timeout = 15000)
    private AdPromotionLogApi dubboApi;

    /**
     * 获取流量主推广日志
     * @param entityQuery
     * @return
     */
    public PageInfo listAdPromotionLog(AdPromotionLogQuery entityQuery){
        AdPromotionLog entity = JSON.parseObject(JSON.toJSONString(entityQuery), new TypeReference<AdPromotionLog>() {});
        return dubboApi.listAdPromotionLog(entity,entityQuery.getPageNum(),entityQuery.getPageSize());
    }


    /**
     * 获取流量主推广日志 按排序
     * @param entityQuery
     * @return
     */
    public PageInfo listAdPromotionLogWithOrderBy(AdPromotionLogQuery entityQuery,Collection<String> columns,Boolean isAsc){
        AdPromotionLog entity = JSON.parseObject(JSON.toJSONString(entityQuery), new TypeReference<AdPromotionLog>() {});
        return dubboApi.listAdPromotionLogWithOrderBy(entity,columns,isAsc,entityQuery.getPageNum(),entityQuery.getPageSize());
    }

    /**
     * 通过条件查询流量主推广日志
     * @param entity
     * @return
     */
    public  AdPromotionLog getAdPromotionLogByCondition(AdPromotionLog entity){
        return dubboApi.getAdPromotionLogByCondition(entity);
    }

    /**
     * 通过id查询流量主推广日志
     * @param id
     * @return
     */
    public  AdPromotionLog getAdPromotionLog(String id){
        return dubboApi.getAdPromotionLog(id);
    }

    /**
     * 保存或者新增流量主推广日志
     * @param entity
     * @return
     */
    public Boolean saveAdPromotionLog(AdPromotionLog entity){
        return dubboApi.saveAdPromotionLog(entity);
    }


    /**
     * 删除流量主推广日志
     * @param idlist
     * @return
     */
    public Boolean deleteAdPromotionLog(List<String> idlist){
        return dubboApi.deleteAdPromotionLog(idlist);
    }

}
