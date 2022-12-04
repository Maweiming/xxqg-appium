/**
 * fshows.com
 * Copyright (C) 2013-2020 All Rights Reserved.
 */
package com.maweiming.appium.xxqg.service.activity;

import com.maweiming.appium.xxqg.common.exception.ActivityException;
import com.maweiming.appium.xxqg.retry.RetryIntegrationService;
import com.maweiming.appium.xxqg.service.activity.core.IActivity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author CoderMa
 * @version ActivityNotice.java, v 0.1 2020-11-24 4:57 下午 CoderMa
 */
@Slf4j
@Service
public class ActivityNotice {

    @Autowired
    private ActivityFactory activityFactory;

    @Autowired
    private RetryIntegrationService retryIntegrationService;

    public void notice() {
        try {
            //获取当前activity
            String activityId = retryIntegrationService.appiumGetActivity();
            //调用activity工厂
            IActivity activity = activityFactory.createActivity(activityId);
            StackTraceElement[] s = new Exception().getStackTrace();
            System.out.println(s[1].getClassName() + s[1].getMethodName());
            if (null != activity) {
                activity.run();
            } else {
                System.out.println();
            }
        } catch (ActivityException e) {
            e.printStackTrace();
        }
    }

}