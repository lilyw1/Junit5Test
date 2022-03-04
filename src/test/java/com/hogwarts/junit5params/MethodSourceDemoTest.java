package com.hogwarts.junit5params;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

/**
 * @author wyl
 * @create 2022-01-19 22:24
 */
public class MethodSourceDemoTest {
    @ParameterizedTest

    //@MethodSource("stringProvider")
    @MethodSource

    void methodSourceDemo(String name){
        System.out.println(name);
    }

    static Stream<String> stringProvider(){
        return Stream.of("芒果","苹果");
    }

    static Stream<String> methodSourceDemo(){
        return Stream.of("香蕉","菠萝");
    }
}
