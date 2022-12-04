/**
 * fshows.com
 * Copyright (C) 2013-2020 All Rights Reserved.
 */
package com.maweiming.appium.xxqg.service.activity.core;

import cn.hutool.core.thread.ThreadUtil;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.maweiming.appium.xxqg.configs.SysConfig;
import com.maweiming.appium.xxqg.service.xpathlites.XpathLitesFactory;
import com.maweiming.appium.xxqg.service.xpathlites.core.IXpathLites;
import com.maweiming.appium.xxqg.service.xpathlites.core.XpathLitesModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author CoderMa
 * @version BaseActivity.java, v 0.1 2020-11-25 8:50 下午 CoderMa
 */
@Service
public class BaseActivity {

    public JSONObject param;
    public String activity;
    @Autowired
    private XpathLitesFactory xpathLitesFactory;

    public void initData(String activity) {
        this.param = SysConfig.config.getJSONObject("activity").getJSONObject(activity);
        this.activity = activity;
    }

    public void sleep() {
        Integer waitTime = param.getInteger("waitTime");
        if (null == waitTime) {
            waitTime = 0;
        }
        ThreadUtil.sleep(waitTime);
    }

    public void xpathLitesRun(String key) {
        JSONArray xpathLites = param.getJSONArray(key);
        for (int i = 0; i < xpathLites.size(); i++) {
            XpathLitesModel xpathLitesModel = xpathLites.getObject(i, XpathLitesModel.class);
            IXpathLites xpathLitesFacade = this.xpathLitesFactory.createXpathLites(xpathLitesModel);
            xpathLitesFacade.run();
        }
    }

}