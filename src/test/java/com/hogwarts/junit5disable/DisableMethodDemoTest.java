package com.hogwarts.junit5disable;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

/**
 * @author wyl
 * @create 2022-01-23 13:38
 */

public class DisableMethodDemoTest {
    @Disabled("此方法被禁用")
    @Test
    void hogwarts1(){
        System.out.println("禁用测试类测试用例1");
    }
    @Test
    void hogwarts2(){
        System.out.println("禁用测试类测试用例2");
    }
}
