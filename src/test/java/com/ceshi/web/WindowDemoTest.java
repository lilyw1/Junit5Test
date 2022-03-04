package com.ceshi.web;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

/**
 * @author wyl
 * @create 2022-02-16 21:09
 */
public class WindowDemoTest {
    public static WebDriver driver;

    @BeforeAll
    public static void initData(){
        driver = new ChromeDriver();
        //添加隐式等待5s。等待页面渲染结束，加载出被定位元素
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    //切换窗口
    @Test
    public void switchWindowTest() throws InterruptedException {
        //登录百度页面
        driver.get("https://www.baidu.com");
        //最大化窗口
        driver.manage().window().maximize();
        //点击登录
        driver.findElement(By.id("s-top-loginbtn")).click();
        //获取当前句柄
        String windowHandle = driver.getWindowHandle();
        //点击立即注册，跳转到另一个页面
        driver.findElement(By.id("TANGRAM__PSP_11__regLink")).click();
        //判断句柄
        for(String win:driver.getWindowHandles()){
            if(!win.equals(windowHandle)){
                driver.switchTo().window(win);
                driver.findElement(By.id("TANGRAM__PSP_4__userName")).sendKeys("www");
                driver.findElement(By.id("TANGRAM__PSP_4__phone")).sendKeys("18069866711");

                driver.switchTo().window(windowHandle);
                driver.findElement(By.id("TANGRAM__PSP_11__userName")).sendKeys("www");
                driver.findElement(By.id("TANGRAM__PSP_11__password")).sendKeys("18069866711");

                Thread.sleep(3000);
            }
        }
    }

    @AfterAll
    public static void tearDown(){
        //关闭浏览器
        driver.quit();
    }
}
