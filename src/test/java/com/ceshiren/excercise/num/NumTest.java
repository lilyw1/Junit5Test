package com.ceshiren.excercise.num;

import com.ceshiren.Calculator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author wyl
 * @create 2022-02-13 14:24
 */
public class NumTest {
    public static Calculator calculator;

    @ParameterizedTest(name = "{0} + {1} = {2}/{0} - {1} = {3}/")
    @MethodSource()
    @DisplayName("两数相加/相减")
    void sumTest1(int a,int b,int res1,int res2){
        calculator = new Calculator("加法减法测试");

        //对应测试代码
        int result1 = calculator.sum(a,b);
        //assertEquals(res1,result1,"2个数相加的结果不正确");
        //断言出错不会再执行后面的减法,但仅会影响第一个循环，后续循环还会执行
        int result2 = calculator.subtract(a,b);
        //assertEquals(res2,result2,"2个数相减的结果不正确");

        //集中断言
        assertAll("加减法assertall断言",
            ()-> assertEquals(res1,result1,"2个数相加的结果不正确"),
            //()-> assertEquals(res2,result2,"2个数相减的结果不正确"),
            //harmcrest
            ()-> assertThat("2个数相减的结果不正确",res2,equalTo(result2))

        );

    }

    //参数源
    static Stream<Arguments> sumTest1() {
        return Stream.of(
                Arguments.arguments(11, 22, 32, -10),
                Arguments.arguments(21, 28, 49, -7),
                Arguments.arguments(40, 41, 81, -1)
        );
    }

}
