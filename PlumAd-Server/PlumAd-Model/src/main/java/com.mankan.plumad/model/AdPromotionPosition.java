package com.mankan.plumad.model;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.annotations.TableLogic;
import com.baomidou.mybatisplus.annotations.Version;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
/**
 * <p>
 * 流量主推广广告位
 * </p>
 *
 * @author lq
 * @since 2019-09-24
 */
@ApiModel(value ="流量主推广广告位",description ="流量主推广广告位")
@TableName("ad_promotion_position")
public class AdPromotionPosition extends Model<AdPromotionPosition> {

    private static final long serialVersionUID = 1L;

    private String id;
    /**
     * 用户id
     */
    @ApiModelProperty(value = "用户id",name="userId")
    @TableField("user_id")
    private String userId;
    /**
     * 推广计划
     */
    @ApiModelProperty(value = "推广计划",name="promotionCode")
    @TableField("promotion_code")
    private String promotionCode;
    /**
     * 计费方式
     */
    @ApiModelProperty(value = "计费方式",name="chargingMode")
    @TableField("charging_mode")
    private String chargingMode;
    /**
     * 广告位名称
     */
    @ApiModelProperty(value = "广告位名称",name="positionName")
    @TableField("position_name")
    private String positionName;
    /**
     * 广告位编码
     */
    @ApiModelProperty(value = "广告位编码",name="positionCode")
    @TableField("position_code")
    private String positionCode;
    /**
     * 广告类型
     */
    @ApiModelProperty(value = "广告类型",name="adType")
    @TableField("ad_type")
    private String adType;
    /**
     * 广告尺寸
     */
    @ApiModelProperty(value = "广告尺寸",name="adSizes")
    @TableField("ad_sizes")
    private String adSizes;
    /**
     * 显示效果
     */
    @ApiModelProperty(value = "显示效果",name="adShowType")
    @TableField("ad_show_type")
    private String adShowType;
    /**
     * 广告过滤
     */
    @ApiModelProperty(value = "广告过滤",name="adFilter")
    @TableField("ad_filter")
    private String adFilter;
    /**
     * 广告推广短链接
     */
    @ApiModelProperty(value = "广告推广短链接",name="adPromotionUrl")
    @TableField("ad_promotion_url")
    private String adPromotionUrl;
    /**
     * 状态
     */
    @ApiModelProperty(value = "状态",name="status")
    private String status;
    /**
     * 说明
     */
    @ApiModelProperty(value = "说明",name="remarks")
    private String remarks;
    /**
     * 删除标记
     */
    @ApiModelProperty(value = "删除标记",name="deleteFlag")
    @TableField("delete_flag")
    @TableLogic
    private String deleteFlag;
    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间",name="createTime")
    @TableField("create_time")
    private Date createTime;
    /**
     * 修改时间
     */
    @ApiModelProperty(value = "修改时间",name="modifyTime")
    @TableField("modify_time")
    private Date modifyTime;
    /**
     * 创建人
     */
    @ApiModelProperty(value = "创建人",name="createUser")
    @TableField("create_user")
    private String createUser;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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

    public String getChargingMode() {
        return chargingMode;
    }

    public void setChargingMode(String chargingMode) {
        this.chargingMode = chargingMode;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    public String getPositionCode() {
        return positionCode;
    }

    public void setPositionCode(String positionCode) {
        this.positionCode = positionCode;
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

    public String getAdShowType() {
        return adShowType;
    }

    public void setAdShowType(String adShowType) {
        this.adShowType = adShowType;
    }

    public String getAdFilter() {
        return adFilter;
    }

    public void setAdFilter(String adFilter) {
        this.adFilter = adFilter;
    }

    public String getAdPromotionUrl() {
        return adPromotionUrl;
    }

    public void setAdPromotionUrl(String adPromotionUrl) {
        this.adPromotionUrl = adPromotionUrl;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(String deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "AdPromotionPosition{" +
                "id='" + id + '\'' +
                ", userId='" + userId + '\'' +
                ", promotionCode='" + promotionCode + '\'' +
                ", chargingMode='" + chargingMode + '\'' +
                ", positionName='" + positionName + '\'' +
                ", positionCode='" + positionCode + '\'' +
                ", adType='" + adType + '\'' +
                ", adSizes=" + adSizes +
                ", adShowType='" + adShowType + '\'' +
                ", adFilter='" + adFilter + '\'' +
                ", adPromotionUrl='" + adPromotionUrl + '\'' +
                ", status='" + status + '\'' +
                ", remarks='" + remarks + '\'' +
                ", deleteFlag='" + deleteFlag + '\'' +
                ", createTime=" + createTime +
                ", modifyTime=" + modifyTime +
                ", createUser='" + createUser + '\'' +
                '}';
    }
}
