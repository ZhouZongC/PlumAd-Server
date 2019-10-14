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
 * 流量主推广广告位对应广告
 * </p>
 *
 * @author lq
 * @since 2019-09-24
 */
@ApiModel(value ="流量主推广广告位对应广告",description ="流量主推广广告位对应广告")
@TableName("ad_promotion_position_ad")
public class AdPromotionPositionAd extends Model<AdPromotionPositionAd> {

    private static final long serialVersionUID = 1L;

    private String id;
    /**
     * 用户id
     */
    @ApiModelProperty(value = "用户id",name="userId")
    @TableField("user_id")
    private String userId;
    /**
     * 广告位编码
     */
    @ApiModelProperty(value = "广告位编码",name="positionCode")
    @TableField("position_code")
    private String positionCode;
    /**
     * 广告信息
     */
    @ApiModelProperty(value = "广告信息",name="promotionInfoId")
    @TableField("promotion_info_id")
    private String promotionInfoId;
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

    public String getPositionCode() {
        return positionCode;
    }

    public void setPositionCode(String positionCode) {
        this.positionCode = positionCode;
    }

    public String getPromotionInfoId() {
        return promotionInfoId;
    }

    public void setPromotionInfoId(String promotionInfoId) {
        this.promotionInfoId = promotionInfoId;
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
        return "AdPromotionPositionAd{" +
                "id='" + id + '\'' +
                ", userId='" + userId + '\'' +
                ", positionCode='" + positionCode + '\'' +
                ", promotionInfoId='" + promotionInfoId + '\'' +
                ", status='" + status + '\'' +
                ", remarks='" + remarks + '\'' +
                ", deleteFlag='" + deleteFlag + '\'' +
                ", createTime=" + createTime +
                ", modifyTime=" + modifyTime +
                ", createUser='" + createUser + '\'' +
                '}';
    }
}
