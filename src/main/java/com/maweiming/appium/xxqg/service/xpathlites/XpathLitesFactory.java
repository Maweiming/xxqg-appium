/**
 * fshows.com
 * Copyright (C) 2013-2020 All Rights Reserved.
 */
package com.maweiming.appium.xxqg.service.xpathlites;

import com.maweiming.appium.xxqg.service.xpathlites.core.IXpathLites;
import com.maweiming.appium.xxqg.service.xpathlites.core.IXpathLitesFactory;
import com.maweiming.appium.xxqg.service.xpathlites.core.XpathLitesModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author CoderMa
 * @version XpathLitesService.java, v 0.1 2020-11-24 2:59 下午 CoderMa
 */
@Service
public class XpathLitesFactory implements IXpathLitesFactory {

    @Autowired
    private AdbXpathLite adbXpathLite;

    @Autowired
    private ClickXpathLite clickXpathLite;

    @Autowired
    private InputXpathLite inputXpathLite;

    @Autowired
    private TabXpathLite tabXpathLite;

    @Autowired
    private WaitDisplayedXpathLite waitDisplayedXpathLite;

    @Override
    public IXpathLites createXpathLites(XpathLitesModel model) {
        IXpathLites xpathLites = null;
        switch (model.getType()) {
            case "adb":
                xpathLites = adbXpathLite;
                break;
            case "input":
                xpathLites = inputXpathLite;
                break;
            case "click":
                xpathLites = clickXpathLite;
                break;
            case "tab":
                xpathLites = tabXpathLite;
                break;
            case "waitDisplayed":
                xpathLites = waitDisplayedXpathLite;
                break;
            default:
                break;
        }
        if (null != xpathLites) {
            xpathLites.initData(model);
        }
        return xpathLites;
    }

}