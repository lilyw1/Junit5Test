package com.hogwarts.junit5params;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.NullSource;

/**
 * @author wyl
 * @create 2022-01-19 23:12
 */
public class NullAndEmptySourceDemoTest {
    @ParameterizedTest
    @EmptySource
    void emptySourceDemo(String param){
        System.out.println("param = " + param);
    }

    @ParameterizedTest
    @NullSource
    void nullSourceDemo(String param){
        System.out.println("param = " + param);
    }

    @ParameterizedTest
    @NullAndEmptySource//null和空两个输入
    void nullAndEmptySourceDemo(String param){
        System.out.println("param = " + param);
    }

}
