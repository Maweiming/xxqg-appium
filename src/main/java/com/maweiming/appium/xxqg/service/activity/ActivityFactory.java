/**
 * fshows.com
 * Copyright (C) 2013-2020 All Rights Reserved.
 */
package com.maweiming.appium.xxqg.service.activity;

import com.maweiming.appium.xxqg.service.activity.core.IActivity;
import com.maweiming.appium.xxqg.service.activity.core.IActivityFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author CoderMa
 * @version ActivityFactory.java, v 0.1 2020-11-25 8:46 下午 CoderMa
 */
@Slf4j
@Service
public class ActivityFactory implements IActivityFactory {

    @Autowired
    private DefaultActivity defaultActivity;

    @Autowired
    private ContentDetailsActivity contentDetailsActivity;


    @Override
    public IActivity createActivity(String activity) {
        IActivity iActivity = null;
        switch (activity) {
            case "com.alibaba.android.user.login.SignUpWithPwdActivity":
                iActivity = defaultActivity;
                break;
//            case "com.alibaba.android.rimet.biz.home.activity.HomeActivity":
//                iActivity = defaultActivity;
//                break;
            case "com.alibaba.android.uc.base.navi.window2.Window2Activity":
                iActivity = contentDetailsActivity;
                break;
            default:
                break;
        }
        if (null != iActivity) {
            iActivity.initData(activity);
        }
        log.info("检测到进入{}", activity);
        return iActivity;
    }
}