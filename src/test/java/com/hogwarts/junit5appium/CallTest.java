package com.hogwarts.junit5appium;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.GsmCallActions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * @author wyl
 * @create 2022-03-02 22:33
 */
public class CallTest {
    public static AndroidDriver driver;

    @BeforeAll
    public static void setUp() throws Exception {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "Android");
        caps.setCapability("deviceName", "emulator-5554");

        driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), caps);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @Test
    public void callTest() throws InterruptedException {
        //电话
        driver.makeGsmCall("5411234555", GsmCallActions.CALL);
        Thread.sleep(1000);
        //发送短信
        driver.sendSMS("541-123-4555","appium test2");
    }

}
