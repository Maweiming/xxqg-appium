/**
 * fshows.com
 * Copyright (C) 2013-2020 All Rights Reserved.
 */
package com.maweiming.appium.xxqg.service.activity;

import com.maweiming.appium.xxqg.configs.SysConfig;
import com.maweiming.appium.xxqg.service.activity.core.BaseActivity;
import com.maweiming.appium.xxqg.service.activity.core.IActivity;
import com.maweiming.appium.xxqg.service.appium.AppiumService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author CoderMa
 * @version DefaultActivity.java, v 0.1 2020-11-25 8:50 下午 CoderMa
 */
@Service
public class ContentDetailsActivity extends BaseActivity implements IActivity {

    @Autowired
    private AppiumService appiumService;

    @Override
    public void run() {
        //获取当前位置
        String location = SysConfig.location;
        if (StringUtils.isBlank(location)) {
            //获取当前位置,检测是否展示视频窗口
            Boolean displayed = appiumService.checkExistByXPathLite("//*[@resource-id=\"cn.xuexi.android:id/EXTRA_INFO_LAYER_VIEW_ID\"]");
            location = displayed ? "video" : "article";
        }
        //加载内容
        xpathLitesRun(location);
    }

}