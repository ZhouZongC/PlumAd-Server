package com.mankan.plumad.dto;

import com.mankan.plumad.model.AdPromotionInfo;

import java.io.Serializable;

/**
 * @author: youtiao
 * @create: 2019-10-14 09:35
 * @description:
 **/
public class AdShowDTO implements Serializable {

    /**
     * 图片地址
     */
    private AdPromotionDTO adPromotionDTO;
    /**
     * 广告类型
     */
    private AdPromotionInfo adPromotionInfo;

    public AdPromotionDTO getAdPromotionDTO() {
        return adPromotionDTO;
    }

    public void setAdPromotionDTO(AdPromotionDTO adPromotionDTO) {
        this.adPromotionDTO = adPromotionDTO;
    }

    public AdPromotionInfo getAdPromotionInfo() {
        return adPromotionInfo;
    }

    public void setAdPromotionInfo(AdPromotionInfo adPromotionInfo) {
        this.adPromotionInfo = adPromotionInfo;
    }
}
