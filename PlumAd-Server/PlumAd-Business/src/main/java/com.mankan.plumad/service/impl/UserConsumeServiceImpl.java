package com.mankan.plumad.service.impl;

import com.mankan.plumad.model.UserConsume;
import com.mankan.plumad.mapper.UserConsumeMapper;
import com.mankan.plumad.service.IUserConsumeService;
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
 * @since 2019-10-14
 */
@Service
public class UserConsumeServiceImpl extends ServiceImpl<UserConsumeMapper, UserConsume> implements IUserConsumeService {

        @Override
        public List<UserConsume> listUserConsume(UserConsume entity){
            Wrapper<UserConsume> ew = new EntityWrapper<UserConsume>();
            ew.eq(!StringUtils.isEmpty(entity.getId()),"id",entity.getId());
            ew.eq(!StringUtils.isEmpty(entity.getUserId()),"user_id",entity.getUserId());
            ew.eq(!StringUtils.isEmpty(entity.getPromotionLogId()),"promotion_log_id",entity.getPromotionLogId());
            ew.eq(entity.getLimitAmount()!=null,"limit_amount",entity.getLimitAmount());
            ew.eq(entity.getDayLimitAmount()!=null,"day_limit_amount",entity.getDayLimitAmount());
            ew.eq(entity.getTotalAmount()!=null,"total_amount",entity.getTotalAmount());
            ew.eq(entity.getRequestTime()!=null,"request_time",entity.getRequestTime());
            ew.eq(entity.getResponseTime()!=null,"response_time",entity.getResponseTime());
            ew.eq(entity.getNotifyTime()!=null,"notify_time",entity.getNotifyTime());
            ew.eq(!StringUtils.isEmpty(entity.getStatus()),"status",entity.getStatus());
            ew.eq(!StringUtils.isEmpty(entity.getRemarks()),"remarks",entity.getRemarks());
                return this.selectList(ew);
        }

        @Override
        public List<UserConsume> listUserConsumeWithOrderBy(UserConsume entity,Collection<String> columns,Boolean isAsc){
        Wrapper<UserConsume> ew = new EntityWrapper<UserConsume>();
            ew.eq(!StringUtils.isEmpty(entity.getId()),"id",entity.getId());
            ew.eq(!StringUtils.isEmpty(entity.getUserId()),"user_id",entity.getUserId());
            ew.eq(!StringUtils.isEmpty(entity.getPromotionLogId()),"promotion_log_id",entity.getPromotionLogId());
            ew.eq(entity.getLimitAmount()!=null,"limit_amount",entity.getLimitAmount());
            ew.eq(entity.getDayLimitAmount()!=null,"day_limit_amount",entity.getDayLimitAmount());
            ew.eq(entity.getTotalAmount()!=null,"total_amount",entity.getTotalAmount());
            ew.eq(entity.getRequestTime()!=null,"request_time",entity.getRequestTime());
            ew.eq(entity.getResponseTime()!=null,"response_time",entity.getResponseTime());
            ew.eq(entity.getNotifyTime()!=null,"notify_time",entity.getNotifyTime());
            ew.eq(!StringUtils.isEmpty(entity.getStatus()),"status",entity.getStatus());
            ew.eq(!StringUtils.isEmpty(entity.getRemarks()),"remarks",entity.getRemarks());
             ew.orderBy(true,columns,isAsc);
        return this.selectList(ew);
        }


        @Override
        public UserConsume getUserConsumeByCondition(UserConsume entity){
              Wrapper<UserConsume> ew = new EntityWrapper<UserConsume>();
                ew.eq(!StringUtils.isEmpty(entity.getId()),"id",entity.getId());
                ew.eq(!StringUtils.isEmpty(entity.getUserId()),"user_id",entity.getUserId());
                ew.eq(!StringUtils.isEmpty(entity.getPromotionLogId()),"promotion_log_id",entity.getPromotionLogId());
                ew.eq(entity.getLimitAmount()!=null,"limit_amount",entity.getLimitAmount());
                ew.eq(entity.getDayLimitAmount()!=null,"day_limit_amount",entity.getDayLimitAmount());
                ew.eq(entity.getTotalAmount()!=null,"total_amount",entity.getTotalAmount());
                ew.eq(entity.getRequestTime()!=null,"request_time",entity.getRequestTime());
                ew.eq(entity.getResponseTime()!=null,"response_time",entity.getResponseTime());
                ew.eq(entity.getNotifyTime()!=null,"notify_time",entity.getNotifyTime());
                ew.eq(!StringUtils.isEmpty(entity.getStatus()),"status",entity.getStatus());
                ew.eq(!StringUtils.isEmpty(entity.getRemarks()),"remarks",entity.getRemarks());
             return this.selectOne(ew);
        }
}
