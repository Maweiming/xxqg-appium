/**
 * fshows.com
 * Copyright (C) 2013-2020 All Rights Reserved.
 */
package com.maweiming.appium.xxqg.service.method;

import com.maweiming.appium.xxqg.configs.SysConfig;
import com.maweiming.appium.xxqg.service.activity.ActivityNotice;
import com.maweiming.appium.xxqg.service.appium.core.IAppiumService;
import com.maweiming.appium.xxqg.service.method.core.BaseMethod;
import com.maweiming.appium.xxqg.service.method.core.IMethod;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;

/**
 * 打开文章
 * openArticle
 *
 * @author CoderMa
 * @version OpenArticleMethod.java, v 0.1 2020-11-24 4:48 下午 CoderMa
 */
@Slf4j
@Service
public class OpenArticleMethod extends BaseMethod implements IMethod {

    @Autowired
    private ActivityNotice activityNotice;

    @Autowired
    private MethodFactory methodFactory;

    @Autowired
    private IAppiumService appiumService;

    @Override
    public void run() {
        SysConfig.location = param.getString("location");
        String labelXpathLite = param.getString("labelXpathLite");
        appiumService.clickByXPathLite(labelXpathLite);
        sleep();
        Integer frequency = param.getInteger("frequency");
        for (Integer n = 0; n < frequency; n++) {
            String xpathLiteFormat = param.getString("xpathLite");
            Integer begin = param.getInteger("begin");
            Integer end = param.getInteger("end");
            for (; begin <= end; begin++) {
                String xpathLite = MessageFormat.format(xpathLiteFormat, begin);
                Boolean clickResult = appiumService.clickByXPathLite(xpathLite);
                sleep();
                if (clickResult) {
                    //通知
                    activityNotice.notice();
                }
            }
            //调用下一个方法，滑动
            IMethod nextMethod = methodFactory.createMethod(param.getString("nextMethod"));
            nextMethod.run();
        }
    }

}