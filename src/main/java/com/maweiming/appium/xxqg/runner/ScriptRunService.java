/**
 * fshows.com
 * Copyright (C) 2013-2020 All Rights Reserved.
 */
package com.maweiming.appium.xxqg.runner;

import cn.hutool.core.thread.ThreadUtil;
import com.maweiming.appium.xxqg.common.utils.AdbUtils;
import com.maweiming.appium.xxqg.configs.AndroidDriverConfig;
import com.maweiming.appium.xxqg.service.activity.ActivityNotice;
import com.maweiming.appium.xxqg.service.activity.DefaultActivity;
import io.appium.java_client.android.Activity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

import java.util.Scanner;

/**
 * @author CoderMa
 * @version ScriptRunService.java, v 0.1 2020-11-24 2:57 下午 CoderMa
 */
@Order(value = 2)
@Slf4j
@Service
public class ScriptRunService implements ApplicationRunner {

    @Autowired
    private ActivityNotice activityNotice;

    @Autowired
    private DefaultActivity defaultActivity;

    @Autowired
    private AppiumRunService appiumRunService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
//        while (null == appiumRunService.getExec()){
//            ThreadUtil.sleep(1000);
//            System.out.println("等待appium启动...");
//        }
        Scanner input = new Scanner(System.in);
        System.out.print("请输入设备编号:");
        AndroidDriverConfig.unlock();
        AndroidDriverConfig.loadConfig(input.next());
        AdbUtils.execute("uninstall com.github.uiautomator");
        AdbUtils.execute("uninstall com.github.uiautomator2");
        AdbUtils.execute("uninstall com.github.uiautomator.test");
        //打开学习强国
        AndroidDriverConfig.driver.startActivity(new Activity("cn.xuexi.android", "com.alibaba.android.rimet.biz.SplashActivity"));
        ThreadUtil.sleep(5000);
        //触发首页事件
        defaultActivity.initData("com.alibaba.android.rimet.biz.home.activity.HomeActivity");
        defaultActivity.run();
        appiumRunService.destroy();
    }
}