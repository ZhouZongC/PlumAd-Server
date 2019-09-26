package com.mankan.plumad.service.impl;

import com.mankan.plumad.model.PicInfo;
import com.mankan.plumad.mapper.PicInfoMapper;
import com.mankan.plumad.service.IPicInfoService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.toolkit.StringUtils;
import java.util.List;
import java.util.Collection;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;

/**
 * <p>
 * 图片文件表 服务实现类
 * </p>
 *
 * @author lq
 * @since 2019-09-26
 */
@Service
public class PicInfoServiceImpl extends ServiceImpl<PicInfoMapper, PicInfo> implements IPicInfoService {

        @Override
        public List<PicInfo> listPicInfo(PicInfo entity){
            Wrapper<PicInfo> ew = new EntityWrapper<PicInfo>();
            ew.eq(!StringUtils.isEmpty(entity.getId()),"id",entity.getId());
            ew.eq(!StringUtils.isEmpty(entity.getPicUrl()),"pic_url",entity.getPicUrl());
            ew.eq(!StringUtils.isEmpty(entity.getPicPath()),"pic_path",entity.getPicPath());
                return this.selectList(ew);
        }

        @Override
        public List<PicInfo> listPicInfoWithOrderBy(PicInfo entity,Collection<String> columns,Boolean isAsc){
        Wrapper<PicInfo> ew = new EntityWrapper<PicInfo>();
            ew.eq(!StringUtils.isEmpty(entity.getId()),"id",entity.getId());
            ew.eq(!StringUtils.isEmpty(entity.getPicUrl()),"pic_url",entity.getPicUrl());
            ew.eq(!StringUtils.isEmpty(entity.getPicPath()),"pic_path",entity.getPicPath());
             ew.orderBy(true,columns,isAsc);
        return this.selectList(ew);
        }


        @Override
        public PicInfo getPicInfoByCondition(PicInfo entity){
              Wrapper<PicInfo> ew = new EntityWrapper<PicInfo>();
                ew.eq(!StringUtils.isEmpty(entity.getId()),"id",entity.getId());
                ew.eq(!StringUtils.isEmpty(entity.getPicUrl()),"pic_url",entity.getPicUrl());
                ew.eq(!StringUtils.isEmpty(entity.getPicPath()),"pic_path",entity.getPicPath());
             return this.selectOne(ew);
        }
}
