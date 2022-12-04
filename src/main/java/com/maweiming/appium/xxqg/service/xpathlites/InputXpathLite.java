/**
 * fshows.com
 * Copyright (C) 2013-2020 All Rights Reserved.
 */
package com.maweiming.appium.xxqg.service.xpathlites;

import com.maweiming.appium.xxqg.configs.AndroidDriverConfig;
import com.maweiming.appium.xxqg.service.xpathlites.core.BaseXpathLites;
import com.maweiming.appium.xxqg.service.xpathlites.core.IXpathLites;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * 输入内容
 *
 * @author CoderMa
 * @version InputXpathLite.java, v 0.1 2020-11-24 3:06 下午 CoderMa
 */
@Slf4j
@Service
public class InputXpathLite extends BaseXpathLites implements IXpathLites {

    @Override
    public void run() {
        log.info("输入指令开始执行,{}", model.getRemark());
        AndroidDriverConfig.driver.findElementByXPath(model.getName()).sendKeys(model.getValue());
        sleep();
        log.info("输入指令开始执行,{}", model.getRemark());
    }
}