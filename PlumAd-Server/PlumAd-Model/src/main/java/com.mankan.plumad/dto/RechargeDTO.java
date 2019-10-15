package com.mankan.plumad.dto;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author: youtiao
 * @create: 2019-10-15 08:46
 * @description:
 **/
public class RechargeDTO implements Serializable {

    String userId;
    BigDecimal rechargeAmount;
    String payType;
    String ip;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public BigDecimal getRechargeAmount() {
        return rechargeAmount;
    }

    public void setRechargeAmount(BigDecimal rechargeAmount) {
        this.rechargeAmount = rechargeAmount;
    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }
}
