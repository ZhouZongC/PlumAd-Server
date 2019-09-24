package com.mankan.plumad.model;

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
 * 用户充值记录表
 * </p>
 *
 * @author lq
 * @since 2019-09-24
 */
@ApiModel(value ="用户充值记录表",description ="用户充值记录表")
@TableName("user_recharge")
public class UserRecharge extends Model<UserRecharge> {

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
     * 充值类型
     */
    @ApiModelProperty(value = "充值类型",name="rechargeAmount")
    @TableField("recharge_amount")
    private String rechargeAmount;
    /**
     * 支付类型
     */
    @ApiModelProperty(value = "支付类型",name="payType")
    @TableField("pay_type")
    private String payType;
    /**
     * 请求时间
     */
    @ApiModelProperty(value = "请求时间",name="requestTime")
    @TableField("request_time")
    private Date requestTime;
    /**
     * 响应时间
     */
    @ApiModelProperty(value = "响应时间",name="responseTime")
    @TableField("response_time")
    private Date responseTime;
    /**
     * 通知时间
     */
    @ApiModelProperty(value = "通知时间",name="notifyTime")
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

    public String getRechargeAmount() {
        return rechargeAmount;
    }

    public void setRechargeAmount(String rechargeAmount) {
        this.rechargeAmount = rechargeAmount;
    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
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
        return "UserRecharge{" +
        "id=" + id +
        ", userId=" + userId +
        ", ipAddress=" + ipAddress +
        ", orderNum=" + orderNum +
        ", rechargeAmount=" + rechargeAmount +
        ", payType=" + payType +
        ", requestTime=" + requestTime +
        ", responseTime=" + responseTime +
        ", notifyTime=" + notifyTime +
        ", status=" + status +
        ", remarks=" + remarks +
        "}";
    }
}
