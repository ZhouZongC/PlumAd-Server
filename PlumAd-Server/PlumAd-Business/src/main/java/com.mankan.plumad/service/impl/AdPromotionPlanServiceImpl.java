package com.mankan.plumad.service.impl;

import com.mankan.plumad.model.AdPromotionPlan;
import com.mankan.plumad.mapper.AdPromotionPlanMapper;
import com.mankan.plumad.service.IAdPromotionPlanService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.toolkit.StringUtils;
import java.util.List;
import java.util.Collection;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;

/**
 * <p>
 * 广告推广计划 服务实现类
 * </p>
 *
 * @author lq
 * @since 2019-09-24
 */
@Service
public class AdPromotionPlanServiceImpl extends ServiceImpl<AdPromotionPlanMapper, AdPromotionPlan> implements IAdPromotionPlanService {

        @Override
        public List<AdPromotionPlan> listAdPromotionPlan(AdPromotionPlan entity){
            Wrapper<AdPromotionPlan> ew = new EntityWrapper<AdPromotionPlan>();
            ew.eq(!StringUtils.isEmpty(entity.getId()),"id",entity.getId());
            ew.eq(!StringUtils.isEmpty(entity.getUserId()),"user_id",entity.getUserId());
            ew.eq(!StringUtils.isEmpty(entity.getPlanName()),"plan_name",entity.getPlanName());
            ew.eq(!StringUtils.isEmpty(entity.getPlanCode()),"plan_code",entity.getPlanCode());
            ew.eq(!StringUtils.isEmpty(entity.getChargingMode()),"charging_mode",entity.getChargingMode());
            ew.eq(!StringUtils.isEmpty(entity.getAuditMode()),"audit_mode",entity.getAuditMode());
            ew.eq(!StringUtils.isEmpty(entity.getDevicesType()),"devices_type",entity.getDevicesType());
            ew.eq(!StringUtils.isEmpty(entity.getSettlementType()),"settlement_type",entity.getSettlementType());
            ew.eq(!StringUtils.isEmpty(entity.getSettlementCategory()),"settlement_category",entity.getSettlementCategory());
            ew.eq(!StringUtils.isEmpty(entity.getChannelParam()),"channel_param",entity.getChannelParam());
            ew.eq(!StringUtils.isEmpty(entity.getChannelCallback()),"channel_callback",entity.getChannelCallback());
            ew.eq(!StringUtils.isEmpty(entity.getChannelCookieValidity()),"channel_cookie_validity",entity.getChannelCookieValidity());
            ew.eq(!StringUtils.isEmpty(entity.getChannelShareUrl()),"channel_share_url",entity.getChannelShareUrl());
            ew.eq(entity.getCommissionRate()!=null,"commission_rate",entity.getCommissionRate());
            ew.eq(entity.getUnitPrice()!=null,"unit_price",entity.getUnitPrice());
            ew.eq(entity.getLimitAmount()!=null,"limit_amount",entity.getLimitAmount());
            ew.eq(!StringUtils.isEmpty(entity.getPriceRemarks()),"price_remarks",entity.getPriceRemarks());
            ew.eq(!StringUtils.isEmpty(entity.getEndType()),"end_type",entity.getEndType());
            ew.eq(entity.getEndDate()!=null,"end_date",entity.getEndDate());
            ew.eq(!StringUtils.isEmpty(entity.getLogo()),"logo",entity.getLogo());
            ew.eq(!StringUtils.isEmpty(entity.getPromotionRemarks()),"promotion_remarks",entity.getPromotionRemarks());
            ew.eq(!StringUtils.isEmpty(entity.getPromotionArea()),"promotion_area",entity.getPromotionArea());
            ew.eq(!StringUtils.isEmpty(entity.getWebType()),"web_type",entity.getWebType());
            ew.eq(entity.getPeriodWeek()!=null,"period_week",entity.getPeriodWeek());
            ew.eq(entity.getPeriodDay()!=null,"period_day",entity.getPeriodDay());
            ew.eq(!StringUtils.isEmpty(entity.getStatus()),"status",entity.getStatus());
            ew.eq(!StringUtils.isEmpty(entity.getRemarks()),"remarks",entity.getRemarks());
            ew.eq(!StringUtils.isEmpty(entity.getDeleteFlag()),"delete_flag",entity.getDeleteFlag());
            ew.eq(entity.getCreateTime()!=null,"create_time",entity.getCreateTime());
            ew.eq(entity.getModifyTime()!=null,"modify_time",entity.getModifyTime());
            ew.eq(!StringUtils.isEmpty(entity.getCreateUser()),"create_user",entity.getCreateUser());
                return this.selectList(ew);
        }

        @Override
        public List<AdPromotionPlan> listAdPromotionPlanWithOrderBy(AdPromotionPlan entity,Collection<String> columns,Boolean isAsc){
        Wrapper<AdPromotionPlan> ew = new EntityWrapper<AdPromotionPlan>();
            ew.eq(!StringUtils.isEmpty(entity.getId()),"id",entity.getId());
            ew.eq(!StringUtils.isEmpty(entity.getUserId()),"user_id",entity.getUserId());
            ew.eq(!StringUtils.isEmpty(entity.getPlanName()),"plan_name",entity.getPlanName());
            ew.eq(!StringUtils.isEmpty(entity.getPlanCode()),"plan_code",entity.getPlanCode());
            ew.eq(!StringUtils.isEmpty(entity.getChargingMode()),"charging_mode",entity.getChargingMode());
            ew.eq(!StringUtils.isEmpty(entity.getAuditMode()),"audit_mode",entity.getAuditMode());
            ew.eq(!StringUtils.isEmpty(entity.getDevicesType()),"devices_type",entity.getDevicesType());
            ew.eq(!StringUtils.isEmpty(entity.getSettlementType()),"settlement_type",entity.getSettlementType());
            ew.eq(!StringUtils.isEmpty(entity.getSettlementCategory()),"settlement_category",entity.getSettlementCategory());
            ew.eq(!StringUtils.isEmpty(entity.getChannelParam()),"channel_param",entity.getChannelParam());
            ew.eq(!StringUtils.isEmpty(entity.getChannelCallback()),"channel_callback",entity.getChannelCallback());
            ew.eq(!StringUtils.isEmpty(entity.getChannelCookieValidity()),"channel_cookie_validity",entity.getChannelCookieValidity());
            ew.eq(!StringUtils.isEmpty(entity.getChannelShareUrl()),"channel_share_url",entity.getChannelShareUrl());
            ew.eq(entity.getCommissionRate()!=null,"commission_rate",entity.getCommissionRate());
            ew.eq(entity.getUnitPrice()!=null,"unit_price",entity.getUnitPrice());
            ew.eq(entity.getLimitAmount()!=null,"limit_amount",entity.getLimitAmount());
            ew.eq(!StringUtils.isEmpty(entity.getPriceRemarks()),"price_remarks",entity.getPriceRemarks());
            ew.eq(!StringUtils.isEmpty(entity.getEndType()),"end_type",entity.getEndType());
            ew.eq(entity.getEndDate()!=null,"end_date",entity.getEndDate());
            ew.eq(!StringUtils.isEmpty(entity.getLogo()),"logo",entity.getLogo());
            ew.eq(!StringUtils.isEmpty(entity.getPromotionRemarks()),"promotion_remarks",entity.getPromotionRemarks());
            ew.eq(!StringUtils.isEmpty(entity.getPromotionArea()),"promotion_area",entity.getPromotionArea());
            ew.eq(!StringUtils.isEmpty(entity.getWebType()),"web_type",entity.getWebType());
            ew.eq(entity.getPeriodWeek()!=null,"period_week",entity.getPeriodWeek());
            ew.eq(entity.getPeriodDay()!=null,"period_day",entity.getPeriodDay());
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
        public AdPromotionPlan getAdPromotionPlanByCondition(AdPromotionPlan entity){
              Wrapper<AdPromotionPlan> ew = new EntityWrapper<AdPromotionPlan>();
                ew.eq(!StringUtils.isEmpty(entity.getId()),"id",entity.getId());
                ew.eq(!StringUtils.isEmpty(entity.getUserId()),"user_id",entity.getUserId());
                ew.eq(!StringUtils.isEmpty(entity.getPlanName()),"plan_name",entity.getPlanName());
                ew.eq(!StringUtils.isEmpty(entity.getPlanCode()),"plan_code",entity.getPlanCode());
                ew.eq(!StringUtils.isEmpty(entity.getChargingMode()),"charging_mode",entity.getChargingMode());
                ew.eq(!StringUtils.isEmpty(entity.getAuditMode()),"audit_mode",entity.getAuditMode());
                ew.eq(!StringUtils.isEmpty(entity.getDevicesType()),"devices_type",entity.getDevicesType());
                ew.eq(!StringUtils.isEmpty(entity.getSettlementType()),"settlement_type",entity.getSettlementType());
                ew.eq(!StringUtils.isEmpty(entity.getSettlementCategory()),"settlement_category",entity.getSettlementCategory());
                ew.eq(!StringUtils.isEmpty(entity.getChannelParam()),"channel_param",entity.getChannelParam());
                ew.eq(!StringUtils.isEmpty(entity.getChannelCallback()),"channel_callback",entity.getChannelCallback());
                ew.eq(!StringUtils.isEmpty(entity.getChannelCookieValidity()),"channel_cookie_validity",entity.getChannelCookieValidity());
                ew.eq(!StringUtils.isEmpty(entity.getChannelShareUrl()),"channel_share_url",entity.getChannelShareUrl());
                ew.eq(entity.getCommissionRate()!=null,"commission_rate",entity.getCommissionRate());
                ew.eq(entity.getUnitPrice()!=null,"unit_price",entity.getUnitPrice());
                ew.eq(entity.getLimitAmount()!=null,"limit_amount",entity.getLimitAmount());
                ew.eq(!StringUtils.isEmpty(entity.getPriceRemarks()),"price_remarks",entity.getPriceRemarks());
                ew.eq(!StringUtils.isEmpty(entity.getEndType()),"end_type",entity.getEndType());
                ew.eq(entity.getEndDate()!=null,"end_date",entity.getEndDate());
                ew.eq(!StringUtils.isEmpty(entity.getLogo()),"logo",entity.getLogo());
                ew.eq(!StringUtils.isEmpty(entity.getPromotionRemarks()),"promotion_remarks",entity.getPromotionRemarks());
                ew.eq(!StringUtils.isEmpty(entity.getPromotionArea()),"promotion_area",entity.getPromotionArea());
                ew.eq(!StringUtils.isEmpty(entity.getWebType()),"web_type",entity.getWebType());
                ew.eq(entity.getPeriodWeek()!=null,"period_week",entity.getPeriodWeek());
                ew.eq(entity.getPeriodDay()!=null,"period_day",entity.getPeriodDay());
                ew.eq(!StringUtils.isEmpty(entity.getStatus()),"status",entity.getStatus());
                ew.eq(!StringUtils.isEmpty(entity.getRemarks()),"remarks",entity.getRemarks());
                ew.eq(!StringUtils.isEmpty(entity.getDeleteFlag()),"delete_flag",entity.getDeleteFlag());
                ew.eq(entity.getCreateTime()!=null,"create_time",entity.getCreateTime());
                ew.eq(entity.getModifyTime()!=null,"modify_time",entity.getModifyTime());
                ew.eq(!StringUtils.isEmpty(entity.getCreateUser()),"create_user",entity.getCreateUser());
             return this.selectOne(ew);
        }
}
