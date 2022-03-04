package com.hogwarts.junit5tags;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

/**
 * @author wyl
 * @create 2022-01-20 22:58

使用mvn clean test命令行语句进行标签执行
在pom.xml中指定标签执行规则
<!-- 要执行的标签 -->
<!--                    <groups>test</groups>-->
<!-- 不要执行的标签 -->
<!--                    <excludedGroups>preprod&amp;dev</excludedGroups>-->
 */
public class TagsDemoTest {
    @Tag("test")//打标签
    @Test
    void test1(){
        System.out.println("测试环境");
    }


    @Tag("dev")//打标签
    @Test
    void test2(){
        System.out.println("开发环境");
    }

    @Tag("preprod")//打标签
    @Test
    void test3(){
        System.out.println("预生产环境");
    }

    @Tag("preprod")//打标签
    @Tag("dev")
    @Test
    void test4(){
        System.out.println("预生产和开发环境");
    }

    @PreprodTest//自定义标签
    void test5(){
        System.out.println("自定义标签");
    }

}
