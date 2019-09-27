package com.mankan.plumad.service.impl;

import com.mankan.plumad.model.UserRecharge;
import com.mankan.plumad.mapper.UserRechargeMapper;
import com.mankan.plumad.service.IUserRechargeService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.toolkit.StringUtils;
import java.util.List;
import java.util.Collection;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;

/**
 * <p>
 * 用户充值记录表 服务实现类
 * </p>
 *
 * @author lq
 * @since 2019-09-24
 */
@Service
public class UserRechargeServiceImpl extends ServiceImpl<UserRechargeMapper, UserRecharge> implements IUserRechargeService {

        @Override
        public List<UserRecharge> listUserRecharge(UserRecharge entity){
            Wrapper<UserRecharge> ew = new EntityWrapper<UserRecharge>();
            ew.eq(!StringUtils.isEmpty(entity.getId()),"id",entity.getId());
            ew.eq(!StringUtils.isEmpty(entity.getUserId()),"user_id",entity.getUserId());
            ew.eq(!StringUtils.isEmpty(entity.getIpAddress()),"ip_address",entity.getIpAddress());
            ew.eq(!StringUtils.isEmpty(entity.getOrderNum()),"order_num",entity.getOrderNum());
            ew.eq(entity.getRechargeAmount()!=null,"recharge_amount",entity.getRechargeAmount());
            ew.eq(!StringUtils.isEmpty(entity.getPayType()),"pay_type",entity.getPayType());
            ew.eq(entity.getRequestTime()!=null,"request_time",entity.getRequestTime());
            ew.eq(entity.getResponseTime()!=null,"response_time",entity.getResponseTime());
            ew.eq(entity.getNotifyTime()!=null,"notify_time",entity.getNotifyTime());
            ew.eq(!StringUtils.isEmpty(entity.getStatus()),"status",entity.getStatus());
            ew.eq(!StringUtils.isEmpty(entity.getRemarks()),"remarks",entity.getRemarks());
                return this.selectList(ew);
        }

        @Override
        public List<UserRecharge> listUserRechargeWithOrderBy(UserRecharge entity,Collection<String> columns,Boolean isAsc){
        Wrapper<UserRecharge> ew = new EntityWrapper<UserRecharge>();
            ew.eq(!StringUtils.isEmpty(entity.getId()),"id",entity.getId());
            ew.eq(!StringUtils.isEmpty(entity.getUserId()),"user_id",entity.getUserId());
            ew.eq(!StringUtils.isEmpty(entity.getIpAddress()),"ip_address",entity.getIpAddress());
            ew.eq(!StringUtils.isEmpty(entity.getOrderNum()),"order_num",entity.getOrderNum());
            ew.eq(entity.getRechargeAmount()!=null,"recharge_amount",entity.getRechargeAmount());
            ew.eq(!StringUtils.isEmpty(entity.getPayType()),"pay_type",entity.getPayType());
            ew.eq(entity.getRequestTime()!=null,"request_time",entity.getRequestTime());
            ew.eq(entity.getResponseTime()!=null,"response_time",entity.getResponseTime());
            ew.eq(entity.getNotifyTime()!=null,"notify_time",entity.getNotifyTime());
            ew.eq(!StringUtils.isEmpty(entity.getStatus()),"status",entity.getStatus());
            ew.eq(!StringUtils.isEmpty(entity.getRemarks()),"remarks",entity.getRemarks());
             ew.orderBy(true,columns,isAsc);
        return this.selectList(ew);
        }


        @Override
        public UserRecharge getUserRechargeByCondition(UserRecharge entity){
              Wrapper<UserRecharge> ew = new EntityWrapper<UserRecharge>();
                ew.eq(!StringUtils.isEmpty(entity.getId()),"id",entity.getId());
                ew.eq(!StringUtils.isEmpty(entity.getUserId()),"user_id",entity.getUserId());
                ew.eq(!StringUtils.isEmpty(entity.getIpAddress()),"ip_address",entity.getIpAddress());
                ew.eq(!StringUtils.isEmpty(entity.getOrderNum()),"order_num",entity.getOrderNum());
                ew.eq(entity.getRechargeAmount()!=null,"recharge_amount",entity.getRechargeAmount());
                ew.eq(!StringUtils.isEmpty(entity.getPayType()),"pay_type",entity.getPayType());
                ew.eq(entity.getRequestTime()!=null,"request_time",entity.getRequestTime());
                ew.eq(entity.getResponseTime()!=null,"response_time",entity.getResponseTime());
                ew.eq(entity.getNotifyTime()!=null,"notify_time",entity.getNotifyTime());
                ew.eq(!StringUtils.isEmpty(entity.getStatus()),"status",entity.getStatus());
                ew.eq(!StringUtils.isEmpty(entity.getRemarks()),"remarks",entity.getRemarks());
             return this.selectOne(ew);
        }
}
