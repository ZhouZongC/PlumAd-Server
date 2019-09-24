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
 * @since 2019-09-24
 */
@ApiModel(value ="用户分润提现表",description ="用户分润提现表")
@TableName("user_withdraw")
public class UserWithdraw extends Model<UserWithdraw> {

    private static final long serialVersionUID = 1L;

    private String id;
    /**
     * 用户id
     */
    @ApiModelProperty(value = "用户id",name="userId")
    @TableField("user_id")
    private String userId;
    /**
     * ip
     */
    @ApiModelProperty(value = "ip",name="ipAddress")
    @TableField("ip_address")
    private String ipAddress;
    /**
     * 订单号
     */
    @ApiModelProperty(value = "订单号",name="orderNum")
    @TableField("order_num")
    private String orderNum;
    /**
     * 提现金额
     */
    @ApiModelProperty(value = "提现金额",name="totalAmount")
    @TableField("total_amount")
    private BigDecimal totalAmount;
    /**
     * 代扣税
     */
    @ApiModelProperty(value = "代扣税",name="taxation")
    private BigDecimal taxation;
    /**
     * 手续费
     */
    @ApiModelProperty(value = "手续费",name="serviceFee")
    @TableField("service_fee")
    private BigDecimal serviceFee;
    /**
     * 应付金额
     */
    @ApiModelProperty(value = "应付金额",name="withdrawAmount")
    @TableField("withdraw_amount")
    private BigDecimal withdrawAmount;
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

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public BigDecimal getTaxation() {
        return taxation;
    }

    public void setTaxation(BigDecimal taxation) {
        this.taxation = taxation;
    }

    public BigDecimal getServiceFee() {
        return serviceFee;
    }

    public void setServiceFee(BigDecimal serviceFee) {
        this.serviceFee = serviceFee;
    }

    public BigDecimal getWithdrawAmount() {
        return withdrawAmount;
    }

    public void setWithdrawAmount(BigDecimal withdrawAmount) {
        this.withdrawAmount = withdrawAmount;
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
        return "UserWithdraw{" +
        "id=" + id +
        ", userId=" + userId +
        ", ipAddress=" + ipAddress +
        ", orderNum=" + orderNum +
        ", totalAmount=" + totalAmount +
        ", taxation=" + taxation +
        ", serviceFee=" + serviceFee +
        ", withdrawAmount=" + withdrawAmount +
        ", requestTime=" + requestTime +
        ", responseTime=" + responseTime +
        ", notifyTime=" + notifyTime +
        ", status=" + status +
        ", remarks=" + remarks +
        "}";
    }
}
