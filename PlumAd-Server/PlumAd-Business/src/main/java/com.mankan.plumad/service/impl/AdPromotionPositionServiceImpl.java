package com.mankan.plumad.service.impl;

import com.mankan.plumad.model.AdPromotionPosition;
import com.mankan.plumad.mapper.AdPromotionPositionMapper;
import com.mankan.plumad.service.IAdPromotionPositionService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.toolkit.StringUtils;
import java.util.List;
import java.util.Collection;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;

/**
 * <p>
 * 流量主推广广告位 服务实现类
 * </p>
 *
 * @author lq
 * @since 2019-09-24
 */
@Service
public class AdPromotionPositionServiceImpl extends ServiceImpl<AdPromotionPositionMapper, AdPromotionPosition> implements IAdPromotionPositionService {

        @Override
        public List<AdPromotionPosition> listAdPromotionPosition(AdPromotionPosition entity){
            Wrapper<AdPromotionPosition> ew = new EntityWrapper<AdPromotionPosition>();
            ew.eq(!StringUtils.isEmpty(entity.getId()),"id",entity.getId());
            ew.eq(!StringUtils.isEmpty(entity.getUserId()),"user_id",entity.getUserId());
            ew.eq(!StringUtils.isEmpty(entity.getPromotionCode()),"promotion_code",entity.getPromotionCode());
            ew.eq(!StringUtils.isEmpty(entity.getChargingMode()),"charging_mode",entity.getChargingMode());
            ew.eq(!StringUtils.isEmpty(entity.getPositionName()),"position_name",entity.getPositionName());
            ew.eq(!StringUtils.isEmpty(entity.getPositionCode()),"position_code",entity.getPositionCode());
            ew.eq(!StringUtils.isEmpty(entity.getAdType()),"ad_type",entity.getAdType());
            ew.eq(entity.getSizesWide()!=null,"sizes_wide",entity.getSizesWide());
            ew.eq(entity.getSizesHigh()!=null,"sizes_high",entity.getSizesHigh());
            ew.eq(!StringUtils.isEmpty(entity.getAdShowType()),"ad_show_type",entity.getAdShowType());
            ew.eq(!StringUtils.isEmpty(entity.getAdFilter()),"ad_filter",entity.getAdFilter());
            ew.eq(!StringUtils.isEmpty(entity.getAdPromotionUrl()),"ad_promotion_url",entity.getAdPromotionUrl());
            ew.eq(!StringUtils.isEmpty(entity.getStatus()),"status",entity.getStatus());
            ew.eq(!StringUtils.isEmpty(entity.getRemarks()),"remarks",entity.getRemarks());
            ew.eq(!StringUtils.isEmpty(entity.getDeleteFlag()),"delete_flag",entity.getDeleteFlag());
            ew.eq(entity.getCreateTime()!=null,"create_time",entity.getCreateTime());
            ew.eq(entity.getModifyTime()!=null,"modify_time",entity.getModifyTime());
            ew.eq(!StringUtils.isEmpty(entity.getCreateUser()),"create_user",entity.getCreateUser());
                return this.selectList(ew);
        }

        @Override
        public List<AdPromotionPosition> listAdPromotionPositionWithOrderBy(AdPromotionPosition entity,Collection<String> columns,Boolean isAsc){
        Wrapper<AdPromotionPosition> ew = new EntityWrapper<AdPromotionPosition>();
            ew.eq(!StringUtils.isEmpty(entity.getId()),"id",entity.getId());
            ew.eq(!StringUtils.isEmpty(entity.getUserId()),"user_id",entity.getUserId());
            ew.eq(!StringUtils.isEmpty(entity.getPromotionCode()),"promotion_code",entity.getPromotionCode());
            ew.eq(!StringUtils.isEmpty(entity.getChargingMode()),"charging_mode",entity.getChargingMode());
            ew.eq(!StringUtils.isEmpty(entity.getPositionName()),"position_name",entity.getPositionName());
            ew.eq(!StringUtils.isEmpty(entity.getPositionCode()),"position_code",entity.getPositionCode());
            ew.eq(!StringUtils.isEmpty(entity.getAdType()),"ad_type",entity.getAdType());
            ew.eq(entity.getSizesWide()!=null,"sizes_wide",entity.getSizesWide());
            ew.eq(entity.getSizesHigh()!=null,"sizes_high",entity.getSizesHigh());
            ew.eq(!StringUtils.isEmpty(entity.getAdShowType()),"ad_show_type",entity.getAdShowType());
            ew.eq(!StringUtils.isEmpty(entity.getAdFilter()),"ad_filter",entity.getAdFilter());
            ew.eq(!StringUtils.isEmpty(entity.getAdPromotionUrl()),"ad_promotion_url",entity.getAdPromotionUrl());
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
        public AdPromotionPosition getAdPromotionPositionByCondition(AdPromotionPosition entity){
              Wrapper<AdPromotionPosition> ew = new EntityWrapper<AdPromotionPosition>();
                ew.eq(!StringUtils.isEmpty(entity.getId()),"id",entity.getId());
                ew.eq(!StringUtils.isEmpty(entity.getUserId()),"user_id",entity.getUserId());
                ew.eq(!StringUtils.isEmpty(entity.getPromotionCode()),"promotion_code",entity.getPromotionCode());
                ew.eq(!StringUtils.isEmpty(entity.getChargingMode()),"charging_mode",entity.getChargingMode());
                ew.eq(!StringUtils.isEmpty(entity.getPositionName()),"position_name",entity.getPositionName());
                ew.eq(!StringUtils.isEmpty(entity.getPositionCode()),"position_code",entity.getPositionCode());
                ew.eq(!StringUtils.isEmpty(entity.getAdType()),"ad_type",entity.getAdType());
                ew.eq(entity.getSizesWide()!=null,"sizes_wide",entity.getSizesWide());
                ew.eq(entity.getSizesHigh()!=null,"sizes_high",entity.getSizesHigh());
                ew.eq(!StringUtils.isEmpty(entity.getAdShowType()),"ad_show_type",entity.getAdShowType());
                ew.eq(!StringUtils.isEmpty(entity.getAdFilter()),"ad_filter",entity.getAdFilter());
                ew.eq(!StringUtils.isEmpty(entity.getAdPromotionUrl()),"ad_promotion_url",entity.getAdPromotionUrl());
                ew.eq(!StringUtils.isEmpty(entity.getStatus()),"status",entity.getStatus());
                ew.eq(!StringUtils.isEmpty(entity.getRemarks()),"remarks",entity.getRemarks());
                ew.eq(!StringUtils.isEmpty(entity.getDeleteFlag()),"delete_flag",entity.getDeleteFlag());
                ew.eq(entity.getCreateTime()!=null,"create_time",entity.getCreateTime());
                ew.eq(entity.getModifyTime()!=null,"modify_time",entity.getModifyTime());
                ew.eq(!StringUtils.isEmpty(entity.getCreateUser()),"create_user",entity.getCreateUser());
             return this.selectOne(ew);
        }
}
