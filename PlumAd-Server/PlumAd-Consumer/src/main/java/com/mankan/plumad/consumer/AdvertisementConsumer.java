package com.mankan.plumad.consumer;

import com.github.pagehelper.PageInfo;
import com.mankan.plumad.dto.AdPromotionInfoQuery;
import com.mankan.plumad.model.AdPromotionMode;
import com.mankan.plumad.model.AdPromotionPosition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * <p>
 * 图片文件表 api接口
 * </p>
 *
 * @author lq
 * @since 2019-09-26
 */
@Component
public class AdvertisementConsumer {
    private static Logger logger = LoggerFactory.getLogger(AdvertisementConsumer.class);

    @Autowired
    private AdPromotionPositionConsumer adPromotionPositionConsumer;
    @Autowired
    private AdPromotionModeConsumer adPromotionModeConsumer;
    @Autowired
    private AdPromotionInfoConsumer adPromotionInfoConsumer;
    /**
     * 获取广告信息列表
     * @param id
     * @return
     */
    public PageInfo listAdvertisement(String id){

        //获取广告位
        AdPromotionPosition adPromotionPosition = adPromotionPositionConsumer.getAdPromotionPosition(id);
        //获取流量主推广方式
        AdPromotionMode adPromotionMode = new AdPromotionMode();
        adPromotionMode.setPromotionCode(adPromotionPosition.getPromotionCode());
        adPromotionMode = adPromotionModeConsumer.getAdPromotionModeByCondition(adPromotionMode);

        AdPromotionInfoQuery adPromotionInfoQuery = new AdPromotionInfoQuery();
        adPromotionInfoQuery.setAdType(adPromotionPosition.getAdType());
        adPromotionInfoQuery.setSizesHigh(adPromotionPosition.getSizesHigh());
        adPromotionInfoQuery.setSizesWide(adPromotionPosition.getSizesWide());

        return adPromotionInfoConsumer.listAdPromotionInfo(adPromotionInfoQuery);
    }

}
