package com.hogwarts.junit5params;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

/**
 * @author wyl
 * @create 2022-01-19 21:44
 */
public class ValueSourceDemoTest {
    //声明为参数化的测试类
    @ParameterizedTest
    //传递测试数据
    //调用Valuesource传递参数化数据内容
    @ValueSource(strings = {"张三","李四","王五"})
    void valueSourceDemo(String name){
        System.out.println(name);
    }

}
