package com.mankan.plumad.consumer;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.github.pagehelper.PageInfo;
import com.mankan.plumad.dubbo.PicInfoApi;
import org.springframework.stereotype.Component;
import com.mankan.plumad.model.PicInfo;
import com.alibaba.dubbo.config.annotation.Reference;
import com.mankan.plumad.dto.PicInfoQuery;


import java.util.List;
import java.util.Collection;

/**
 * <p>
 * 图片文件表 api接口
 * </p>
 *
 * @author lq
 * @since 2019-09-26
 */
@Component
public class PicInfoConsumer {

    @Reference(version = "1.0.0",
            application = "${dubbo.application.id}",
            cluster = "failover",
            check = false,
            retries = 3,
            timeout = 15000)
    private PicInfoApi dubboApi;

    /**
     * 获取图片文件表
     * @param entityQuery
     * @return
     */
    public PageInfo listPicInfo(PicInfoQuery entityQuery){
        PicInfo entity = JSON.parseObject(JSON.toJSONString(entityQuery), new TypeReference<PicInfo>() {});
        return dubboApi.listPicInfo(entity,entityQuery.getPageNum(),entityQuery.getPageSize());
    }


    /**
     * 获取图片文件表 按排序
     * @param entityQuery
     * @return
     */
    public PageInfo listPicInfoWithOrderBy(PicInfoQuery entityQuery,Collection<String> columns,Boolean isAsc){
        PicInfo entity = JSON.parseObject(JSON.toJSONString(entityQuery), new TypeReference<PicInfo>() {});
        return dubboApi.listPicInfoWithOrderBy(entity,columns,isAsc,entityQuery.getPageNum(),entityQuery.getPageSize());
    }

    /**
     * 通过条件查询图片文件表
     * @param entity
     * @return
     */
    public  PicInfo getPicInfoByCondition(PicInfo entity){
        return dubboApi.getPicInfoByCondition(entity);
    }

    /**
     * 通过id查询图片文件表
     * @param id
     * @return
     */
    public  PicInfo getPicInfo(String id){
        return dubboApi.getPicInfo(id);
    }

    /**
     * 保存或者新增图片文件表
     * @param entity
     * @return
     */
    public Boolean savePicInfo(PicInfo entity){
        return dubboApi.savePicInfo(entity);
    }


    /**
     * 删除图片文件表
     * @param idlist
     * @return
     */
    public Boolean deletePicInfo(List<String> idlist){
        return dubboApi.deletePicInfo(idlist);
    }

}
