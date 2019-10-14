package com.mankan.plumad.service;

import java.util.List;
import com.mankan.plumad.model.UserConsume;
import com.baomidou.mybatisplus.service.IService;
import java.util.List;
import java.util.Collection;

/**
 * <p>
 * 用户分润提现表 服务类
 * </p>
 *
 * @author lq
 * @since 2019-10-14
 */
public interface IUserConsumeService extends IService<UserConsume> {

        /**
         * 获取用户分润提现表列表
         * @param entity
         * @return
         */
        List<UserConsume> listUserConsume(UserConsume entity);


        /**
         * 获取用户分润提现表列表 按排序
         * @param entity
         * @return
         */
        List<UserConsume> listUserConsumeWithOrderBy(UserConsume entity, Collection<String> columns, Boolean isAsc);


        /**
         * 获取用户分润提现表数据
         * @param entity
         * @return
         */
        UserConsume getUserConsumeByCondition(UserConsume entity);
}
