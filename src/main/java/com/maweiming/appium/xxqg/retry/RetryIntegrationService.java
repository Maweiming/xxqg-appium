/**
 * fshows.com
 * Copyright (C) 2013-2020 All Rights Reserved.
 */
package com.maweiming.appium.xxqg.retry;

import com.maweiming.appium.xxqg.common.exception.ActivityException;
import com.maweiming.appium.xxqg.configs.AndroidDriverConfig;
import com.maweiming.appium.xxqg.configs.SysConfig;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriverException;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

/**
 * 重试代码合集
 * 由于
 *
 * @author CoderMa
 * @version RetryIntegrationService.java, v 0.1 2020-11-25 5:32 下午 CoderMa
 */
@Slf4j
@Service
public class RetryIntegrationService {

    @Retryable(value = WebDriverException.class, maxAttempts = 3, backoff = @Backoff(delay = 2000L, multiplier = 1.5))
    public void appiumXPathLiteClick(String xPathLite) {
        AndroidDriverConfig.driver.findElementByXPath(xPathLite).click();
    }

    @Retryable(value = ActivityException.class, maxAttempts = 3, backoff = @Backoff(delay = 2000L, multiplier = 1.5))
    public String appiumGetActivity() {
        //获取当前Activity
        String toActivity = AndroidDriverConfig.driver.currentActivity();
        if (!SysConfig.config.getJSONObject("activity").containsKey(toActivity)) {
            log.info("当前activity为设置事件,return...{}", toActivity);
            throw ActivityException.NOT_FIND_ACTIVITY_ERROR;
        }
        return toActivity;
    }

    @Retryable(value = WebDriverException.class, maxAttempts = 2, backoff = @Backoff(delay = 1000L, multiplier = 1))
    public Boolean checkDisplayed(String xPathLite) {
        return AndroidDriverConfig.driver.findElementByXPath(xPathLite).isDisplayed();
    }

}