package com.hogwarts.junit5basics;

/**
 * @author wyl
 * @create 2022-01-17 23:55
 */
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class FirstJunitTest {
    //所有的测试用例均需要添加@test注解
    //也可在项目目录下：输入 mvn test执行所有测试用例
    @Test
    @DisplayName("first的别名：第一")
    void first(){
        System.out.println("第一个Junit5测试用例");
    }

    @Test
     void second(){
        System.out.println("第二个Junit5测试用例");
    }
}
