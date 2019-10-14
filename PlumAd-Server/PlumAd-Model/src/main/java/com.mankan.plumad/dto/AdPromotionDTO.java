package com.mankan.plumad.dto;

import com.baomidou.mybatisplus.annotations.TableField;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author: youtiao
 * @create: 2019-10-14 09:35
 * @description:
 **/
public class AdPromotionDTO implements Serializable {

    private String userId;
    /**
     * 推广计划
     */
    private String promotionCode;
    /**
     * 推广计划
     */
    private String promotionType;
    /**
     * 计费方式
     */
    private String chargingMode;
    /**
     * 广告位编码
     */
    private String positionCode;
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
     * 广告过滤
     */
    private String adFilter;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPromotionCode() {
        return promotionCode;
    }

    public void setPromotionCode(String promotionCode) {
        this.promotionCode = promotionCode;
    }

    public String getPromotionType() {
        return promotionType;
    }

    public void setPromotionType(String promotionType) {
        this.promotionType = promotionType;
    }

    public String getChargingMode() {
        return chargingMode;
    }

    public void setChargingMode(String chargingMode) {
        this.chargingMode = chargingMode;
    }

    public String getPositionCode() {
        return positionCode;
    }

    public void setPositionCode(String positionCode) {
        this.positionCode = positionCode;
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

    public String getAdFilter() {
        return adFilter;
    }

    public void setAdFilter(String adFilter) {
        this.adFilter = adFilter;
    }

    @Override
    public String toString() {
        return "AdPromotionDTO{" +
                "userId='" + userId + '\'' +
                ", promotionCode='" + promotionCode + '\'' +
                ", promotionType='" + promotionType + '\'' +
                ", chargingMode='" + chargingMode + '\'' +
                ", positionCode='" + positionCode + '\'' +
                ", type='" + type + '\'' +
                ", adType='" + adType + '\'' +
                ", adSizes='" + adSizes + '\'' +
                ", adFilter='" + adFilter + '\'' +
                '}';
    }
}
