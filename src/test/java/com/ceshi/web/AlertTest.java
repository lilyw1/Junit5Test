package com.ceshi.web;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

/**
 * @author wyl
 * @create 2022-02-17 21:13
 */
public class AlertTest extends BaseTest{
    @Test
    public void alertTest(){
        try {
            driver.get("https://www.runoob.com/try/try.php?filename=jqueryui-api-droppable");
            //切换Frame
            driver.switchTo().frame("iframeResult");
            //actions实现拖拽
            Actions actions = new Actions(driver);
            actions.dragAndDrop(driver.findElement(By.id("draggable")),driver.findElement(By.id("droppable"))).perform();
            Thread.sleep(3000);
            //输出弹出内容
            System.out.println(driver.switchTo().alert().getText());
            //弹窗同意
            driver.switchTo().alert().accept();
            //切回Frame
            driver.switchTo().parentFrame();

            System.out.println(driver.findElement(By.id("submitBTN")).getText());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
