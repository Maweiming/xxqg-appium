/**
 * fshows.com
 * Copyright (C) 2013-2020 All Rights Reserved.
 */
package com.maweiming.appium.xxqg.service.xpathlites.core;

import cn.hutool.core.thread.ThreadUtil;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.stereotype.Service;

/**
 * @author CoderMa
 * @version BaseXpathLites.java, v 0.1 2020-11-24 3:12 下午 CoderMa
 */
@Service
public class BaseXpathLites {

    public XpathLitesModel model;

    public void initData(XpathLitesModel model) {
        this.model = model;
    }

    public int getValueInteger() {
        return ObjectUtils.defaultIfNull(Integer.valueOf(model.getValue()), 1);
    }

    public void sleep() {
        if (null == model.getWaitTime()) {
            model.setWaitTime(0);
        }
        ThreadUtil.sleep(model.getWaitTime());
    }

}