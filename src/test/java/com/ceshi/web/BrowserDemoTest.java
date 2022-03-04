package com.ceshi.web;

import org.junit.jupiter.api.Test;

/**
 * @author wyl
 * @create 2022-02-16 22:03
 */
public class BrowserDemoTest extends BaseTest {
    @Test
    public void fun(){

        driver.get("https://home.testing-studio.com");
    }
}
