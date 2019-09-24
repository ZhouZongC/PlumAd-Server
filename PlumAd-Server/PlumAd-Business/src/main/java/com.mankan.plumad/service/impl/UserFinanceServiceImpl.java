package com.mankan.plumad.service.impl;

import com.mankan.plumad.model.UserFinance;
import com.mankan.plumad.mapper.UserFinanceMapper;
import com.mankan.plumad.service.IUserFinanceService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.toolkit.StringUtils;
import java.util.List;
import java.util.Collection;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;

/**
 * <p>
 * 用户财务表 服务实现类
 * </p>
 *
 * @author lq
 * @since 2019-09-24
 */
@Service
public class UserFinanceServiceImpl extends ServiceImpl<UserFinanceMapper, UserFinance> implements IUserFinanceService {

        @Override
        public List<UserFinance> listUserFinance(UserFinance entity){
            Wrapper<UserFinance> ew = new EntityWrapper<UserFinance>();
            ew.eq(!StringUtils.isEmpty(entity.getId()),"id",entity.getId());
            ew.eq(!StringUtils.isEmpty(entity.getUserId()),"user_id",entity.getUserId());
            ew.eq(entity.getRechargeAmount()!=null,"recharge_amount",entity.getRechargeAmount());
            ew.eq(entity.getWithdrawAmount()!=null,"withdraw_amount",entity.getWithdrawAmount());
            ew.eq(entity.getTotalRechargeAmount()!=null,"total_recharge_amount",entity.getTotalRechargeAmount());
            ew.eq(entity.getTotalWithdrawAmount()!=null,"total_withdraw_amount",entity.getTotalWithdrawAmount());
            ew.eq(entity.getHandleAmount()!=null,"handle_amount",entity.getHandleAmount());
            ew.eq(entity.getFrozenAmount()!=null,"frozen_amount",entity.getFrozenAmount());
            ew.eq(!StringUtils.isEmpty(entity.getBankCode()),"bank_code",entity.getBankCode());
            ew.eq(!StringUtils.isEmpty(entity.getBankInfo()),"bank_info",entity.getBankInfo());
            ew.eq(!StringUtils.isEmpty(entity.getCardnum()),"cardnum",entity.getCardnum());
            ew.eq(!StringUtils.isEmpty(entity.getCardName()),"card_name",entity.getCardName());
            ew.eq(!StringUtils.isEmpty(entity.getVersion()),"version",entity.getVersion());
            ew.eq(!StringUtils.isEmpty(entity.getStatus()),"status",entity.getStatus());
            ew.eq(!StringUtils.isEmpty(entity.getRemarks()),"remarks",entity.getRemarks());
            ew.eq(!StringUtils.isEmpty(entity.getDeleteFlag()),"delete_flag",entity.getDeleteFlag());
            ew.eq(entity.getCreateTime()!=null,"create_time",entity.getCreateTime());
            ew.eq(entity.getModifyTime()!=null,"modify_time",entity.getModifyTime());
            ew.eq(!StringUtils.isEmpty(entity.getCreateUser()),"create_user",entity.getCreateUser());
                return this.selectList(ew);
        }

        @Override
        public List<UserFinance> listUserFinanceWithOrderBy(UserFinance entity,Collection<String> columns,Boolean isAsc){
        Wrapper<UserFinance> ew = new EntityWrapper<UserFinance>();
            ew.eq(!StringUtils.isEmpty(entity.getId()),"id",entity.getId());
            ew.eq(!StringUtils.isEmpty(entity.getUserId()),"user_id",entity.getUserId());
            ew.eq(entity.getRechargeAmount()!=null,"recharge_amount",entity.getRechargeAmount());
            ew.eq(entity.getWithdrawAmount()!=null,"withdraw_amount",entity.getWithdrawAmount());
            ew.eq(entity.getTotalRechargeAmount()!=null,"total_recharge_amount",entity.getTotalRechargeAmount());
            ew.eq(entity.getTotalWithdrawAmount()!=null,"total_withdraw_amount",entity.getTotalWithdrawAmount());
            ew.eq(entity.getHandleAmount()!=null,"handle_amount",entity.getHandleAmount());
            ew.eq(entity.getFrozenAmount()!=null,"frozen_amount",entity.getFrozenAmount());
            ew.eq(!StringUtils.isEmpty(entity.getBankCode()),"bank_code",entity.getBankCode());
            ew.eq(!StringUtils.isEmpty(entity.getBankInfo()),"bank_info",entity.getBankInfo());
            ew.eq(!StringUtils.isEmpty(entity.getCardnum()),"cardnum",entity.getCardnum());
            ew.eq(!StringUtils.isEmpty(entity.getCardName()),"card_name",entity.getCardName());
            ew.eq(!StringUtils.isEmpty(entity.getVersion()),"version",entity.getVersion());
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
        public UserFinance getUserFinanceByCondition(UserFinance entity){
              Wrapper<UserFinance> ew = new EntityWrapper<UserFinance>();
                ew.eq(!StringUtils.isEmpty(entity.getId()),"id",entity.getId());
                ew.eq(!StringUtils.isEmpty(entity.getUserId()),"user_id",entity.getUserId());
                ew.eq(entity.getRechargeAmount()!=null,"recharge_amount",entity.getRechargeAmount());
                ew.eq(entity.getWithdrawAmount()!=null,"withdraw_amount",entity.getWithdrawAmount());
                ew.eq(entity.getTotalRechargeAmount()!=null,"total_recharge_amount",entity.getTotalRechargeAmount());
                ew.eq(entity.getTotalWithdrawAmount()!=null,"total_withdraw_amount",entity.getTotalWithdrawAmount());
                ew.eq(entity.getHandleAmount()!=null,"handle_amount",entity.getHandleAmount());
                ew.eq(entity.getFrozenAmount()!=null,"frozen_amount",entity.getFrozenAmount());
                ew.eq(!StringUtils.isEmpty(entity.getBankCode()),"bank_code",entity.getBankCode());
                ew.eq(!StringUtils.isEmpty(entity.getBankInfo()),"bank_info",entity.getBankInfo());
                ew.eq(!StringUtils.isEmpty(entity.getCardnum()),"cardnum",entity.getCardnum());
                ew.eq(!StringUtils.isEmpty(entity.getCardName()),"card_name",entity.getCardName());
                ew.eq(!StringUtils.isEmpty(entity.getVersion()),"version",entity.getVersion());
                ew.eq(!StringUtils.isEmpty(entity.getStatus()),"status",entity.getStatus());
                ew.eq(!StringUtils.isEmpty(entity.getRemarks()),"remarks",entity.getRemarks());
                ew.eq(!StringUtils.isEmpty(entity.getDeleteFlag()),"delete_flag",entity.getDeleteFlag());
                ew.eq(entity.getCreateTime()!=null,"create_time",entity.getCreateTime());
                ew.eq(entity.getModifyTime()!=null,"modify_time",entity.getModifyTime());
                ew.eq(!StringUtils.isEmpty(entity.getCreateUser()),"create_user",entity.getCreateUser());
             return this.selectOne(ew);
        }
}
