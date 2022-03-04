package com.hogwarts.junit5allure;

import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import org.junit.jupiter.api.Test;

/**
 * @author wyl
 * @create 2022-02-04 22:44
 */
public class AllureDescriptionTest {

    @Test
    @Description("静态描述信息")
    public void annotationDescriptionTest() {
        Allure.description("动态描述信息1");
    }

    @Test
    public void dynamicDescriptionTest() {
        Allure.description("动态描述信息");
    }
}