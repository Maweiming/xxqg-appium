/**
 * fshows.com
 * Copyright (C) 2013-2020 All Rights Reserved.
 */
package com.maweiming.appium.xxqg.service.appium.core;

import java.util.concurrent.TimeUnit;

/**
 * @author CoderMa
 * @version IAppiumService.java, v 0.1 2020-11-25 5:06 下午 CoderMa
 */
public interface IAppiumService {

    Boolean clickByXPathLite(String xPathLite);

    Boolean checkDisplayed(String xPathLite);

    Boolean checkExistByXPathLite(String xPathLite);

    Boolean checkExistByXPathLite(String xPathLite, Integer time, TimeUnit timeUnit);

}