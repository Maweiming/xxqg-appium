/**
 * fshows.com
 * Copyright (C) 2013-2020 All Rights Reserved.
 */
package com.maweiming.appium.xxqg.common.utils;

import cn.hutool.core.util.RuntimeUtil;

/**
 * @author CoderMa
 * @version AdbUtils.java, v 0.1 2020-11-24 3:16 下午 CoderMa
 */
public class AdbUtils {

    /**
     * 执行脚本
     */
    public static String execute(String cmd) {
        return RuntimeUtil.execForStr(String.format("adb %s", cmd));
    }

    /**
     * 执行输入文本命令
     */
    public static String executeInputText(String content) {
        String cmd = String.format("shell input text %s", content);
        return execute(cmd);
    }

}