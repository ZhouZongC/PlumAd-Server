package com.mankan.plumad.service.impl;

import com.mankan.plumad.model.AdPromotionPositionAd;
import com.mankan.plumad.mapper.AdPromotionPositionAdMapper;
import com.mankan.plumad.service.IAdPromotionPositionAdService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.toolkit.StringUtils;
import java.util.List;
import java.util.Collection;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;

/**
 * <p>
 * 流量主推广广告位对应广告 服务实现类
 * </p>
 *
 * @author lq
 * @since 2019-09-24
 */
@Service
public class AdPromotionPositionAdServiceImpl extends ServiceImpl<AdPromotionPositionAdMapper, AdPromotionPositionAd> implements IAdPromotionPositionAdService {

        @Override
        public List<AdPromotionPositionAd> listAdPromotionPositionAd(AdPromotionPositionAd entity){
            Wrapper<AdPromotionPositionAd> ew = new EntityWrapper<AdPromotionPositionAd>();
            ew.eq(!StringUtils.isEmpty(entity.getId()),"id",entity.getId());
            ew.eq(!StringUtils.isEmpty(entity.getUserId()),"user_id",entity.getUserId());
            ew.eq(!StringUtils.isEmpty(entity.getPositionCode()),"position_code",entity.getPositionCode());
            ew.eq(!StringUtils.isEmpty(entity.getPromotionInfoId()),"promotion_info_id",entity.getPromotionInfoId());
            ew.eq(!StringUtils.isEmpty(entity.getStatus()),"status",entity.getStatus());
            ew.eq(!StringUtils.isEmpty(entity.getRemarks()),"remarks",entity.getRemarks());
            ew.eq(!StringUtils.isEmpty(entity.getDeleteFlag()),"delete_flag",entity.getDeleteFlag());
            ew.eq(entity.getCreateTime()!=null,"create_time",entity.getCreateTime());
            ew.eq(entity.getModifyTime()!=null,"modify_time",entity.getModifyTime());
            ew.eq(!StringUtils.isEmpty(entity.getCreateUser()),"create_user",entity.getCreateUser());
                return this.selectList(ew);
        }

        @Override
        public List<AdPromotionPositionAd> listAdPromotionPositionAdWithOrderBy(AdPromotionPositionAd entity,Collection<String> columns,Boolean isAsc){
        Wrapper<AdPromotionPositionAd> ew = new EntityWrapper<AdPromotionPositionAd>();
            ew.eq(!StringUtils.isEmpty(entity.getId()),"id",entity.getId());
            ew.eq(!StringUtils.isEmpty(entity.getUserId()),"user_id",entity.getUserId());
            ew.eq(!StringUtils.isEmpty(entity.getPositionCode()),"position_code",entity.getPositionCode());
            ew.eq(!StringUtils.isEmpty(entity.getPromotionInfoId()),"promotion_info_id",entity.getPromotionInfoId());
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
        public AdPromotionPositionAd getAdPromotionPositionAdByCondition(AdPromotionPositionAd entity){
              Wrapper<AdPromotionPositionAd> ew = new EntityWrapper<AdPromotionPositionAd>();
                ew.eq(!StringUtils.isEmpty(entity.getId()),"id",entity.getId());
                ew.eq(!StringUtils.isEmpty(entity.getUserId()),"user_id",entity.getUserId());
            ew.eq(!StringUtils.isEmpty(entity.getPositionCode()),"position_code",entity.getPositionCode());
                ew.eq(!StringUtils.isEmpty(entity.getPromotionInfoId()),"promotion_info_id",entity.getPromotionInfoId());
                ew.eq(!StringUtils.isEmpty(entity.getStatus()),"status",entity.getStatus());
                ew.eq(!StringUtils.isEmpty(entity.getRemarks()),"remarks",entity.getRemarks());
                ew.eq(!StringUtils.isEmpty(entity.getDeleteFlag()),"delete_flag",entity.getDeleteFlag());
                ew.eq(entity.getCreateTime()!=null,"create_time",entity.getCreateTime());
                ew.eq(entity.getModifyTime()!=null,"modify_time",entity.getModifyTime());
                ew.eq(!StringUtils.isEmpty(entity.getCreateUser()),"create_user",entity.getCreateUser());
             return this.selectOne(ew);
        }
}
