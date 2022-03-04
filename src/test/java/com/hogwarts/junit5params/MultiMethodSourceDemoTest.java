package com.hogwarts.junit5params;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

/**
 * @author wyl
 * @create 2022-01-19 22:24
 */
public class MultiMethodSourceDemoTest {
    @ParameterizedTest

    @MethodSource

    void methodSourceDemo(String name,int weight){
        System.out.println(name+"的重量是："+ weight+"斤");
    }

    static Stream<Arguments> methodSourceDemo(){
        return Stream.of(
                Arguments.arguments("香蕉",2),
                Arguments.arguments("菠萝",1)
        );
    }
}
