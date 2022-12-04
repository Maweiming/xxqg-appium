/**
 * fshows.com
 * Copyright (C) 2013-2020 All Rights Reserved.
 */
package com.maweiming.appium.xxqg.common.exception;

import com.maweiming.appium.xxqg.common.enums.ActivityErrorEnum;

import java.text.MessageFormat;

/**
 * @author CoderMa
 * @version ActivityException.java, v 0.1 2020-11-24 5:39 下午 CoderMa
 */

public class ActivityException extends BaseException {

    public static final ActivityException NOT_FIND_ACTIVITY_ERROR = new ActivityException(ActivityErrorEnum.NOT_FIND_ACTIVITY);

    public ActivityException() {
    }

    private ActivityException(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    /**
     * 异常构造器
     *
     * @param errorEnums
     */
    public ActivityException(ActivityErrorEnum errorEnums) {
        this(errorEnums.getCode(), errorEnums.getMsg());
    }

    @Override
    public BaseException newInstance(String msgFormat, Object... args) {
        return new ActivityException(code, MessageFormat.format(msgFormat, args));
    }
}