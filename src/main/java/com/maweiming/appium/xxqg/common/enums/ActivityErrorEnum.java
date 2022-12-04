/**
 * fshows.com
 * Copyright (C) 2013-2020 All Rights Reserved.
 */
package com.maweiming.appium.xxqg.common.enums;

/**
 * @author CoderMa
 * @version ActivityErrorEnum.java, v 0.1 2020-11-24 5:42 下午 CoderMa
 */
public enum ActivityErrorEnum {

    NOT_FIND_ACTIVITY("1001", "未找到activity");

    private String code;
    private String msg;

    ActivityErrorEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    /**
     * Getter method for property <tt>code</tt>.
     *
     * @return property value of code
     */
    public String getCode() {
        return code;
    }

    /**
     * Getter method for property <tt>msg</tt>.
     *
     * @return property msg of msg
     */
    public String getMsg() {
        return msg;
    }
}