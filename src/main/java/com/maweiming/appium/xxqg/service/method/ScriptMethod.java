/**
 * fshows.com
 * Copyright (C) 2013-2020 All Rights Reserved.
 */
package com.maweiming.appium.xxqg.service.method;

import com.alibaba.fastjson.JSONArray;
import com.maweiming.appium.xxqg.service.method.core.BaseMethod;
import com.maweiming.appium.xxqg.service.method.core.IMethod;
import com.maweiming.appium.xxqg.service.xpathlites.XpathLitesFactory;
import com.maweiming.appium.xxqg.service.xpathlites.core.IXpathLites;
import com.maweiming.appium.xxqg.service.xpathlites.core.XpathLitesModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author CoderMa
 * @version ScriptMethod.java, v 0.1 2020-11-24 4:49 下午 CoderMa
 */
@Service
public class ScriptMethod extends BaseMethod implements IMethod {

    @Autowired
    private XpathLitesFactory xpathLitesFactory;

    @Override
    public void run() {
        JSONArray xpathLites = param.getJSONObject(submethod).getJSONArray("xpathLites");
        for (int i = 0; i < xpathLites.size(); i++) {
            XpathLitesModel xpathLitesModel = xpathLites.getObject(i, XpathLitesModel.class);
            IXpathLites xpathLitesFacade = this.xpathLitesFactory.createXpathLites(xpathLitesModel);
            xpathLitesFacade.run();
        }
    }

}