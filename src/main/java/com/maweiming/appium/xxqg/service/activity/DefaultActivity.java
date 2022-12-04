/**
 * fshows.com
 * Copyright (C) 2013-2020 All Rights Reserved.
 */
package com.maweiming.appium.xxqg.service.activity;

import com.maweiming.appium.xxqg.service.activity.core.BaseActivity;
import com.maweiming.appium.xxqg.service.activity.core.IActivity;
import org.springframework.stereotype.Service;

/**
 * @author CoderMa
 * @version LoginActivity.java, v 0.1 2020-11-25 8:50 下午 CoderMa
 */
@Service
public class DefaultActivity extends BaseActivity implements IActivity {

    @Override
    public void run() {
        xpathLitesRun("xpathLites");
    }

}