package com.hogwarts.junit5disable;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

/**
 * @author wyl
 * @create 2022-01-23 13:38
 */
@Disabled("禁用此测试类，maven执行才生效")
//禁用测试类，里面可添加标识即相关描述，直接执行不会打印，会显示在报告里
public class DisableClassDemoTest {
    @Test
    void hogwarts1(){
        System.out.println("禁用测试类测试用例1");
    }
    @Test
    void hogwarts2(){
        System.out.println("禁用测试类测试用例2");
    }
}
