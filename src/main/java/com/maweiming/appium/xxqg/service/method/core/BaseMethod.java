/**
 * fshows.com
 * Copyright (C) 2013-2020 All Rights Reserved.
 */
package com.maweiming.appium.xxqg.service.method.core;

import cn.hutool.core.thread.ThreadUtil;
import com.alibaba.fastjson.JSONObject;
import com.maweiming.appium.xxqg.configs.SysConfig;
import org.springframework.stereotype.Service;

/**
 * @author CoderMa
 * @version BaseMethod.java, v 0.1 2020-11-24 4:50 下午 CoderMa
 */
@Service
public class BaseMethod {

    public JSONObject param;

    public String method;

    public String submethod;

    public void initData(String method, String submethod) {
        this.param = SysConfig.config.getJSONObject("method").getJSONObject(method);
        this.method = method;
        this.submethod = submethod;
    }

    public void sleep() {
        Integer waitTime = param.getInteger("waitTime");
        if (null == waitTime) {
            waitTime = 0;
        }
        ThreadUtil.sleep(waitTime);
    }

}