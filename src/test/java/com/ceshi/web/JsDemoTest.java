package com.ceshi.web;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.JavascriptExecutor;

/**
 * @author wyl
 * @create 2022-02-17 20:38
 */
public class JsDemoTest extends BaseTest{

    @Test
    //@Timeout(value = 1,TimeUnit.unit = TimeUnit.SECONDS)
    public void jsTest(){
        try {
            driver.get("https://www.12306.cn/index/");
            JavascriptExecutor jsDriver = (JavascriptExecutor) driver;
            //使用JS修改出发日期为2022-03-01
            jsDriver.executeScript("document.getElementById('train_date').value = '2022-03-01'");
            Thread.sleep(3000);
            //打印出发日期
            System.out.println(jsDriver.executeScript("return document.getElementById('train_date').value"));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
