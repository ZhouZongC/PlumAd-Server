package com.mankan.plumad.dto;

import com.baomidou.mybatisplus.annotations.TableField;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author: youtiao
 * @create: 2019-10-14 09:35
 * @description:
 **/
public class AdShowVO implements Serializable {

    /**
     * 图片地址
     */
    private String picUrl;
    /**
     * 广告类型
     */
    private String adType;
    /**
     * 广告尺寸
     */
    private String adSizes;
    /**
     * 跳转短链接
     */
    private String shortUrl;

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
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

    public String getShortUrl() {
        return shortUrl;
    }

    public void setShortUrl(String shortUrl) {
        this.shortUrl = shortUrl;
    }
}
