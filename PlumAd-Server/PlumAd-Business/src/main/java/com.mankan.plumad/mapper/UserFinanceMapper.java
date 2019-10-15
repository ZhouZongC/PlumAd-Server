package com.mankan.plumad.mapper;

import com.mankan.plumad.model.UserFinance;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;

/**
 * <p>
 * 用户财务表 Mapper 接口
 * </p>
 *
 * @author lq
 * @since 2019-09-24
 */
@Mapper
public interface UserFinanceMapper extends BaseMapper<UserFinance> {

    Boolean updateUserFinanceForS001(@Param("userId") String userId, @Param("totalAmount") BigDecimal totalAmount);

    Boolean updateUserFinanceForE001(@Param("userId") String userId, @Param("totalAmount") BigDecimal totalAmount);

    Boolean updateUserFinanceForRecharge(@Param("userId") String userId, @Param("totalAmount") BigDecimal totalAmount);

    Boolean updateUserFinanceForConsume(@Param("userId") String userId, @Param("totalAmount") BigDecimal totalAmount);
}
