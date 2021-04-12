package com.example.hanyan.common;

/**
 * @author vigo.xian
 */

public enum ResultEnum {
    /**
     * 未知异常
     **/
    UNKONW_ERROR(-1, "未知错误"),
    /**
     * 登录成功
     **/
    SUCCESS(200, "成功"),
    ;

    private Integer code;

    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
