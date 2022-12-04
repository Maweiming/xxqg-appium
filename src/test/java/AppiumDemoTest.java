/**
 * fshows.com
 * Copyright (C) 2013-2020 All Rights Reserved.
 */

import io.appium.java_client.android.AndroidDriver;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
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

        AdbTest.execute("uninstall com.github.uiautomator");
        AdbTest.execute("uninstall com.github.uiautomator2");
        AdbTest.execute("uninstall com.github.uiautomator.test");
//
//        ChromeOptions options = new ChromeOptions();
//        options.setExperimentalOption("androidPackage","com.shouzhan.newfubei.activity.ordering.owner.OwnerOrderingActivity");
//        options.setExperimentalOption("androidUseRunningApp",true);
//        options.setExperimentalOption("androidProcess","com.shouzhan.newfubei.activity.ordering.owner.OwnerOrderingActivity");
////

        DesiredCapabilities des = new DesiredCapabilities();
        des.setCapability("platformName", "Android");//平台名称
        des.setCapability("platformVersion", "10");//手机操作系统版本
        des.setCapability("udid", "172.16.21.78:5555");//连接的物理设备的唯一设备标识
        des.setCapability("deviceName", "172.16.21.78:5555");//使用的手机类型或模拟器类型  UDID
        des.setCapability("unicodeKeyboard", true);//支持中文输入
        des.setCapability("resetKeyboard", true);//支持中文输入
        des.setCapability("newCommandTimeout", "60");//没有新命令时的超时时间设置
        des.setCapability("nosign", true);//跳过检查和对应用进行 debug 签名的步骤
        des.setCapability("chromedriverExecutable", "/Users/coderma/Downloads/chromedriver");


        try {
            driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), des);//虚拟机默认地址
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);//设置超时等待时间,默认9500ms

//        for (WebElement webElement : elementByXPath) {
        try {

//            driver.findElementByXPath("//*[@text=\"筛选\"]").click();

//            ThreadUtil.sleep(1000*5);

            WebElement elementByXPath = driver.findElementByXPath("//*[@resource-id=\"app\"]/android.view.View[2]/android.view.View[1]/android.view.View[1]/android.view.View[2]");
            System.out.println(elementByXPath.getAttribute("text"));
            System.out.println(elementByXPath.getText());
            System.out.println(elementByXPath.getTagName());
            System.out.println(elementByXPath.getLocation());
            System.out.println(elementByXPath.getRect().getDimension());

            List<WebElement> elementsByClassName = driver.findElementByClassName("android.view.View").findElement(By.className("android.view.View")).findElements(By.className("android.view.View"));
//            List<WebElement> elementsByClassName = driver.findElementsByClassName("android.view.View");
            for (WebElement webElement : elementsByClassName) {
                System.out.println(webElement.getText());
                System.out.println(webElement.getAttribute("text"));
            }
//            driver.findElementByClassName("header-action").click();


            System.out.println(driver.findElementByClassName("android.webkit.WebView").getText());
            System.out.println(driver.findElementByClassName("com.uc.webkit.bb").getText());
            System.out.println(driver.findElementByClassName("com.uc.webview.export.WebView").getText());

        } catch (Exception e) {

        }

        driver.closeApp();
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
            AdbTest.execute("shell input tap 804 1425");
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
                    AdbTest.execute("shell input swipe 500 541 500 331 200");
                    sleep(2000);
                }
                driver.navigate().back();
                sleep(1000);
            }
            AdbTest.execute("shell input swipe 500 1874 500 260 1500");
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