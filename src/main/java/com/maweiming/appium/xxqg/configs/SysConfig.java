/**
 * fshows.com
 * Copyright (C) 2013-2020 All Rights Reserved.
 */
package com.maweiming.appium.xxqg.configs;

import cn.hutool.core.io.FileUtil;
import com.alibaba.fastjson.JSONObject;
import lombok.Data;

/**
 * @author CoderMa
 * @version SysConfig.java, v 0.1 2020-11-24 5:04 下午 CoderMa
 */
@Data
public class SysConfig {

    public static JSONObject config = loadConfig();

    public static String location = null;

    public static JSONObject loadConfig() {
        return JSONObject.parseObject(FileUtil.readUtf8String("/Users/coderma/coders/MyCoder/xxqg-appium/src/main/resources/setting.json"));
    }

}