package com.mankan.plumad.dto;

import java.io.Serializable;

/**
 * @author: youtiao
 * @create: 2019-10-14 10:47
 * @description:
 **/
public class AdPromotionQuery implements Serializable {

    /**
     * 计费方式
     */
    private String chargingMode;
    /**
     * 推广站点类型
     */
    private String type;
    /**
     * 广告类型
     */
    private String adType;
    /**
     * 广告尺寸
     */
    private String adSizes;
    /**
     * 星期
     */
    private String periodWeek;
    /**
     * 小时
     */
    private Integer periodDay;
    /**
     * 投放区域
     */
    private String promotionArea;

    public String getChargingMode() {
        return chargingMode;
    }

    public void setChargingMode(String chargingMode) {
        this.chargingMode = chargingMode;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAdType() {
        return adType;
    }

    public void setAdType(String adType) {
        this.adType = adType;
    }

    public String getAdSizes() {
        return adSizes;
    }

    public void setAdSizes(String adSizes) {
        this.adSizes = adSizes;
    }

    public String getPeriodWeek() {
        return periodWeek;
    }

    public void setPeriodWeek(String periodWeek) {
        this.periodWeek = periodWeek;
    }

    public Integer getPeriodDay() {
        return periodDay;
    }

    public void setPeriodDay(Integer periodDay) {
        this.periodDay = periodDay;
    }

    public String getPromotionArea() {
        return promotionArea;
    }

    public void setPromotionArea(String promotionArea) {
        this.promotionArea = promotionArea;
    }

    public AdPromotionQuery(String chargingMode, String type, String adType, String adSizes,
                            String periodWeek, Integer periodDay, String promotionArea) {
        this.chargingMode = chargingMode;
        this.type = type;
        this.adType = adType;
        this.adSizes = adSizes;
        this.periodWeek = periodWeek;
        this.periodDay = periodDay;
        this.promotionArea = promotionArea;
    }

}
