package com.ceshi.web;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author wyl
 * @create 2022-02-14 21:45
 */
public class SeleniumDemoTest {
    public static WebDriver webDriver;
    public static WebDriverWait wait;
    @BeforeAll
    public static void initData(){
        webDriver = new ChromeDriver();
        //添加隐式等待5s。等待页面渲染结束，加载出被定位元素
        //webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        //显示等待，实例化
        wait = new WebDriverWait(webDriver, 5);
    }
    @Test
    public void waitTest() {
        webDriver.get("https://ceshiren.com/");
        //显示等待，第一种官网。匿名内部类
        WebElement loginEle = wait.until(new ExpectedCondition<WebElement>(){
            public WebElement apply(WebDriver webDriver){
                return webDriver.findElement(By.xpath("//span[contains(text(),'登录')]"));
            }
        });
        loginEle.click();
        //第二种写法
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[contains(text(),'登录')]")));
        element.click();
    }

    @Test
    public void timeSleepTest() {
        webDriver.get("https://ceshiren.com/");
        //直接等待
        try {
            Thread.sleep(5000);
            webDriver.findElement(By.xpath("//span[contains(text(),'登录')]")).click();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void loginTest(){
        webDriver.get("https://ceshiren.com/");
        //xpath登录
        //webDriver.findElement(By.xpath("//*[@id=\"ember7\"]/header/div/div/div[2]/span/button[2]/span")).click();
        webDriver.findElement(By.xpath("//span[contains(text(),'登录')]")).click();
        //清空用户名，之后输入用户名
        webDriver.findElement(By.id("login-account-name")).clear();
        webDriver.findElement(By.id("login-account-name")).sendKeys("www1");
        //清空密码，之后输入密码
        webDriver.findElement(By.id("login-account-password")).clear();
        webDriver.findElement(By.id("login-account-password")).sendKeys("tp123456");
        //点击登录login-button
        webDriver.findElement(By.id("login-button")).click();
    }
    @AfterAll
    public static void tearDown(){
        //关闭浏览器
        webDriver.quit();
    }
}
