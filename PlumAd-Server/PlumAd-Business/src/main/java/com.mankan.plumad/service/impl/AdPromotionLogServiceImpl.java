package com.mankan.plumad.service.impl;

import com.mankan.plumad.model.AdPromotionLog;
import com.mankan.plumad.mapper.AdPromotionLogMapper;
import com.mankan.plumad.service.IAdPromotionLogService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.toolkit.StringUtils;
import java.util.List;
import java.util.Collection;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;

/**
 * <p>
 * 流量主推广日志 服务实现类
 * </p>
 *
 * @author lq
 * @since 2019-09-24
 */
@Service
public class AdPromotionLogServiceImpl extends ServiceImpl<AdPromotionLogMapper, AdPromotionLog> implements IAdPromotionLogService {

        @Override
        public List<AdPromotionLog> listAdPromotionLog(AdPromotionLog entity){
            Wrapper<AdPromotionLog> ew = new EntityWrapper<AdPromotionLog>();
            ew.eq(!StringUtils.isEmpty(entity.getId()),"id",entity.getId());
            ew.eq(!StringUtils.isEmpty(entity.getUserId()),"user_id",entity.getUserId());
            ew.eq(!StringUtils.isEmpty(entity.getPromotionPositionId()),"promotion_position_id",entity.getPromotionPositionId());
            ew.eq(!StringUtils.isEmpty(entity.getPromotionType()),"promotion_type",entity.getPromotionType());
            ew.eq(!StringUtils.isEmpty(entity.getChargingMode()),"charging_mode",entity.getChargingMode());
            ew.eq(!StringUtils.isEmpty(entity.getInterfaceType()),"interface_type",entity.getInterfaceType());
            ew.eq(!StringUtils.isEmpty(entity.getIpAddress()),"ip_address",entity.getIpAddress());
            ew.eq(!StringUtils.isEmpty(entity.getMacAddress()),"mac_address",entity.getMacAddress());
            ew.eq(!StringUtils.isEmpty(entity.getDnsAddress()),"dns_address",entity.getDnsAddress());
            ew.eq(!StringUtils.isEmpty(entity.getUserAgent()),"user_agent",entity.getUserAgent());
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
        public List<AdPromotionLog> listAdPromotionLogWithOrderBy(AdPromotionLog entity,Collection<String> columns,Boolean isAsc){
        Wrapper<AdPromotionLog> ew = new EntityWrapper<AdPromotionLog>();
            ew.eq(!StringUtils.isEmpty(entity.getId()),"id",entity.getId());
            ew.eq(!StringUtils.isEmpty(entity.getUserId()),"user_id",entity.getUserId());
            ew.eq(!StringUtils.isEmpty(entity.getPromotionPositionId()),"promotion_position_id",entity.getPromotionPositionId());
            ew.eq(!StringUtils.isEmpty(entity.getPromotionType()),"promotion_type",entity.getPromotionType());
            ew.eq(!StringUtils.isEmpty(entity.getChargingMode()),"charging_mode",entity.getChargingMode());
            ew.eq(!StringUtils.isEmpty(entity.getInterfaceType()),"interface_type",entity.getInterfaceType());
            ew.eq(!StringUtils.isEmpty(entity.getIpAddress()),"ip_address",entity.getIpAddress());
            ew.eq(!StringUtils.isEmpty(entity.getMacAddress()),"mac_address",entity.getMacAddress());
            ew.eq(!StringUtils.isEmpty(entity.getDnsAddress()),"dns_address",entity.getDnsAddress());
            ew.eq(!StringUtils.isEmpty(entity.getUserAgent()),"user_agent",entity.getUserAgent());
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
        public AdPromotionLog getAdPromotionLogByCondition(AdPromotionLog entity){
              Wrapper<AdPromotionLog> ew = new EntityWrapper<AdPromotionLog>();
                ew.eq(!StringUtils.isEmpty(entity.getId()),"id",entity.getId());
                ew.eq(!StringUtils.isEmpty(entity.getUserId()),"user_id",entity.getUserId());
                ew.eq(!StringUtils.isEmpty(entity.getPromotionPositionId()),"promotion_position_id",entity.getPromotionPositionId());
                ew.eq(!StringUtils.isEmpty(entity.getPromotionType()),"promotion_type",entity.getPromotionType());
                ew.eq(!StringUtils.isEmpty(entity.getChargingMode()),"charging_mode",entity.getChargingMode());
                ew.eq(!StringUtils.isEmpty(entity.getInterfaceType()),"interface_type",entity.getInterfaceType());
                ew.eq(!StringUtils.isEmpty(entity.getIpAddress()),"ip_address",entity.getIpAddress());
                ew.eq(!StringUtils.isEmpty(entity.getMacAddress()),"mac_address",entity.getMacAddress());
                ew.eq(!StringUtils.isEmpty(entity.getDnsAddress()),"dns_address",entity.getDnsAddress());
                ew.eq(!StringUtils.isEmpty(entity.getUserAgent()),"user_agent",entity.getUserAgent());
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
