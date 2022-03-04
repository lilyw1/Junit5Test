package com.ceshi.wework.web.exercise;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

/**
 * @author wyl
 * @create 2022-02-20 14:12
 */
public class WeWorkAuthTest {
    private static WebDriver driver;
    private final ObjectMapper mapper = new ObjectMapper(new YAMLFactory());

    @BeforeAll
    public static void beforeAll(){
        driver = new ChromeDriver();
        driver.get("https://work.weixin.qq.com/wework_admin/frame#index");
    }

    @Test
    void saveCookies() throws IOException {
        //扫码过程
        String url = driver.getCurrentUrl();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1000).getSeconds());
        wait.until(webDriver->!webDriver.getCurrentUrl().equals(url));
        Set<Cookie> cookies = driver.manage().getCookies();
        mapper.writeValue(new File("cookies.yaml"),cookies);
    }
    @Test
    void loadCookies() throws IOException {
        TypeReference<List<HashMap<String,Object>>> typeReference = new TypeReference<>() {};
        List<HashMap<String,Object>> cookies = mapper.readValue(new File("cookies.yaml"),typeReference);
        cookies.stream()
                //过滤出域名为work.weixin.qq.com的
                //过滤企业微信的cookie
                .filter(cookie ->cookie.get("domain").toString().contains("work.weixin.qq.com"))
                .forEach(cookie ->{
                 //写cookie到浏览器
                driver.manage().addCookie(new Cookie(cookie.get("name").toString(),cookie.get("value").toString()));
    });
    //刷新的时候，浏览器会把新的cookie带到服务器，服务器返回登录后的页面
     driver.navigate().refresh();
    }
}
