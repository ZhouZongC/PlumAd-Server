package com.mankan.plumad.mapper;

import com.mankan.plumad.model.AdPromotionInfo;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 * 广告推广信息 Mapper 接口
 * </p>
 *
 * @author lq
 * @since 2019-09-24
 */
@Mapper
public interface AdPromotionInfoMapper extends BaseMapper<AdPromotionInfo> {

    /**
     * 根据广告位编码查询广告推广信息
     */
    List<AdPromotionInfo> listAdvertisingDisplay(String positionCode);
}
