package com.mankan.plumad.service.impl;

import com.mankan.plumad.model.AdPromotionInfo;
import com.mankan.plumad.mapper.AdPromotionInfoMapper;
import com.mankan.plumad.service.IAdPromotionInfoService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.toolkit.StringUtils;
import java.util.List;
import java.util.Collection;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;

/**
 * <p>
 * 广告推广信息 服务实现类
 * </p>
 *
 * @author lq
 * @since 2019-09-24
 */
@Service
public class AdPromotionInfoServiceImpl extends ServiceImpl<AdPromotionInfoMapper, AdPromotionInfo> implements IAdPromotionInfoService {

        @Override
        public List<AdPromotionInfo> listAdPromotionInfo(AdPromotionInfo entity){
            Wrapper<AdPromotionInfo> ew = new EntityWrapper<AdPromotionInfo>();
            ew.eq(!StringUtils.isEmpty(entity.getId()),"id",entity.getId());
            ew.eq(!StringUtils.isEmpty(entity.getUserId()),"user_id",entity.getUserId());
            ew.eq(!StringUtils.isEmpty(entity.getPlanCode()),"plan_code",entity.getPlanCode());
            ew.eq(!StringUtils.isEmpty(entity.getAdType()),"ad_type",entity.getAdType());
            ew.eq(!StringUtils.isEmpty(entity.getAdSizes()),"ad_sizes",entity.getAdSizes());
            ew.eq(!StringUtils.isEmpty(entity.getPicType()),"pic_type",entity.getPicType());
            ew.eq(!StringUtils.isEmpty(entity.getPicUrl()),"pic_url",entity.getPicUrl());
            ew.eq(!StringUtils.isEmpty(entity.getAdUrl()),"ad_url",entity.getAdUrl());
            ew.eq(!StringUtils.isEmpty(entity.getStatus()),"status",entity.getStatus());
            ew.eq(!StringUtils.isEmpty(entity.getRemarks()),"remarks",entity.getRemarks());
            ew.eq(!StringUtils.isEmpty(entity.getDeleteFlag()),"delete_flag",entity.getDeleteFlag());
            ew.eq(entity.getCreateTime()!=null,"create_time",entity.getCreateTime());
            ew.eq(entity.getModifyTime()!=null,"modify_time",entity.getModifyTime());
            ew.eq(!StringUtils.isEmpty(entity.getCreateUser()),"create_user",entity.getCreateUser());
                return this.selectList(ew);
        }

        @Override
        public List<AdPromotionInfo> listAdPromotionInfoWithOrderBy(AdPromotionInfo entity,Collection<String> columns,Boolean isAsc){
        Wrapper<AdPromotionInfo> ew = new EntityWrapper<AdPromotionInfo>();
            ew.eq(!StringUtils.isEmpty(entity.getId()),"id",entity.getId());
            ew.eq(!StringUtils.isEmpty(entity.getUserId()),"user_id",entity.getUserId());
            ew.eq(!StringUtils.isEmpty(entity.getPlanCode()),"plan_code",entity.getPlanCode());
            ew.eq(!StringUtils.isEmpty(entity.getAdType()),"ad_type",entity.getAdType());
            ew.eq(!StringUtils.isEmpty(entity.getAdSizes()),"ad_sizes",entity.getAdSizes());
            ew.eq(!StringUtils.isEmpty(entity.getPicType()),"pic_type",entity.getPicType());
            ew.eq(!StringUtils.isEmpty(entity.getPicUrl()),"pic_url",entity.getPicUrl());
            ew.eq(!StringUtils.isEmpty(entity.getAdUrl()),"ad_url",entity.getAdUrl());
            ew.eq(!StringUtils.isEmpty(entity.getStatus()),"status",entity.getStatus());
            ew.eq(!StringUtils.isEmpty(entity.getRemarks()),"remarks",entity.getRemarks());
            ew.eq(!StringUtils.isEmpty(entity.getDeleteFlag()),"delete_flag",entity.getDeleteFlag());
            ew.eq(entity.getCreateTime()!=null,"create_time",entity.getCreateTime());
            ew.eq(entity.getModifyTime()!=null,"modify_time",entity.getModifyTime());
            ew.eq(!StringUtils.isEmpty(entity.getCreateUser()),"create_user",entity.getCreateUser());
             ew.orderBy(true,columns,isAsc);
        return this.selectList(ew);
        }


        @Override
        public AdPromotionInfo getAdPromotionInfoByCondition(AdPromotionInfo entity){
              Wrapper<AdPromotionInfo> ew = new EntityWrapper<AdPromotionInfo>();
                ew.eq(!StringUtils.isEmpty(entity.getId()),"id",entity.getId());
                ew.eq(!StringUtils.isEmpty(entity.getUserId()),"user_id",entity.getUserId());
                ew.eq(!StringUtils.isEmpty(entity.getPlanCode()),"plan_code",entity.getPlanCode());
                ew.eq(!StringUtils.isEmpty(entity.getAdType()),"ad_type",entity.getAdType());
                ew.eq(!StringUtils.isEmpty(entity.getAdSizes()),"ad_sizes",entity.getAdSizes());
                ew.eq(!StringUtils.isEmpty(entity.getPicType()),"pic_type",entity.getPicType());
                ew.eq(!StringUtils.isEmpty(entity.getPicUrl()),"pic_url",entity.getPicUrl());
                ew.eq(!StringUtils.isEmpty(entity.getAdUrl()),"ad_url",entity.getAdUrl());
                ew.eq(!StringUtils.isEmpty(entity.getStatus()),"status",entity.getStatus());
                ew.eq(!StringUtils.isEmpty(entity.getRemarks()),"remarks",entity.getRemarks());
                ew.eq(!StringUtils.isEmpty(entity.getDeleteFlag()),"delete_flag",entity.getDeleteFlag());
                ew.eq(entity.getCreateTime()!=null,"create_time",entity.getCreateTime());
                ew.eq(entity.getModifyTime()!=null,"modify_time",entity.getModifyTime());
                ew.eq(!StringUtils.isEmpty(entity.getCreateUser()),"create_user",entity.getCreateUser());
             return this.selectOne(ew);
        }

        @Override
        public List<AdPromotionInfo> listAdvertisingDisplay(String positionCode) {
            return baseMapper.listAdvertisingDisplay(positionCode);
        }
}
