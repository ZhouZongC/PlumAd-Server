package com.mankan.plumad.service;

import java.util.List;
import com.mankan.plumad.model.UserRecharge;
import com.baomidou.mybatisplus.service.IService;
import java.util.List;
import java.util.Collection;

/**
 * <p>
 * 用户充值记录表 服务类
 * </p>
 *
 * @author lq
 * @since 2019-09-24
 */
public interface IUserRechargeService extends IService<UserRecharge> {

        /**
         * 获取用户充值记录表列表
         * @param entity
         * @return
         */
        List<UserRecharge> listUserRecharge(UserRecharge entity);


        /**
         * 获取用户充值记录表列表 按排序
         * @param entity
         * @return
         */
        List<UserRecharge> listUserRechargeWithOrderBy(UserRecharge entity, Collection<String> columns, Boolean isAsc);


        /**
         * 获取用户充值记录表数据
         * @param entity
         * @return
         */
        UserRecharge getUserRechargeByCondition(UserRecharge entity);
}
