package com.mankan.plumad.dto;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author: youtiao
 * @create: 2019-10-15 08:50
 * @description:
 **/
public class WithdrawVO implements Serializable {


    private String responseMsg;
    private String responseCode;

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
