package com.mankan.plumad.consumer;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.github.pagehelper.PageInfo;
import com.mankan.plumad.dubbo.PlumDicApi;
import org.springframework.stereotype.Component;
import com.mankan.plumad.model.PlumDic;
import com.alibaba.dubbo.config.annotation.Reference;


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
@Component
public class PlumDicConsumer {

    @Reference(version = "1.0.0",
            application = "${dubbo.application.id}",
            cluster = "failover",
            check = false,
            retries = 3,
            timeout = 15000)
    private PlumDicApi dubboApi;

    /**
     * 获取字典表
     * @param entityQuery
     * @return
     */
    public PageInfo listPlumDic(PlumDic entityQuery){
        PlumDic entity = JSON.parseObject(JSON.toJSONString(entityQuery), new TypeReference<PlumDic>() {});
        return dubboApi.listPlumDic(entity);
    }


    /**
     * 获取字典表 按排序
     * @param entityQuery
     * @return
     */
    public PageInfo listPlumDicWithOrderBy(PlumDic entityQuery,Collection<String> columns,Boolean isAsc){
        PlumDic entity = JSON.parseObject(JSON.toJSONString(entityQuery), new TypeReference<PlumDic>() {});
        return dubboApi.listPlumDicWithOrderBy(entity,columns,isAsc);
    }

    /**
     * 通过条件查询字典表
     * @param entity
     * @return
     */
    public  PlumDic getPlumDicByCondition(PlumDic entity){
        return dubboApi.getPlumDicByCondition(entity);
    }

    /**
     * 通过id查询字典表
     * @param id
     * @return
     */
    public  PlumDic getPlumDic(String id){
        return dubboApi.getPlumDic(id);
    }

    /**
     * 保存或者新增字典表
     * @param entity
     * @return
     */
    public Boolean savePlumDic(PlumDic entity){
        return dubboApi.savePlumDic(entity);
    }


    /**
     * 删除字典表
     * @param idlist
     * @return
     */
    public Boolean deletePlumDic(List<String> idlist){
        return dubboApi.deletePlumDic(idlist);
    }

}
