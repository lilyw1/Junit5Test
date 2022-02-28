package com.ceshiren.hogwarts.wework.app;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * selenium相关类封装,其他类中不在出现selenium相关库
 * @author wyl
 * @create 2022-02-27 15:36
 */
public class BaseAppPage {
    AppiumDriver driver;
    By currentBy;
    WebElement currentElement;

    public BaseAppPage(AppiumDriver driver) {
        this.driver = driver;
    }
    //id定位时，部分id经过混淆会变成随机id
    public String getIdFromOriginId(String originId) {
        String randomId = "";
        return randomId;
    }
    //click和sendkeys封装

    //异常，无法定位元素时
    public BaseAppPage find(By by)throws Exception{
        try{
            currentElement = driver.findElement(by);
        }catch (Exception e){
            handleExceptions();
            //使用递归解决多次异常处理问题
            //直到找到currentElement
            find(by);
        }
        return this;
    }
    //无strategy时，默认css定位
    public BaseAppPage find(String selector)throws Exception{
        find(selector,"css");
        return this;
    }
    public BaseAppPage find(String selector,String strategy)throws Exception{
        By by;
        if(strategy.equals("id")){
            by = By.id(selector);
        }else if(strategy.equals("css")){
            by = By.cssSelector(selector);
        }else{
            throw new Exception("unknown");
        }
        return this;
    }

    //广告等弹窗导致元素无法点击等异常处理，
    public void click() {
        try {
            currentElement.click();
        } catch (Exception e) {
            handleExceptions();
            //递归思想，点击直到元素出现
            click();
        }
    }
    public void click(By by) throws Exception{

        try {
            find(by).click();
        }catch (Exception e){
            click(by);
        }
    }
    public void click(String selector) throws Exception {
        find(selector).click();
    }
    public void click(String selector, String strategy) throws Exception {
        find(selector,strategy).click();
    }
    public void sendKeys(String text) throws Exception {
        //driver.findElement(by).sendKeys(text);
        currentElement.sendKeys(text);
    }
    public void sendKeys(By by,String text) throws Exception {
        currentBy = by;
        //driver.findElement(by).sendKeys(text);
        find(by).sendKeys(text);
    }
    public String getAttribute(String name){
        return currentElement.getAttribute(name);
    }
    public String getText(){
        return currentElement.getText();
    }
    public void back(){
        driver.navigate().back();
    }
    //异常情况处理
    public void handleExceptions(){
        //todo: 解决弹框和各种异常
        //异常类型
        //1. 行为异常，重试机制可也解决
        //2. po实现，重试机制通常效果不大
        //3. 全流程与环境异常 直接fail并自动启动下次执行

    }

}
