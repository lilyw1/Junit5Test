package com.hogwarts.junit5allure;

import io.qameta.allure.Allure;
import io.qameta.allure.Link;
import io.qameta.allure.Links;
import org.junit.jupiter.api.Test;

/**
 * @author wyl
 * @create 2022-02-04 22:52
 */
public class AllureLinkTest {
    @Test
    //添加静态链接
    @Link(name = "静态链接", url = "https://ceshiren.com")
    //添加多个静态链接
    @Links({@Link(name = "静态链接1",value = "https://ceshiren.com"),
            @Link(name = "静态链接2",value = "https://baidu.com")})
    public void staticLinkTest() {
        assert 1 + 1 == 2;
    }
    @Test
    public void dynamicLinkTest() {
        assert 1 + 1 == 2;
        //添加动态链接
        Allure.link("Dynamic link", "https://ceshiren.com");
    }
}
