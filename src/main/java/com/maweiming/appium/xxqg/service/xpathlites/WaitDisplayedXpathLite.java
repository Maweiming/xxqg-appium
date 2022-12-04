/**
 * fshows.com
 * Copyright (C) 2013-2020 All Rights Reserved.
 */
package com.maweiming.appium.xxqg.service.xpathlites;

import com.maweiming.appium.xxqg.service.appium.AppiumService;
import com.maweiming.appium.xxqg.service.xpathlites.core.BaseXpathLites;
import com.maweiming.appium.xxqg.service.xpathlites.core.IXpathLites;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author CoderMa
 * @version WaitDisplayedXpathLite.java, v 0.1 2020-11-25 9:30 下午 CoderMa
 */
@Slf4j
@Service
public class WaitDisplayedXpathLite extends BaseXpathLites implements IXpathLites {

    @Autowired
    private AppiumService appiumService;

    @Override
    public void run() {
        appiumService.checkExistByXPathLite(model.getName(), model.getWaitTime(), TimeUnit.MILLISECONDS);
    }

}