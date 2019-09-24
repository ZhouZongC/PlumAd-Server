package com.mankan.plumad.service.impl;

import com.mankan.plumad.model.UserWithdraw;
import com.mankan.plumad.mapper.UserWithdrawMapper;
import com.mankan.plumad.service.IUserWithdrawService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.toolkit.StringUtils;
import java.util.List;
import java.util.Collection;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;

/**
 * <p>
 * 用户分润提现表 服务实现类
 * </p>
 *
 * @author lq
 * @since 2019-09-24
 */
@Service
public class UserWithdrawServiceImpl extends ServiceImpl<UserWithdrawMapper, UserWithdraw> implements IUserWithdrawService {

        @Override
        public List<UserWithdraw> listUserWithdraw(UserWithdraw entity){
            Wrapper<UserWithdraw> ew = new EntityWrapper<UserWithdraw>();
            ew.eq(!StringUtils.isEmpty(entity.getId()),"id",entity.getId());
            ew.eq(!StringUtils.isEmpty(entity.getUserId()),"user_id",entity.getUserId());
            ew.eq(!StringUtils.isEmpty(entity.getIpAddress()),"ip_address",entity.getIpAddress());
            ew.eq(!StringUtils.isEmpty(entity.getOrderNum()),"order_num",entity.getOrderNum());
            ew.eq(entity.getTotalAmount()!=null,"total_amount",entity.getTotalAmount());
            ew.eq(entity.getTaxation()!=null,"taxation",entity.getTaxation());
            ew.eq(entity.getServiceFee()!=null,"service_fee",entity.getServiceFee());
            ew.eq(entity.getWithdrawAmount()!=null,"withdraw_amount",entity.getWithdrawAmount());
            ew.eq(entity.getRequestTime()!=null,"request_time",entity.getRequestTime());
            ew.eq(entity.getResponseTime()!=null,"response_time",entity.getResponseTime());
            ew.eq(entity.getNotifyTime()!=null,"notify_time",entity.getNotifyTime());
            ew.eq(!StringUtils.isEmpty(entity.getStatus()),"status",entity.getStatus());
            ew.eq(!StringUtils.isEmpty(entity.getRemarks()),"remarks",entity.getRemarks());
                return this.selectList(ew);
        }

        @Override
        public List<UserWithdraw> listUserWithdrawWithOrderBy(UserWithdraw entity,Collection<String> columns,Boolean isAsc){
        Wrapper<UserWithdraw> ew = new EntityWrapper<UserWithdraw>();
            ew.eq(!StringUtils.isEmpty(entity.getId()),"id",entity.getId());
            ew.eq(!StringUtils.isEmpty(entity.getUserId()),"user_id",entity.getUserId());
            ew.eq(!StringUtils.isEmpty(entity.getIpAddress()),"ip_address",entity.getIpAddress());
            ew.eq(!StringUtils.isEmpty(entity.getOrderNum()),"order_num",entity.getOrderNum());
            ew.eq(entity.getTotalAmount()!=null,"total_amount",entity.getTotalAmount());
            ew.eq(entity.getTaxation()!=null,"taxation",entity.getTaxation());
            ew.eq(entity.getServiceFee()!=null,"service_fee",entity.getServiceFee());
            ew.eq(entity.getWithdrawAmount()!=null,"withdraw_amount",entity.getWithdrawAmount());
            ew.eq(entity.getRequestTime()!=null,"request_time",entity.getRequestTime());
            ew.eq(entity.getResponseTime()!=null,"response_time",entity.getResponseTime());
            ew.eq(entity.getNotifyTime()!=null,"notify_time",entity.getNotifyTime());
            ew.eq(!StringUtils.isEmpty(entity.getStatus()),"status",entity.getStatus());
            ew.eq(!StringUtils.isEmpty(entity.getRemarks()),"remarks",entity.getRemarks());
             ew.orderBy(true,columns,isAsc);
        return this.selectList(ew);
        }


        @Override
        public UserWithdraw getUserWithdrawByCondition(UserWithdraw entity){
              Wrapper<UserWithdraw> ew = new EntityWrapper<UserWithdraw>();
                ew.eq(!StringUtils.isEmpty(entity.getId()),"id",entity.getId());
                ew.eq(!StringUtils.isEmpty(entity.getUserId()),"user_id",entity.getUserId());
                ew.eq(!StringUtils.isEmpty(entity.getIpAddress()),"ip_address",entity.getIpAddress());
                ew.eq(!StringUtils.isEmpty(entity.getOrderNum()),"order_num",entity.getOrderNum());
                ew.eq(entity.getTotalAmount()!=null,"total_amount",entity.getTotalAmount());
                ew.eq(entity.getTaxation()!=null,"taxation",entity.getTaxation());
                ew.eq(entity.getServiceFee()!=null,"service_fee",entity.getServiceFee());
                ew.eq(entity.getWithdrawAmount()!=null,"withdraw_amount",entity.getWithdrawAmount());
                ew.eq(entity.getRequestTime()!=null,"request_time",entity.getRequestTime());
                ew.eq(entity.getResponseTime()!=null,"response_time",entity.getResponseTime());
                ew.eq(entity.getNotifyTime()!=null,"notify_time",entity.getNotifyTime());
                ew.eq(!StringUtils.isEmpty(entity.getStatus()),"status",entity.getStatus());
                ew.eq(!StringUtils.isEmpty(entity.getRemarks()),"remarks",entity.getRemarks());
             return this.selectOne(ew);
        }
}
