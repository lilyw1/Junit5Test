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
public class FrameDemoTest {
    public static WebDriver driver;

    @BeforeAll
    public static void initData(){
        driver = new ChromeDriver();
        //添加隐式等待5s。等待页面渲染结束，加载出被定位元素
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    //切换frame框架
    @Test
    public void frameTest()  {
        //登录百度页面
        driver.get("https://www.runoob.com/try/try.php?filename=jqueryui-api-droppable");
        //切换frame
        driver.switchTo().frame("iframeResult");
        System.out.println(driver.findElement(By.id("draggable")).getText());//请拖拽我！

        //切回默认frame
        //driver.switchTo().defaultContent();
        driver.switchTo().parentFrame();
        System.out.println(driver.findElement(By.id("submitBTN")).getText());//点击运行 》
    }

    @AfterAll
    public static void tearDown(){
        //关闭浏览器
        driver.quit();
    }
}
