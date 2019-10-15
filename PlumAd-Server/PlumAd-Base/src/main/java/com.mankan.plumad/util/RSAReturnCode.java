package com.mankan.plumad.util;

public enum RSAReturnCode {
    /**
     * 成功
     */
    SUCCESS(20000,"成功"),
    /**
     * 加密失败
     */
    ENCRYPTIONFAILURE(20003,"加密失败"),
    /**
     * 验签失败
     */
    CHECKFAILURE(20002,"验签失败"),
    /**
     * 解密失败
     */
    DECRYPTIONFAILURE(20001,"解密失败");


    private final int code;
    private final String msg;

     RSAReturnCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    @Override
    public String toString() {
        return "returnCode{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                '}';
    }
}

