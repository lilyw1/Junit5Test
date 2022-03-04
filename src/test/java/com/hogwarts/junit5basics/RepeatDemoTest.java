package com.hogwarts.junit5basics;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

/**
 * @author wyl
 * @create 2022-01-20 22:31
 */
public class RepeatDemoTest {
    //使用@RepeatedTest设置重复测试次数
    //支持自定义输出
    //@RepeatedTest(2)注解内需要传递控制重复次数的参数
    //@Test 如果要使用重复测试，就可以不使用@Test

     @RepeatedTest(value = 3, name = "{displayName}--{currentRepetition}/{totalRepetitions}")
    //{}内为变量，中间可以加任意字符
    // value 表示要重复几次
    // displayName 对应执行用例的displayname
    // currentRepetition 第几次重复
    // totalRepetitions 代表总共要重复的次数

    @DisplayName("HogwartsSchool")
    void hogwarts(){
        System.out.println("恭喜发财");
    }
}
