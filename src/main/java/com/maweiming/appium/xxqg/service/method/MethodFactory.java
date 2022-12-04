/**
 * fshows.com
 * Copyright (C) 2013-2020 All Rights Reserved.
 */
package com.maweiming.appium.xxqg.service.method;

import com.maweiming.appium.xxqg.service.method.core.IMethod;
import com.maweiming.appium.xxqg.service.method.core.IMethodFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author CoderMa
 * @version MethodFacade.java, v 0.1 2020-11-24 4:45 下午 CoderMa
 */
@Slf4j
@Service
public class MethodFactory implements IMethodFactory {

    @Autowired
    private OpenArticleMethod openArticleMethod;

    @Autowired
    private WatchVideoMethod watchVideoMethod;

    @Autowired
    private ScriptMethod scriptMethod;


    @Override
    public IMethod createMethod(String method) {
        IMethod iMethod = null;
        String submethod = null;
        switch (method) {
            case "openArticle":
                iMethod = openArticleMethod;
                break;
            case "watchVideo":
                iMethod = watchVideoMethod;
                break;
            default:
                String[] methodSplit = method.split(":");
                if (methodSplit.length == 2 && methodSplit[0].equals("script")) {
                    iMethod = scriptMethod;
                    method = methodSplit[0];
                    submethod = methodSplit[1];
                }
                break;
        }
        if (null != iMethod) {
            iMethod.initData(method, submethod);
        }
        return iMethod;
    }
}