/**
 * fshows.com
 * Copyright (C) 2013-2020 All Rights Reserved.
 */
package com.maweiming.appium.xxqg.configs;

import cn.hutool.core.thread.ThreadUtil;
import com.maweiming.appium.xxqg.common.utils.AdbUtils;
import io.appium.java_client.android.AndroidDriver;
import lombok.Data;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PreDestroy;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * @author CoderMa
 * @version AndroidDriverConfig.java, v 0.1 2020-11-24 3:29 下午 CoderMa
 */
@Data
@Configuration
public class AndroidDriverConfig {

    public static AndroidDriver driver;

    public static void loadConfig(String devicesName) {
        DesiredCapabilities des = new DesiredCapabilities();
        des.setCapability("unicodeKeyboard", false);
        des.setCapability("resetKeyboard", false);
        des.setCapability("platformName", "Android");//平台名称
        des.setCapability("platformVersion", "9.0");//手机操作系统版本
        des.setCapability("udid", devicesName);//连接的物理设备的唯一设备标识
        des.setCapability("deviceName", devicesName);//使用的手机类型或模拟器类型  UDID
//        des.setCapability("noReset", false);//防止重安装app
//        des.setCapability("appPackage", "cn.xuexi.android");
//        des.setCapability("appActivity", "com.alibaba.android.rimet.biz.home.activity.HomeActivity");
        des.setCapability("unicodeKeyboard", true);//支持中文输入
        des.setCapability("resetKeyboard", true);//支持中文输入
        des.setCapability("newCommandTimeout", "60");//没有新命令时的超时时间设置
        des.setCapability("nosign", true);//跳过检查和对应用进行 debug 签名的步骤

        try {
            driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), des);//虚拟机默认地址
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);//设置超时等待时间,默认9500ms

    }

    /**
     * 解锁
     */
    public static void unlock() {
        //锁屏
        AdbUtils.execute("shell input keyevent 223");
        ThreadUtil.sleep(1000);
        //解锁
        AdbUtils.execute("shell input keyevent 224");
        ThreadUtil.sleep(1000);
        //上滑解锁
        AdbUtils.execute("shell input swipe 500 1940 500 1260 500");
        ThreadUtil.sleep(1000);
        //输入密码
        AdbUtils.executeInputText("1314");
        ThreadUtil.sleep(5000);
    }

    public static void main(String[] args) {
        loadConfig("172.16.20.224:5555");
        WebDriver webDriver = driver.switchTo().parentFrame();
        System.out.println(webDriver.getCurrentUrl());

    }

    @PreDestroy
    public void destory() {
//        AdbUtils.execute("shell input keyevent 223");
        AdbUtils.execute("shell ime set com.sohu.inputmethod.sogou.xiaomi/.SogouIME");
    }

}