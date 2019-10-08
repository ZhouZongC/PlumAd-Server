package com.mankan.plumad.model;

import java.math.BigDecimal;
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
 * 广告推广计划
 * </p>
 *
 * @author lq
 * @since 2019-09-24
 */
@ApiModel(value ="广告推广计划",description ="广告推广计划")
@TableName("ad_promotion_plan")
public class AdPromotionPlan extends Model<AdPromotionPlan> {

    private static final long serialVersionUID = 1L;

    private String id;
    /**
     * 用户id
     */
    @ApiModelProperty(value = "用户id",name="userId")
    @TableField("user_id")
    private String userId;
    /**
     * 计划名称
     */
    @ApiModelProperty(value = "计划名称",name="planName")
    @TableField("plan_name")
    private String planName;
    /**
     * 计划编码
     */
    @ApiModelProperty(value = "计划编码",name="planCode")
    @TableField("plan_code")
    private String planCode;
    /**
     * 计费模式
CPM/CPC/CPA/CPS
     */
    @ApiModelProperty(value = "计费模式CPM/CPC/CPA/CPS",name="chargingMode")
    @TableField("charging_mode")
    private String chargingMode;
    /**
     * 网站审核方式
     */
    @ApiModelProperty(value = "网站审核方式",name="auditMode")
    @TableField("audit_mode")
    private String auditMode;
    /**
     * 投放设备
pc/wap/ios/android
     */
    @ApiModelProperty(value = "投放设备pc/wap/ios/android",name="devicesType")
    @TableField("devices_type")
    private String devicesType;
    /**
     * 结算周期日结/周结/月结
     */
    @ApiModelProperty(value = "结算周期日结/周结/月结",name="settlementType")
    @TableField("settlement_type")
    private String settlementType;
    /**
     * 计划投放分类行业类目
     */
    @ApiModelProperty(value = "计划投放分类行业类目",name="settlementCategory")
    @TableField("settlement_category")
    private String settlementCategory;
    /**
     * 渠道验证参数cpa/cps注册验证参数
     */
    @ApiModelProperty(value = "渠道验证参数cpa/cps注册验证参数",name="channelParam")
    @TableField("channel_param")
    private String channelParam;
    /**
     * 数据返回cpa/cps 隔日/一周
     */
    @ApiModelProperty(value = "数据返回cpa/cps 隔日/一周",name="channelCallback")
    @TableField("channel_callback")
    private String channelCallback;
    /**
     * cookie有效期cpa/cps
     */
    @ApiModelProperty(value = "cookie有效期cpa/cps",name="channelCookieValidity")
    @TableField("channel_cookie_validity")
    private String channelCookieValidity;
    /**
     * 自定义链接cps
     */
    @ApiModelProperty(value = "自定义链接cps",name="channelShareUrl")
    @TableField("channel_share_url")
    private String channelShareUrl;
    /**
     * 佣金分成cps
     */
    @ApiModelProperty(value = "佣金分成cps",name="commissionRate")
    @TableField("commission_rate")
    private BigDecimal commissionRate;
    /**
     * 单价1000ip
     */
    @ApiModelProperty(value = "单价1000ip",name="unitPrice")
    @TableField("unit_price")
    private BigDecimal unitPrice;
    /**
     * 每日限额达到每日预算限额时，广告就会在当天停止展示
     */
    @ApiModelProperty(value = "每日限额达到每日预算限额时，广告就会在当天停止展示",name="limitAmount")
    @TableField("limit_amount")
    private BigDecimal limitAmount;
    /**
     * 价格说明
     */
    @ApiModelProperty(value = "价格说明",name="priceRemarks")
    @TableField("price_remarks")
    private String priceRemarks;
    /**
     * 结束类型
     */
    @ApiModelProperty(value = "结束类型",name="endType")
    @TableField("end_type")
    private String endType;
    /**
     * 结束日期
     */
    @ApiModelProperty(value = "结束日期",name="endDate")
    @TableField("end_date")
    private Date endDate;
    /**
     * logo
     */
    @ApiModelProperty(value = "logo",name="logo")
    private String logo;
    /**
     * 项目介绍
     */
    @ApiModelProperty(value = "项目介绍",name="promotionRemarks")
    @TableField("promotion_remarks")
    private String promotionRemarks;
    /**
     * 投放地域
     */
    @ApiModelProperty(value = "投放地域",name="promotionArea")
    @TableField("promotion_area")
    private String promotionArea;
    /**
     * 网站类型
     */
    @ApiModelProperty(value = "网站类型",name="webType")
    @TableField("web_type")
    private String webType;
    /**
     * 周期日程-日期
     */
    @ApiModelProperty(value = "周期日程-日期",name="periodWeek")
    @TableField("period_week")
    private String periodWeek;
    /**
     * 周期日程-小时
     */
    @ApiModelProperty(value = "周期日程-小时",name="periodDay")
    @TableField("period_day")
    private String periodDay;
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

    public String getPlanName() {
        return planName;
    }

    public void setPlanName(String planName) {
        this.planName = planName;
    }

    public String getPlanCode() {
        return planCode;
    }

    public void setPlanCode(String planCode) {
        this.planCode = planCode;
    }

    public String getChargingMode() {
        return chargingMode;
    }

    public void setChargingMode(String chargingMode) {
        this.chargingMode = chargingMode;
    }

    public String getAuditMode() {
        return auditMode;
    }

    public void setAuditMode(String auditMode) {
        this.auditMode = auditMode;
    }

    public String getDevicesType() {
        return devicesType;
    }

    public void setDevicesType(String devicesType) {
        this.devicesType = devicesType;
    }

    public String getSettlementType() {
        return settlementType;
    }

    public void setSettlementType(String settlementType) {
        this.settlementType = settlementType;
    }

    public String getSettlementCategory() {
        return settlementCategory;
    }

    public void setSettlementCategory(String settlementCategory) {
        this.settlementCategory = settlementCategory;
    }

    public String getChannelParam() {
        return channelParam;
    }

    public void setChannelParam(String channelParam) {
        this.channelParam = channelParam;
    }

    public String getChannelCallback() {
        return channelCallback;
    }

    public void setChannelCallback(String channelCallback) {
        this.channelCallback = channelCallback;
    }

    public String getChannelCookieValidity() {
        return channelCookieValidity;
    }

    public void setChannelCookieValidity(String channelCookieValidity) {
        this.channelCookieValidity = channelCookieValidity;
    }

    public String getChannelShareUrl() {
        return channelShareUrl;
    }

    public void setChannelShareUrl(String channelShareUrl) {
        this.channelShareUrl = channelShareUrl;
    }

    public BigDecimal getCommissionRate() {
        return commissionRate;
    }

    public void setCommissionRate(BigDecimal commissionRate) {
        this.commissionRate = commissionRate;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public BigDecimal getLimitAmount() {
        return limitAmount;
    }

    public void setLimitAmount(BigDecimal limitAmount) {
        this.limitAmount = limitAmount;
    }

    public String getPriceRemarks() {
        return priceRemarks;
    }

    public void setPriceRemarks(String priceRemarks) {
        this.priceRemarks = priceRemarks;
    }

    public String getEndType() {
        return endType;
    }

    public void setEndType(String endType) {
        this.endType = endType;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getPromotionRemarks() {
        return promotionRemarks;
    }

    public void setPromotionRemarks(String promotionRemarks) {
        this.promotionRemarks = promotionRemarks;
    }

    public String getPromotionArea() {
        return promotionArea;
    }

    public void setPromotionArea(String promotionArea) {
        this.promotionArea = promotionArea;
    }

    public String getWebType() {
        return webType;
    }

    public void setWebType(String webType) {
        this.webType = webType;
    }

    public String getPeriodWeek() {
        return periodWeek;
    }

    public void setPeriodWeek(String periodWeek) {
        this.periodWeek = periodWeek;
    }

    public String getPeriodDay() {
        return periodDay;
    }

    public void setPeriodDay(String periodDay) {
        this.periodDay = periodDay;
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
        return "AdPromotionPlan{" +
        "id=" + id +
        ", userId=" + userId +
        ", planName=" + planName +
        ", planCode=" + planCode +
        ", chargingMode=" + chargingMode +
        ", auditMode=" + auditMode +
        ", devicesType=" + devicesType +
        ", settlementType=" + settlementType +
        ", settlementCategory=" + settlementCategory +
        ", channelParam=" + channelParam +
        ", channelCallback=" + channelCallback +
        ", channelCookieValidity=" + channelCookieValidity +
        ", channelShareUrl=" + channelShareUrl +
        ", commissionRate=" + commissionRate +
        ", unitPrice=" + unitPrice +
        ", limitAmount=" + limitAmount +
        ", priceRemarks=" + priceRemarks +
        ", endType=" + endType +
        ", endDate=" + endDate +
        ", logo=" + logo +
        ", promotionRemarks=" + promotionRemarks +
        ", promotionArea=" + promotionArea +
        ", webType=" + webType +
        ", periodWeek=" + periodWeek +
        ", periodDay=" + periodDay +
        ", status=" + status +
        ", remarks=" + remarks +
        ", deleteFlag=" + deleteFlag +
        ", createTime=" + createTime +
        ", modifyTime=" + modifyTime +
        ", createUser=" + createUser +
        "}";
    }
}
