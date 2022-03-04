package com.ceshi.web;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

/**
 * @author wyl
 * @create 2022-02-17 21:32
 */
public class FileUploadTest extends BaseTest{
    @Test
    public void fileTest() throws InterruptedException {
        driver.get("https://www.baidu.com");
        driver.findElement(By.xpath("//span[@class='soutu-btn']")).click();
        Thread.sleep(2000);
        //使用send.keys对于input类型标签框进行输入
        driver.findElement(By.xpath("//input[@class='upload-pic']")).sendKeys("E:\\desktop\\简历\\1.jpg");
        Thread.sleep(5000);
    }
}
