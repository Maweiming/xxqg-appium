package com.maweiming.appium.xxqg.service; /**
 * fshows.com
 * Copyright (C) 2013-2020 All Rights Reserved.
 */

import com.maweiming.appium.xxqg.common.utils.AdbUtils;
import io.appium.java_client.android.AndroidDriver;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * @author CoderMa
 * @version com.maweiming.appium.xxqg.service.AppiumDemoTest.java, v 0.1 2020-11-20 5:17 下午 CoderMa
 */
public class AppiumDemoTest {

    AndroidDriver driver = null;

    private static void sleep(int sleep) {
        try {
            Thread.sleep(sleep);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test() throws Exception {

//        AdbUtils.execute("uninstall com.github.uiautomator");
//        AdbUtils.execute("uninstall com.github.uiautomator2");
//        AdbUtils.execute("uninstall com.github.uiautomator.test");


        DesiredCapabilities des = new DesiredCapabilities();
//        des.setCapability("noReset",false);
//    des.setCapability("automationName", "Appium");//Selendroid //自动化的模式选择
//     des.setCapability("app", "C:\\software\\CalcTest.apk");//配置待测试的apk的路径
//      des.setCapability("browserName", "chrome");  //h5
        //'automationName': 'Uiautomator2'              # 使用Uiautomator2
//        des.setCapability("automationName","Uiautomator");
        des.setCapability("platformName", "Android");//平台名称
        des.setCapability("platformVersion", "9.0");//手机操作系统版本
        des.setCapability("udid", "76afaf1c");//连接的物理设备的唯一设备标识
        des.setCapability("deviceName", "76afaf1c");//使用的手机类型或模拟器类型  UDID
//        des.setCapability("appPackage", "cn.xuexi.android");//App安装后的包名,注意与原来的CalcTest.apk不一样
//        des.setCapability("appActivity", "com.alibaba.android.rimet.biz.home.activity.HomeActivity");//app测试人员常常要获取activity，进行相关测试,后续会讲到

        des.setCapability("unicodeKeyboard", true);//支持中文输入
        des.setCapability("resetKeyboard", true);//支持中文输入
        des.setCapability("newCommandTimeout", "60");//没有新命令时的超时时间设置
        des.setCapability("nosign", true);//跳过检查和对应用进行 debug 签名的步骤

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), des);//虚拟机默认地址
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);//设置超时等待时间,默认9500ms

        driver.findElementByXPath("//*[@text=\"浙江\"]").click();


        readArticle();
//        localChannel();
//        share();


        try {
        } finally {
            driver.closeApp();
        }

//        new TouchAction(driver).press(PointOption.point(start_x, start_y))
//                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(Math.round(duration))))
//                .moveTo(PointOption.point(end_x, end_y)).release().perform();

//        滑动
//        PointOption startPoint = PointOption.point(928,541);
//        PointOption endPointPoint = PointOption.point(927,331);
//        WaitOptions waitOption = WaitOptions.waitOptions(Duration.ofMillis(100));
//        new TouchAction<>(driver).longPress(startPoint).waitAction(waitOption).moveTo(endPointPoint).release().perform();
    }

    /**
     * 分享
     */
    private void share() {
        for (int i = 2; i < 4; i++) {
            driver.findElementByXPath("//android.widget.ListView/android.widget.FrameLayout[" + i + "]/android.widget.LinearLayout[1]").click();
            sleep(1000);
            driver.findElementByXPath("//*[@resource-id=\"cn.xuexi.android:id/TOP_LAYER_VIEW_ID\"]/android.widget.ImageView[2]").click();
            sleep(1000);
            driver.findElementByXPath("//android.widget.GridView/android.widget.RelativeLayout[1]/android.widget.ImageView[1]").click();
            sleep(1000);
            driver.findElementByXPath("//*[@resource-id=\"cn.xuexi.android:id/session_item\"]").click();
            sleep(1000);
            AdbUtils.execute("shell input tap 804 1425");
            //分享成功
            driver.navigate().back();
        }
    }

    /**
     * 阅读文章
     */
    public void readArticle() {
        for (int y = 0; y < 3; y++) {
            for (int i = 2; i < 5; i++) {
                driver.findElementByXPath("//android.widget.ListView/android.widget.FrameLayout[" + i + "]/android.widget.LinearLayout[1]").click();
                for (int i1 = 0; i1 < 10; i1++) {
                    AdbUtils.execute("shell input swipe 500 541 500 331 200");
                    sleep(2000);
                }
                driver.navigate().back();
                sleep(1000);
            }
            AdbUtils.execute("shell input swipe 500 1874 500 260 1500");
        }
    }

    /**
     * 学习频道
     */
    public void localChannel() {
        driver.findElementByXPath("//android.support.v7.widget.RecyclerView/android.widget.LinearLayout[1]/android.widget.ImageView[1]").click();
        sleep(1000);
        driver.navigate().back();
    }

}