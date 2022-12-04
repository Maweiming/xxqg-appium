/**
 * fshows.com
 * Copyright (C) 2013-2020 All Rights Reserved.
 */
package com.maweiming.appium.xxqg.service.xpathlites;

import com.maweiming.appium.xxqg.service.appium.core.IAppiumService;
import com.maweiming.appium.xxqg.service.method.MethodFactory;
import com.maweiming.appium.xxqg.service.xpathlites.core.BaseXpathLites;
import com.maweiming.appium.xxqg.service.xpathlites.core.IXpathLites;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author CoderMa
 * @version TabXpathLite.java, v 0.1 2020-11-24 3:08 下午 CoderMa
 */
@Slf4j
@Service
public class TabXpathLite extends BaseXpathLites implements IXpathLites {

    @Autowired
    private MethodFactory methodFactory;

    @Autowired
    private IAppiumService appiumService;

    @Override
    public void run() {
        log.info("打开标签开始执行,{}", model.getRemark());
        appiumService.clickByXPathLite(model.getName());
        sleep();
        String[] methods = model.getMethod().split(",");
        for (String method : methods) {
            log.info("开始执行,{}方法", method);
            methodFactory.createMethod(method).run();
            log.info("执行结束,{}方法", method);
        }
        log.info("打开标签执行结束,{}", model.getRemark());
    }
}