package com.mankan.plumad.service;

import java.math.BigDecimal;
import java.util.List;
import com.mankan.plumad.model.UserFinance;
import com.baomidou.mybatisplus.service.IService;
import java.util.List;
import java.util.Collection;

/**
 * <p>
 * 用户财务表 服务类
 * </p>
 *
 * @author lq
 * @since 2019-09-24
 */
public interface IUserFinanceService extends IService<UserFinance> {

        /**
         * 获取用户财务表列表
         * @param entity
         * @return
         */
        List<UserFinance> listUserFinance(UserFinance entity);


        /**
         * 获取用户财务表列表 按排序
         * @param entity
         * @return
         */
        List<UserFinance> listUserFinanceWithOrderBy(UserFinance entity, Collection<String> columns, Boolean isAsc);


        /**
         * 获取用户财务表数据
         * @param entity
         * @return
         */
        UserFinance getUserFinanceByCondition(UserFinance entity);

        Boolean updateUserFinanceForS001(String userId, BigDecimal totalAmount);

        Boolean updateUserFinanceForE001(String userId, BigDecimal totalAmount);

        Boolean updateUserFinanceForRecharge(String userId, BigDecimal rechargeAmount);

        Boolean updateUserFinanceForConsume(String userId, BigDecimal limitAmount);
}
