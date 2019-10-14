package com.mankan.plumad.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.mankan.plumad.model.AddressCode;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 地址字典表 Mapper 接口
 * </p>
 *
 * @author lq
 * @since 2018-09-17
 */
@Mapper
public interface AddressCodeMapper extends BaseMapper<AddressCode> {

    String getAddressCodeByName(@Param("name") String name);
}
