package com.mankan.plumad.handle;

import com.mankan.plumad.consumer.AdPromotionLogConsumer;
import com.mankan.plumad.consumer.AdPromotionModeConsumer;
import com.mankan.plumad.consumer.AdPromotionPositionAdConsumer;
import com.mankan.plumad.consumer.AdPromotionPositionConsumer;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: youtiao
 * @create: 2019-10-10 10:22
 * @description:
 **/

@Component
public class AdRestHandle {

    @Autowired
    private AdPromotionLogConsumer adPromotionLogConsumer;

    @Autowired
    private AdPromotionPositionConsumer adPromotionPositionConsumer;

    @Autowired
    private AdPromotionPositionAdConsumer adPromotionPositionAdConsumer;

    @Autowired
    private AdPromotionModeConsumer adPromotionModeConsumer;

    /**
     * 获取推荐广告列表
     * @param positionCode
     * @return
     */
    public String listAd(String positionCode) {

        return null;
    }

    /**
     * 获取推荐广告（唯一）
     * @param positionCode
     * @return
     */
    public String getAd(String positionCode) {
        return null;
    }

    /**
     * 广告短链接跳转
     * @param shorturl
     * @return
     */
    public String translateAd(String shorturl) {
        return null;
    }


}
