package com.mankan.plumad.dto;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author: youtiao
 * @create: 2019-10-15 08:46
 * @description:
 **/
public class RechargeVO implements Serializable {

    private String payType;
    private String payUrl;
    private String responseMsg;
    private String responseCode;

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }

    public String getPayUrl() {
        return payUrl;
    }

    public void setPayUrl(String payUrl) {
        this.payUrl = payUrl;
    }

    public String getResponseMsg() {
        return responseMsg;
    }

    public void setResponseMsg(String responseMsg) {
        this.responseMsg = responseMsg;
    }

    public String getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }
}
