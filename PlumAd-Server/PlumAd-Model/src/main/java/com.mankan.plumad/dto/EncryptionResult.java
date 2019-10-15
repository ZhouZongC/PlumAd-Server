package com.mankan.plumad.dto;

import com.mankan.plumad.util.RSAReturnCode;

import java.io.Serializable;

/**
 * @author：lq
 * @description：
 * @date：9:21 2018/7/31
 */
public class EncryptionResult implements Serializable {
    private RSAReturnCode descData;//状态/描述
    private String encryptData;//AES密钥加密请求报文
    private String encrtptKey;//RSA公钥加密AES密钥
    private String signData;//RSA密钥签名报文

    public RSAReturnCode getDescData() {
        return descData;
    }

    public void setDescData(RSAReturnCode descData) {
        this.descData = descData;
    }

    public String getEncryptData() {
        return encryptData;
    }

    public void setEncryptData(String encryptData) {
        this.encryptData = encryptData;
    }

    public String getEncrtptKey() {
        return encrtptKey;
    }

    public void setEncrtptKey(String encrtptKey) {
        this.encrtptKey = encrtptKey;
    }

    public String getSignData() {
        return signData;
    }

    public void setSignData(String signData) {
        this.signData = signData;
    }

    @Override
    public String toString() {
        return "EncryptionResult{" +
                "descData=" + descData +
                ", encryptData='" + encryptData + '\'' +
                ", encrtptKey='" + encrtptKey + '\'' +
                ", signData='" + signData + '\'' +
                '}';
    }
}
