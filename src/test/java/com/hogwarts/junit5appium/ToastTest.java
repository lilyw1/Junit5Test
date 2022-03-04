package com.hogwarts.junit5appium;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * @author wyl
 * @create 2022-02-26 23:34
 */
public class ToastTest {
    @Test
    public void toastTest() throws Exception {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "Android");
        //caps.setCapability("udid", "127.0.0.1:7555");
        caps.setCapability("deviceName", "127.0.0.1:7555");
        caps.setCapability("appPackage", "io.appium.android.apis");
        caps.setCapability("appActivity", "io.appium.android.apis.view.PopupMenu1");
        caps.setCapability ("noReset", "true");
        AndroidDriver driver = new AndroidDriver(new URL("http://ocalhost:4723/wd/hub"), caps);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(MobileBy.AccessibilityId("Make a Popup!")).click();
        driver.findElement(By.xpath("//*[@text='Search']")).click();
        //通过getPageSource是无法找到的toast
        System.out.println(driver.getPageSource());
        System.out.println(driver.findElement(By.xpath("//*[@class=android.widget.Toast']")).getText());
    }
}
