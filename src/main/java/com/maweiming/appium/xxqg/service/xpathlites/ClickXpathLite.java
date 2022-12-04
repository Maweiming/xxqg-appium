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
 * 点击
 *
 * @author CoderMa
 * @version ClickXpathLite.java, v 0.1 2020-11-24 3:07 下午 CoderMa
 */
@Slf4j
@Service
public class ClickXpathLite extends BaseXpathLites implements IXpathLites {

    @Override
    public void run() {
        log.info("点击指令开始执行,{}", model.getRemark());
        for (int i = 0; i < getValueInteger(); i++) {
            AndroidDriverConfig.driver.findElementByXPath(model.getName()).click();
            sleep();
        }
        log.info("点击指令执行结束,{}", model.getRemark());
    }
}