package com.mankan.plumad.vo;

import com.mankan.plumad.model.AdPromotionInfo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

@ApiModel(value ="广告推广信息和流量主推广广告位对应广告ID",description ="广告推广信息和流量主推广广告位对应广告ID")
public class AdPromotionInfoVO extends AdPromotionInfo implements Serializable {

    @ApiModelProperty(value = "adPromotionPositionAdId",name="adPromotionPositionAdId")
    private String adPromotionPositionAdId;
    @ApiModelProperty(value = "adPromotionPositionAdStatus",name="adPromotionPositionAdStatus")
    private String adPromotionPositionAdStatus;

    public String getAdPromotionPositionAdId() {
        return adPromotionPositionAdId;
    }

    public void setAdPromotionPositionAdId(String adPromotionPositionAdId) {
        this.adPromotionPositionAdId = adPromotionPositionAdId;
    }

    public String getAdPromotionPositionAdStatus() {
        return adPromotionPositionAdStatus;
    }

    public void setAdPromotionPositionAdStatus(String adPromotionPositionAdStatus) {
        this.adPromotionPositionAdStatus = adPromotionPositionAdStatus;
    }
}
