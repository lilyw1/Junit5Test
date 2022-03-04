package com.ceshi.web;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

/**
 * @author wyl
 * @create 2022-02-16 22:02
 */
public class BaseTest {
    public static WebDriver driver;
    public static String browserName;

    @BeforeAll
    public static void initData(){
        //String browserName= System.getenv("browser");
        browserName = "chrome";
        if(browserName.equals("chrome")){
            //System.setProperty("webdriver.chrome.driver","Users/naruto0728/Downloads/chromedriver");
            driver=new ChromeDriver();
        }else if(browserName.equals("firefox")){
            //System.setProperty("webdriver.gecko.driver","Users/naruto0728/Downloads/geckodriver");
            driver=new FirefoxDriver();
        }
        //添加隐式等待3s。等待页面渲染结束，加载出被定位元素
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }


    @AfterAll
    public static void tearDown(){
        driver.quit();
    }
}
