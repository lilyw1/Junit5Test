package com.hogwarts.junit5appium;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

/**
 * @author wyl
 * @create 2022-03-01 21:46
 */
public class WebviewDemoTest extends BasedTest{
    @Test
    //原生定位
    public void webview_native(){
        driver.findElement(By.xpath("//*[@text='交易']"));
        //出现元素之后
        driver.findElement(By.xpath("//*[@text='交易']")).click();
        driver.findElement(By.xpath("//*[@text='基金开户']")).click();

    }
}
