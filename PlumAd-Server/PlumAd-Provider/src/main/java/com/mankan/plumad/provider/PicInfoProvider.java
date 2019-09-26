package com.mankan.plumad.provider;

import com.github.pagehelper.PageInfo;
import com.mankan.plumad.dubbo.PicInfoApi;
import com.mankan.plumad.model.PicInfo;
import com.mankan.plumad.service.IPicInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;


import java.util.List;
import java.util.Collection;

/**
 * <p>
 * 图片文件表 provider
 * </p>
 *
 * @author lq
 * @since 2019-09-26
 */
@Service(version = "1.0.0",
        application = "${dubbo.application.id}",
        protocol = "${dubbo.protocol.id}",
        registry = "${dubbo.registry.id}")
public class PicInfoProvider implements PicInfoApi {

    @Autowired
    private IPicInfoService service;

    @Override
    public PageInfo listPicInfo(PicInfo entity,int pageNum, int pageSize){
        PageHelper.startPage(pageNum,pageSize);
        List<PicInfo> PicInfos = service.listPicInfo(entity);
        PageInfo<PicInfo> pageInfo = new PageInfo<PicInfo>(PicInfos);
        return pageInfo;
    }

    @Override
    public PageInfo listPicInfoWithOrderBy(PicInfo entity,Collection<String> columns,Boolean isAsc,int pageNum, int pageSize){
        PageHelper.startPage(pageNum,pageSize);
        List<PicInfo> PicInfos = service.listPicInfoWithOrderBy(entity,columns,isAsc);
        PageInfo<PicInfo> pageInfo = new PageInfo<PicInfo>(PicInfos);
        return pageInfo;
    }

    @Override
    public PicInfo getPicInfo(String id){
        return service.selectById(id);
    }

    @Override
    public PicInfo getPicInfoByCondition(PicInfo entity){
        return service.getPicInfoByCondition(entity);
    }

    @Override
    public Boolean savePicInfo(PicInfo entity){
        return service.insertOrUpdate(entity);
    }

    @Override
    public Boolean deletePicInfo(List<String> idlist){
        return service.deleteBatchIds(idlist);
    }

}
