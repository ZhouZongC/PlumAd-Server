package com.mankan.plumad.mapper;

import com.mankan.plumad.dto.AdPromotionQuery;
import com.mankan.plumad.model.AdPromotionInfo;
import com.mankan.plumad.model.AdPromotionMode;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 * 流量主推广方式 Mapper 接口
 * </p>
 *
 * @author lq
 * @since 2019-09-24
 */
@Mapper
public interface AdPromotionModeMapper extends BaseMapper<AdPromotionMode> {

    List<AdPromotionInfo> listAd(AdPromotionQuery adPromotionQuery);

}
