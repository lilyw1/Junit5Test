package com.hogwarts.junit5appium;

import io.appium.java_client.android.AndroidDriver;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * @author wyl
 * @create 2022-02-24 22:41
 */
public class BasedTest {
    static AndroidDriver driver;

    @BeforeAll
    public static void setUp()  {
        try {
            DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
            desiredCapabilities.setCapability("platformName", "android");
            desiredCapabilities.setCapability("deviceName", "127.0.0.1:7555");
            desiredCapabilities.setCapability("appPackage", "com.xueqiu.android");
            desiredCapabilities.setCapability("appActivity", ".common.MainActivity");
            desiredCapabilities.setCapability("automationName", "UiAutomator2");
            desiredCapabilities.setCapability("noReset","true");
            URL remoteUrl = new URL("http://127.0.0.1:4723/wd/hub");

            driver = new AndroidDriver(remoteUrl, desiredCapabilities);
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        }catch ( MalformedURLException e){
            e.printStackTrace();
        }
    }

    @AfterAll
    public static void tearDown() throws InterruptedException {
        Thread.sleep(10000);
        driver.quit();
    }

}
