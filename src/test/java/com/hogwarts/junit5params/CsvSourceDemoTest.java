package com.hogwarts.junit5params;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * @author wyl
 * @create 2022-01-19 21:44
 */
public class CsvSourceDemoTest {
    //声明为参数化的测试类
    @ParameterizedTest
    //传递测试数据
    //调用CsvSource传递参数化数据内容
    @CsvSource({"张三,2","李四,3","王五,4"})
    void valueSourceDemo1(String name,int age){
        System.out.println(name+"的年龄是："+age+"岁。");
    }

    @ParameterizedTest
    //使用delimiterString指定分隔符，使用value传递内容
    @CsvSource(value = {"张三-2","李四-3","王五-4"},delimiterString = "-")
    void valueSourceDemo2(String name,int age){
        System.out.println(name+"的年龄是："+age+"岁。");
    }

}
