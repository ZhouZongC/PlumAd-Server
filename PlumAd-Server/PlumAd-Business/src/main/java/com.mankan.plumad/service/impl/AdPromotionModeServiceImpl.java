package com.mankan.plumad.service.impl;

import com.mankan.plumad.dto.AdPromotionQuery;
import com.mankan.plumad.model.AdPromotionInfo;
import com.mankan.plumad.model.AdPromotionMode;
import com.mankan.plumad.mapper.AdPromotionModeMapper;
import com.mankan.plumad.service.IAdPromotionModeService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.toolkit.StringUtils;
import java.util.List;
import java.util.Collection;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;

/**
 * <p>
 * 流量主推广方式 服务实现类
 * </p>
 *
 * @author lq
 * @since 2019-09-24
 */
@Service
public class AdPromotionModeServiceImpl extends ServiceImpl<AdPromotionModeMapper, AdPromotionMode> implements IAdPromotionModeService {

        @Override
        public List<AdPromotionMode> listAdPromotionMode(AdPromotionMode entity){
            Wrapper<AdPromotionMode> ew = new EntityWrapper<AdPromotionMode>();
            ew.eq(!StringUtils.isEmpty(entity.getId()),"id",entity.getId());
            ew.eq(!StringUtils.isEmpty(entity.getUserId()),"user_id",entity.getUserId());
            ew.eq(!StringUtils.isEmpty(entity.getPromotionCode()),"promotion_code",entity.getPromotionCode());
            ew.eq(!StringUtils.isEmpty(entity.getPromotionName()),"promotion_name",entity.getPromotionName());
            ew.eq(!StringUtils.isEmpty(entity.getPromotionType()),"promotion_type",entity.getPromotionType());
            ew.eq(!StringUtils.isEmpty(entity.getWebUrl()),"web_url",entity.getWebUrl());
            ew.eq(!StringUtils.isEmpty(entity.getWebName()),"web_name",entity.getWebName());
            ew.eq(!StringUtils.isEmpty(entity.getWebIcp()),"web_icp",entity.getWebIcp());
            ew.eq(!StringUtils.isEmpty(entity.getWebType()),"web_type",entity.getWebType());
            ew.eq(entity.getDailyVisits()!=null,"daily_visits",entity.getDailyVisits());
            ew.eq(!StringUtils.isEmpty(entity.getWebRemarks()),"web_remarks",entity.getWebRemarks());
            ew.eq(!StringUtils.isEmpty(entity.getAppName()),"app_name",entity.getAppName());
            ew.eq(!StringUtils.isEmpty(entity.getAppIndex()),"app_index",entity.getAppIndex());
            ew.eq(!StringUtils.isEmpty(entity.getAppDownUrl()),"app_down_url",entity.getAppDownUrl());
            ew.eq(!StringUtils.isEmpty(entity.getAppType()),"app_type",entity.getAppType());
            ew.eq(entity.getActivityVisits()!=null,"activity_visits",entity.getActivityVisits());
            ew.eq(!StringUtils.isEmpty(entity.getAppRemarks()),"app_remarks",entity.getAppRemarks());
            ew.eq(!StringUtils.isEmpty(entity.getGroupNumber()),"group_number",entity.getGroupNumber());
            ew.eq(!StringUtils.isEmpty(entity.getGroupName()),"group_name",entity.getGroupName());
            ew.eq(entity.getGroupNum()!=null,"group_num",entity.getGroupNum());
            ew.eq(!StringUtils.isEmpty(entity.getGroupType()),"group_type",entity.getGroupType());
            ew.eq(!StringUtils.isEmpty(entity.getDavSource()),"dav_source",entity.getDavSource());
            ew.eq(!StringUtils.isEmpty(entity.getDavOtherSource()),"dav_other_source",entity.getDavOtherSource());
            ew.eq(!StringUtils.isEmpty(entity.getDavAccount()),"dav_account",entity.getDavAccount());
            ew.eq(entity.getDavFollow()!=null,"dav_follow",entity.getDavFollow());
            ew.eq(!StringUtils.isEmpty(entity.getDavType()),"dav_type",entity.getDavType());
            ew.eq(!StringUtils.isEmpty(entity.getStatus()),"status",entity.getStatus());
            ew.eq(!StringUtils.isEmpty(entity.getRemarks()),"remarks",entity.getRemarks());
            ew.eq(!StringUtils.isEmpty(entity.getDeleteFlag()),"delete_flag",entity.getDeleteFlag());
            ew.eq(entity.getCreateTime()!=null,"create_time",entity.getCreateTime());
            ew.eq(entity.getModifyTime()!=null,"modify_time",entity.getModifyTime());
            ew.eq(!StringUtils.isEmpty(entity.getCreateUser()),"create_user",entity.getCreateUser());
                return this.selectList(ew);
        }

        @Override
        public List<AdPromotionMode> listAdPromotionModeWithOrderBy(AdPromotionMode entity,Collection<String> columns,Boolean isAsc){
        Wrapper<AdPromotionMode> ew = new EntityWrapper<AdPromotionMode>();
            ew.eq(!StringUtils.isEmpty(entity.getId()),"id",entity.getId());
            ew.eq(!StringUtils.isEmpty(entity.getUserId()),"user_id",entity.getUserId());
            ew.eq(!StringUtils.isEmpty(entity.getPromotionCode()),"promotion_code",entity.getPromotionCode());
            ew.eq(!StringUtils.isEmpty(entity.getPromotionName()),"promotion_name",entity.getPromotionName());
            ew.eq(!StringUtils.isEmpty(entity.getPromotionType()),"promotion_type",entity.getPromotionType());
            ew.eq(!StringUtils.isEmpty(entity.getWebUrl()),"web_url",entity.getWebUrl());
            ew.eq(!StringUtils.isEmpty(entity.getWebName()),"web_name",entity.getWebName());
            ew.eq(!StringUtils.isEmpty(entity.getWebIcp()),"web_icp",entity.getWebIcp());
            ew.eq(!StringUtils.isEmpty(entity.getWebType()),"web_type",entity.getWebType());
            ew.eq(entity.getDailyVisits()!=null,"daily_visits",entity.getDailyVisits());
            ew.eq(!StringUtils.isEmpty(entity.getWebRemarks()),"web_remarks",entity.getWebRemarks());
            ew.eq(!StringUtils.isEmpty(entity.getAppName()),"app_name",entity.getAppName());
            ew.eq(!StringUtils.isEmpty(entity.getAppIndex()),"app_index",entity.getAppIndex());
            ew.eq(!StringUtils.isEmpty(entity.getAppDownUrl()),"app_down_url",entity.getAppDownUrl());
            ew.eq(!StringUtils.isEmpty(entity.getAppType()),"app_type",entity.getAppType());
            ew.eq(entity.getActivityVisits()!=null,"activity_visits",entity.getActivityVisits());
            ew.eq(!StringUtils.isEmpty(entity.getAppRemarks()),"app_remarks",entity.getAppRemarks());
            ew.eq(!StringUtils.isEmpty(entity.getGroupNumber()),"group_number",entity.getGroupNumber());
            ew.eq(!StringUtils.isEmpty(entity.getGroupName()),"group_name",entity.getGroupName());
            ew.eq(entity.getGroupNum()!=null,"group_num",entity.getGroupNum());
            ew.eq(!StringUtils.isEmpty(entity.getGroupType()),"group_type",entity.getGroupType());
            ew.eq(!StringUtils.isEmpty(entity.getDavSource()),"dav_source",entity.getDavSource());
            ew.eq(!StringUtils.isEmpty(entity.getDavOtherSource()),"dav_other_source",entity.getDavOtherSource());
            ew.eq(!StringUtils.isEmpty(entity.getDavAccount()),"dav_account",entity.getDavAccount());
            ew.eq(entity.getDavFollow()!=null,"dav_follow",entity.getDavFollow());
            ew.eq(!StringUtils.isEmpty(entity.getDavType()),"dav_type",entity.getDavType());
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
        public AdPromotionMode getAdPromotionModeByCondition(AdPromotionMode entity){
              Wrapper<AdPromotionMode> ew = new EntityWrapper<AdPromotionMode>();
                ew.eq(!StringUtils.isEmpty(entity.getId()),"id",entity.getId());
                ew.eq(!StringUtils.isEmpty(entity.getUserId()),"user_id",entity.getUserId());
                ew.eq(!StringUtils.isEmpty(entity.getPromotionCode()),"promotion_code",entity.getPromotionCode());
                ew.eq(!StringUtils.isEmpty(entity.getPromotionName()),"promotion_name",entity.getPromotionName());
                ew.eq(!StringUtils.isEmpty(entity.getPromotionType()),"promotion_type",entity.getPromotionType());
                ew.eq(!StringUtils.isEmpty(entity.getWebUrl()),"web_url",entity.getWebUrl());
                ew.eq(!StringUtils.isEmpty(entity.getWebName()),"web_name",entity.getWebName());
                ew.eq(!StringUtils.isEmpty(entity.getWebIcp()),"web_icp",entity.getWebIcp());
                ew.eq(!StringUtils.isEmpty(entity.getWebType()),"web_type",entity.getWebType());
                ew.eq(entity.getDailyVisits()!=null,"daily_visits",entity.getDailyVisits());
                ew.eq(!StringUtils.isEmpty(entity.getWebRemarks()),"web_remarks",entity.getWebRemarks());
                ew.eq(!StringUtils.isEmpty(entity.getAppName()),"app_name",entity.getAppName());
                ew.eq(!StringUtils.isEmpty(entity.getAppIndex()),"app_index",entity.getAppIndex());
                ew.eq(!StringUtils.isEmpty(entity.getAppDownUrl()),"app_down_url",entity.getAppDownUrl());
                ew.eq(!StringUtils.isEmpty(entity.getAppType()),"app_type",entity.getAppType());
                ew.eq(entity.getActivityVisits()!=null,"activity_visits",entity.getActivityVisits());
                ew.eq(!StringUtils.isEmpty(entity.getAppRemarks()),"app_remarks",entity.getAppRemarks());
                ew.eq(!StringUtils.isEmpty(entity.getGroupNumber()),"group_number",entity.getGroupNumber());
                ew.eq(!StringUtils.isEmpty(entity.getGroupName()),"group_name",entity.getGroupName());
                ew.eq(entity.getGroupNum()!=null,"group_num",entity.getGroupNum());
                ew.eq(!StringUtils.isEmpty(entity.getGroupType()),"group_type",entity.getGroupType());
                ew.eq(!StringUtils.isEmpty(entity.getDavSource()),"dav_source",entity.getDavSource());
                ew.eq(!StringUtils.isEmpty(entity.getDavOtherSource()),"dav_other_source",entity.getDavOtherSource());
                ew.eq(!StringUtils.isEmpty(entity.getDavAccount()),"dav_account",entity.getDavAccount());
                ew.eq(entity.getDavFollow()!=null,"dav_follow",entity.getDavFollow());
                ew.eq(!StringUtils.isEmpty(entity.getDavType()),"dav_type",entity.getDavType());
                ew.eq(!StringUtils.isEmpty(entity.getStatus()),"status",entity.getStatus());
                ew.eq(!StringUtils.isEmpty(entity.getRemarks()),"remarks",entity.getRemarks());
                ew.eq(!StringUtils.isEmpty(entity.getDeleteFlag()),"delete_flag",entity.getDeleteFlag());
                ew.eq(entity.getCreateTime()!=null,"create_time",entity.getCreateTime());
                ew.eq(entity.getModifyTime()!=null,"modify_time",entity.getModifyTime());
                ew.eq(!StringUtils.isEmpty(entity.getCreateUser()),"create_user",entity.getCreateUser());
             return this.selectOne(ew);
        }

    @Override
    public List<AdPromotionInfo> listAd(AdPromotionQuery adPromotionQuery) {
        return this.baseMapper.listAd(adPromotionQuery);
    }
}
