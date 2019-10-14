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
 * 流量主推广日志
 * </p>
 *
 * @author lq
 * @since 2019-09-24
 */
@ApiModel(value ="流量主推广日志",description ="流量主推广日志")
@TableName("ad_promotion_log")
public class AdPromotionLog extends Model<AdPromotionLog> {

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
     * 推广方式
网站/app/qq群/微信群/大V网红
     */
    @ApiModelProperty(value = "推广方式网站/app/qq群/微信群/大V网红",name="promotionType")
    @TableField("promotion_type")
    private String promotionType;
    /**
     * 计费模式CPM/CPC/CPA/CPS
     */
    @ApiModelProperty(value = "计费模式CPM/CPC/CPA/CPS",name="chargingMode")
    @TableField("charging_mode")
    private String chargingMode;
    /**
     * 接口类型1.获取广告 2.点击广告
     */
    @ApiModelProperty(value = "接口类型1.获取广告 2.点击广告",name="interfaceType")
    @TableField("interface_type")
    private String interfaceType;
    /**
     * ip地址
     */
    @ApiModelProperty(value = "ip地址",name="ipAddress")
    @TableField("ip_address")
    private String ipAddress;
    /**
     * mac地址
     */
    @ApiModelProperty(value = "mac地址",name="macAddress")
    @TableField("mac_address")
    private String macAddress;
    /**
     * 计算机域名
     */
    @ApiModelProperty(value = "计算机域名",name="dnsAddress")
    @TableField("dns_address")
    private String dnsAddress;
    /**
     * UserAgent
     */
    @ApiModelProperty(value = "UserAgent",name="userAgent")
    @TableField("user_agent")
    private String userAgent;
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

    public String getInterfaceType() {
        return interfaceType;
    }

    public void setInterfaceType(String interfaceType) {
        this.interfaceType = interfaceType;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getMacAddress() {
        return macAddress;
    }

    public void setMacAddress(String macAddress) {
        this.macAddress = macAddress;
    }

    public String getDnsAddress() {
        return dnsAddress;
    }

    public void setDnsAddress(String dnsAddress) {
        this.dnsAddress = dnsAddress;
    }

    public String getUserAgent() {
        return userAgent;
    }

    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
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
        return "AdPromotionLog{" +
                "id='" + id + '\'' +
                ", userId='" + userId + '\'' +
                ", positionCode='" + positionCode + '\'' +
                ", promotionType='" + promotionType + '\'' +
                ", chargingMode='" + chargingMode + '\'' +
                ", interfaceType='" + interfaceType + '\'' +
                ", ipAddress='" + ipAddress + '\'' +
                ", macAddress='" + macAddress + '\'' +
                ", dnsAddress='" + dnsAddress + '\'' +
                ", userAgent='" + userAgent + '\'' +
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
