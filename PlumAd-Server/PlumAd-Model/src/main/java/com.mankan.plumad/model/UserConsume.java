package com.mankan.plumad.model;

import java.math.BigDecimal;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.annotations.Version;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
/**
 * <p>
 * 用户分润提现表
 * </p>
 *
 * @author lq
 * @since 2019-10-14
 */
@ApiModel(value ="用户消费资金表",description ="用户消费资金表")
@TableName("user_consume")
public class UserConsume extends Model<UserConsume> {

    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    @ApiModelProperty(value = "ID",name="id")
    private String id;
    /**
     * 用户ID
     */
    @ApiModelProperty(value = "用户ID",name="userId")
    @TableField("user_id")
    private String userId;
    /**
     * 日志ID
     */
    @ApiModelProperty(value = "日志ID",name="promotionLogId")
    @TableField("promotion_log_id")
    private String promotionLogId;
    /**
     * 剩余资金
     */
    @ApiModelProperty(value = "剩余资金",name="limitAmount")
    @TableField("limit_amount")
    private BigDecimal limitAmount;
    /**
     * 日消费金额
     */
    @ApiModelProperty(value = "日消费金额",name="dayLimitAmount")
    @TableField("day_limit_amount")
    private BigDecimal dayLimitAmount;
    /**
     * 消费金额
     */
    @ApiModelProperty(value = "消费金额",name="totalAmount")
    @TableField("total_amount")
    private BigDecimal totalAmount;
    /**
     * 请求时间
     */
    @ApiModelProperty(value = "请求时间",name="requestTime")
    @TableField("request_time")
    private Date requestTime;
    /**
     * 返回时间
     */
    @ApiModelProperty(value = "返回时间",name="responseTime")
    @TableField("response_time")
    private Date responseTime;
    /**
     * 查询通知时间
     */
    @ApiModelProperty(value = "查询通知时间",name="notifyTime")
    @TableField("notify_time")
    private Date notifyTime;
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

    public String getPromotionLogId() {
        return promotionLogId;
    }

    public void setPromotionLogId(String promotionLogId) {
        this.promotionLogId = promotionLogId;
    }

    public BigDecimal getLimitAmount() {
        return limitAmount;
    }

    public void setLimitAmount(BigDecimal limitAmount) {
        this.limitAmount = limitAmount;
    }

    public BigDecimal getDayLimitAmount() {
        return dayLimitAmount;
    }

    public void setDayLimitAmount(BigDecimal dayLimitAmount) {
        this.dayLimitAmount = dayLimitAmount;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Date getRequestTime() {
        return requestTime;
    }

    public void setRequestTime(Date requestTime) {
        this.requestTime = requestTime;
    }

    public Date getResponseTime() {
        return responseTime;
    }

    public void setResponseTime(Date responseTime) {
        this.responseTime = responseTime;
    }

    public Date getNotifyTime() {
        return notifyTime;
    }

    public void setNotifyTime(Date notifyTime) {
        this.notifyTime = notifyTime;
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

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "UserConsume{" +
        "id=" + id +
        ", userId=" + userId +
        ", promotionLogId=" + promotionLogId +
        ", limitAmount=" + limitAmount +
        ", dayLimitAmount=" + dayLimitAmount +
        ", totalAmount=" + totalAmount +
        ", requestTime=" + requestTime +
        ", responseTime=" + responseTime +
        ", notifyTime=" + notifyTime +
        ", status=" + status +
        ", remarks=" + remarks +
        "}";
    }
}
