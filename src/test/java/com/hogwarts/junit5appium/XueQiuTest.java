package com.hogwarts.junit5appium;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;

/**
 * @author wyl
 * @create 2022-02-24 22:44
 */
public class XueQiuTest extends BasedTest{

//利用xpath定位输出阿里巴巴香港股票的价格
    @Test
    public void helloSnowBallTest() {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        //定位首页搜索框
        driver.findElement(By.id("com.xueqiu.android:id/tv_search")).click();
        //定位搜索页搜索框
        driver.findElement(By.id("com.xueqiu.android:id/search_input_text")).sendKeys("阿里巴巴");

        //driver.findElement(By.xpath("//*[@text='BABA']")).click();

        driver.findElement(By.xpath("//*[@text='股票']")).click();
        String realPrice = driver.findElement(By.xpath("//*[@text='09988']/../../..//*[@resource-id='com.xueqiu.android:id/current_price']")).getText();
        //打印09988股价
        System.out.println(realPrice);
        //harmcrest断言
        assertThat("股票价格的对比",Double.parseDouble(realPrice),greaterThan(200d));
    }

    //使用uiautomator定位
    @Test
    public void scrollTest() throws InterruptedException {
        //强转成AndroidDriver类型
        AndroidDriver<MobileElement> driver = (AndroidDriver<MobileElement>) this.driver;
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        //点击热门,通过resource-id定位
        //先定位父元素，通过父元素找儿子
        driver.findElementByAndroidUIAutomator("new UiSelector().resourceId(\"com.xueqiu.android:id/scroll_view\").childSelector(text(\"热门\"));").click();
        Thread.sleep(5000);
        //滑动定位
        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"雪球路演\").instance(0));").click();

    }




}
