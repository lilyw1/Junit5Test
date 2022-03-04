package com.ceshi.web;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

/**
 * @author wyl
 * @create 2022-02-15 22:46
 */
public class ActionsDemoTest {
    public static WebDriver webDriver;
    public static Actions actions;

    @BeforeAll
    public static void initData(){
        //webDriver = new ChromeDriver();
        webDriver = new FirefoxDriver();
        actions = new Actions(webDriver);
        //添加隐式等待5s。等待页面渲染结束，加载出被定位元素
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    //1.鼠标点击操作
    @Test
    public void clickTest(){
        try {
            webDriver.get("http://sahitest.com/demo/clicks.htm");
            actions.click(webDriver.findElement(By.xpath("//input[@value='click me']")));
            actions.doubleClick(webDriver.findElement(By.xpath("//input[@value='dbl click me']")));
            //右键点击
            actions.contextClick(webDriver.findElement(By.xpath("//input[@value='right click me']")));
            actions.perform();
            Thread.sleep(3000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //2.鼠标移动到某个元素上
    @Test
    public void moveTest(){
        try {
            webDriver.get("https://www.baidu.com");
            actions.moveToElement(webDriver.findElement(By.id("s-usersetting-top"))).perform();
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    //3.将一个元素拖拽到另一个元素的位置上
    @Test
    public void dragTest() {
        try {
            webDriver.get("http://sahitest.com/demo/dragDropMooTools.htm");
            WebElement source=webDriver.findElement(By.id("dragger"));
            WebElement tag=webDriver.findElement(By.xpath("//*[@class='item'][2]"));
            actions.dragAndDrop(source,tag).perform();
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    @Test
    //键盘输入和复制,需要使用火狐浏览器
    public void keyBordTest() {

        try {
            webDriver.get("http://sahitest.com/demo/label.htm");

            WebElement uname1 = webDriver.findElements(By.xpath("//input[@type='textbox']")).get(0);
            WebElement uname2 = webDriver.findElements(By.xpath("//input[@type='textbox']")).get(1);

            uname1.sendKeys("admin");

            actions.keyDown(uname1, Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).perform();
            actions.keyDown(uname1,Keys.CONTROL).sendKeys("c").keyUp(Keys.CONTROL).perform();

            actions.keyDown(uname2,Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).perform();
            Thread.sleep(5000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //JS滑动到底部
    @Test
    public void slideTest(){
        try {
            webDriver.get("https://www.baidu.com");

            webDriver.findElement(By.id("kw")).sendKeys("霍格沃兹测试学院");

//            TouchActions action = new TouchActions(webDriver);
//            action.click(webDriver.findElement(By.id("su")));
            webDriver.findElement(By.id("su")).click();

            //滑动到底部
            JavascriptExecutor js = (JavascriptExecutor) webDriver;
            js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
            
            Thread.sleep(3000);

            webDriver.findElement(By.xpath("//*[@id='page']//a[last()]")).click();
            Thread.sleep(5000);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @AfterAll
    public static void tearDown(){
        //关闭浏览器
        webDriver.quit();
    }
}
