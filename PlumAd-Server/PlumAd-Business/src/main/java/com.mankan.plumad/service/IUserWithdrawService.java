package com.mankan.plumad.service;

import java.util.List;
import com.mankan.plumad.model.UserWithdraw;
import com.baomidou.mybatisplus.service.IService;
import java.util.List;
import java.util.Collection;

/**
 * <p>
 * 用户分润提现表 服务类
 * </p>
 *
 * @author lq
 * @since 2019-09-24
 */
public interface IUserWithdrawService extends IService<UserWithdraw> {

        /**
         * 获取用户分润提现表列表
         * @param entity
         * @return
         */
        List<UserWithdraw> listUserWithdraw(UserWithdraw entity);


        /**
         * 获取用户分润提现表列表 按排序
         * @param entity
         * @return
         */
        List<UserWithdraw> listUserWithdrawWithOrderBy(UserWithdraw entity, Collection<String> columns, Boolean isAsc);


        /**
         * 获取用户分润提现表数据
         * @param entity
         * @return
         */
        UserWithdraw getUserWithdrawByCondition(UserWithdraw entity);
}
