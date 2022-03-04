package com.hogwarts.junit5appium;

/**
 * @author wyl
 * @create 2022-02-23 22:30
 */
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class AppiumDemoTest {

    private static AndroidDriver driver;

    @BeforeAll
    public static void setUp()  {
        try {
            DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
            desiredCapabilities.setCapability("platformName", "android");
            desiredCapabilities.setCapability("deviceName", "emulator-5554");
            desiredCapabilities.setCapability("appPackage", "io.appium.android.apis");
            desiredCapabilities.setCapability("appActivity", "io.appium.android.apis.ApiDemos");
            desiredCapabilities.setCapability("automationName", "UiAutomator2");

            URL remoteUrl = new URL("http://127.0.0.1:4723/wd/hub");

            driver = new AndroidDriver(remoteUrl, desiredCapabilities);
        }catch ( MalformedURLException e){
            e.printStackTrace();
        }
    }

    @Test
    public void sampleTest() {
        MobileElement el1 = (MobileElement) this.driver.findElementByAccessibilityId("OS");
        el1.click();
        MobileElement el2 = (MobileElement) driver.findElementByAccessibilityId("SMS Messaging");
        el2.click();
        MobileElement el3 = (MobileElement) driver.findElementById("io.appium.android.apis:id/sms_recipient");
        el3.sendKeys("18111111111");
        MobileElement el4 = (MobileElement) driver.findElementById("io.appium.android.apis:id/sms_content");
        el4.sendKeys("hogwarts");
        MobileElement el5 = (MobileElement) driver.findElementByAccessibilityId("Send");
        el5.click();
    }

    @AfterAll
    public static void tearDown() {
        driver.quit();
    }
}
