/**
 * fshows.com
 * Copyright (C) 2013-2020 All Rights Reserved.
 */
package com.maweiming.appium.xxqg.service.appium;

import cn.hutool.core.thread.ThreadUtil;
import com.maweiming.appium.xxqg.configs.AndroidDriverConfig;
import com.maweiming.appium.xxqg.retry.RetryIntegrationService;
import com.maweiming.appium.xxqg.service.appium.core.IAppiumService;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriverException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/**
 * @author CoderMa
 * @version AppiumService.java, v 0.1 2020-11-25 5:05 下午 CoderMa
 */
@Slf4j
@Service
public class AppiumService implements IAppiumService {

    @Autowired
    private RetryIntegrationService retryIntegrationService;

    @Override
    public Boolean clickByXPathLite(String xPathLite) {
        try {
            retryIntegrationService.appiumXPathLiteClick(xPathLite);
            return true;
        } catch (WebDriverException e) {
            log.info("通过XPathLite点击操作失败,XPathLite={}", xPathLite);
            return false;
        }
    }

    @Override
    public Boolean checkDisplayed(String xPathLite) {
        try {
            return retryIntegrationService.checkDisplayed(xPathLite);
        } catch (WebDriverException e) {
            return false;
        }
    }

    /**
     * 速度有时候很慢，不建议频繁调用
     */
    @Override
    public Boolean checkExistByXPathLite(String xPathLite) {
        try {
            AndroidDriverConfig.driver.findElementByXPath(xPathLite);
            return true;
        } catch (WebDriverException e) {
            return false;
        }
    }

    @Override
    public Boolean checkExistByXPathLite(String xPathLite, Integer maxTime, TimeUnit timeUnit) {
        Callable<Boolean> callable = new Callable<Boolean>() {
            @Override
            public Boolean call() {
                Integer time = 0;
                Boolean exist = false;
                while (time < maxTime && !exist) {
                    //等待10秒
                    exist = checkExistByXPathLite(xPathLite);
                    log.info("正在检测XPathLite元素是否存在,XPathLite={}", xPathLite);
                    ThreadUtil.sleep(2000);
                    time += 2000;
                }
                if (!exist && time >= maxTime) {
                    log.info("检测XPathLite元素任务超时,xPathLite={}", xPathLite);
                }
                if (exist) {
                    log.info("检测到XPathLite元素存在,即将退出,XPathLite={}", xPathLite);
                }
                return exist;
            }
        };
        try {
            return callable.call();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

}