package com.mankan.plumad.consumer;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.github.pagehelper.PageInfo;
import com.mankan.plumad.dto.AdPromotionDTO;
import com.mankan.plumad.dubbo.AdPromotionPositionApi;
import org.springframework.stereotype.Component;
import com.mankan.plumad.model.AdPromotionPosition;
import com.alibaba.dubbo.config.annotation.Reference;
import com.mankan.plumad.dto.AdPromotionPositionQuery;


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
@Component
public class AdPromotionPositionConsumer {

    @Reference(version = "1.0.0",
            application = "${dubbo.application.id}",
            cluster = "failover",
            check = false,
            retries = 3,
            timeout = 15000)
    private AdPromotionPositionApi dubboApi;

    /**
     * 获取流量主推广广告位
     * @param entityQuery
     * @return
     */
    public PageInfo listAdPromotionPosition(AdPromotionPositionQuery entityQuery){
        AdPromotionPosition entity = JSON.parseObject(JSON.toJSONString(entityQuery), new TypeReference<AdPromotionPosition>() {});
        return dubboApi.listAdPromotionPosition(entity,entityQuery.getPageNum(),entityQuery.getPageSize());
    }


    /**
     * 获取流量主推广广告位 按排序
     * @param entityQuery
     * @return
     */
    public PageInfo listAdPromotionPositionWithOrderBy(AdPromotionPositionQuery entityQuery,Collection<String> columns,Boolean isAsc){
        AdPromotionPosition entity = JSON.parseObject(JSON.toJSONString(entityQuery), new TypeReference<AdPromotionPosition>() {});
        return dubboApi.listAdPromotionPositionWithOrderBy(entity,columns,isAsc,entityQuery.getPageNum(),entityQuery.getPageSize());
    }

    /**
     * 通过条件查询流量主推广广告位
     * @param entity
     * @return
     */
    public  AdPromotionPosition getAdPromotionPositionByCondition(AdPromotionPosition entity){
        return dubboApi.getAdPromotionPositionByCondition(entity);
    }

    /**
     * 通过id查询流量主推广广告位
     * @param id
     * @return
     */
    public  AdPromotionPosition getAdPromotionPosition(String id){
        return dubboApi.getAdPromotionPosition(id);
    }

    /**
     * 保存或者新增流量主推广广告位
     * @param entity
     * @return
     */
    public Boolean saveAdPromotionPosition(AdPromotionPosition entity){
        return dubboApi.saveAdPromotionPosition(entity);
    }


    /**
     * 删除流量主推广广告位
     * @param idlist
     * @return
     */
    public Boolean deleteAdPromotionPosition(List<String> idlist){
        return dubboApi.deleteAdPromotionPosition(idlist);
    }

    //////////////////////////////////ad/////////////////////////////

    /**
     * 获取推荐广告位相关信息
     * @param positionCode
     * @return
     */
    public  AdPromotionDTO getAdPromotionDTO(String positionCode) {
        return dubboApi.getAdPromotionDTO(positionCode);
    }



}
