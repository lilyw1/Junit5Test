package com.ceshi.web;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * @author wyl
 * @create 2022-02-19 17:37
 */
public class WechatDemoTest {
    //yaml的序列化和反序列化
    @Test
    void loginTest() throws IOException, InterruptedException {
        WebDriver driver = new ChromeDriver();
        //隐式等待
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get("https://work.weixin.qq.com/wework_admin/frame");
        //等待15秒进行扫码
        Thread.sleep(15000);
        //将cookies信息保存下来
        Set<Cookie> cookies = driver.manage().getCookies();
        //System.out.println(cookies);
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        mapper.writeValue(new File("cookies.yaml"),cookies);
    }
    //解析cookies.yaml
    //注意cookies会过期
    @Test
    void loginedTest() throws IOException {
        WebDriver driver = new ChromeDriver();
        //隐式等待
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get("https://work.weixin.qq.com/wework_admin/frame");
        //反序列化
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        TypeReference typeReference = new TypeReference<List<HashMap<String,Object>>>(){};
        List<HashMap<String,Object>> cookies = (List<HashMap<String, Object>>) mapper.readValue(new File("cookies.yaml"),typeReference);
        System.out.println(cookies);
        cookies.forEach(cookieMap ->{
            driver.manage().addCookie(new Cookie(cookieMap.get("name").toString(),cookieMap.get("value").toString()));
        });
        driver.navigate().refresh();

    }
}
