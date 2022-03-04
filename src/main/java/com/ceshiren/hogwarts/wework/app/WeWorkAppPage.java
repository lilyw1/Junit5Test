package com.ceshiren.hogwarts.wework.app;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * @author wyl
 * @create 2022-02-27 14:39
 */
public class WeWorkAppPage {
    private final AppiumDriver driver;
    //构造器内初始化driver
    public WeWorkAppPage() throws MalformedURLException {

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName","Android");
        caps.setCapability("deviceName","127.0.0.1:7555");
        caps.setCapability("appPackage","com.tencent.wework");
        caps.setCapability("appActivity",".launch.WwMainActivity");
        caps.setCapability("noReset","true");

        driver = new AppiumDriver(new URL("http://127.0.0.1:4723/wd/hub"),caps);
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    }
    //点击通讯录，跳转到通讯录界面
    public ContactAppPage toContact() throws Exception {
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        //driver.findElement(By.xpath("//*[@text = '通讯录']")).click();
        //转换成Uiautomator,速度更快
        //driver.findElement(By.id("com.tencent.wework:id/fz4")).click();
        driver.findElement(By.cssSelector("*[text = 通讯录]")).click();

        return new ContactAppPage(driver);
    }

    public void close() {
        //driver.quit();
    }
}
