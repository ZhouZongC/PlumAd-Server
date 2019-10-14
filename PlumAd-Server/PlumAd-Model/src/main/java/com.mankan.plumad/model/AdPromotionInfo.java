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
 * 广告推广信息
 * </p>
 *
 * @author lq
 * @since 2019-09-24
 */
@ApiModel(value ="广告推广信息",description ="广告推广信息")
@TableName("ad_promotion_info")
public class AdPromotionInfo extends Model<AdPromotionInfo> {

    private static final long serialVersionUID = 1L;

    private String id;
    /**
     * 用户id
     */
    @ApiModelProperty(value = "用户id",name="userId")
    @TableField("user_id")
    private String userId;
    /**
     * 推广计划id
     */
    @ApiModelProperty(value = "推广计划id",name="planCode")
    @TableField("plan_code")
    private String planCode;
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
     * 图片类型
     */
    @ApiModelProperty(value = "图片类型",name="picType")
    @TableField("pic_type")
    private String picType;
    /**
     * 图片地址
     */
    @ApiModelProperty(value = "图片地址",name="picUrl")
    @TableField("pic_url")
    private String picUrl;
    /**
     * 广告地址
     */
    @ApiModelProperty(value = "广告地址",name="adUrl")
    @TableField("ad_url")
    private String adUrl;
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

    public String getPlanCode() {
        return planCode;
    }

    public void setPlanCode(String planCode) {
        this.planCode = planCode;
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

    public String getPicType() {
        return picType;
    }

    public void setPicType(String picType) {
        this.picType = picType;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public String getAdUrl() {
        return adUrl;
    }

    public void setAdUrl(String adUrl) {
        this.adUrl = adUrl;
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
        return "AdPromotionInfo{" +
                "id='" + id + '\'' +
                ", userId='" + userId + '\'' +
                ", planCode='" + planCode + '\'' +
                ", adType='" + adType + '\'' +
                ", adSizes='" + adSizes + '\'' +
                ", picType='" + picType + '\'' +
                ", picUrl='" + picUrl + '\'' +
                ", adUrl='" + adUrl + '\'' +
                ", status='" + status + '\'' +
                ", remarks='" + remarks + '\'' +
                ", deleteFlag='" + deleteFlag + '\'' +
                ", createTime=" + createTime +
                ", modifyTime=" + modifyTime +
                ", createUser='" + createUser + '\'' +
                '}';
    }
}
