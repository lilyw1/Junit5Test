package com.ceshiren.excercise.num;

import com.ceshiren.excercise.BaseTest;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;


/**
 * @author wyl
 * @create 2022-01-23 16:02
 * 根据需求编写对应的测试用例：加法，减法，string拼接
 * 第一步：打开计算器
 * 在每个测试方法之前生成运行的唯一ID标识
 * 在每个测试方法之前log打印：开始进行计算
 * 在测试方法得到结果后log打印：计算结果:result
 * 在每个测试方法之后进行销毁ID操作
 * 在调用完所有测试用例后执行关闭计算器app操作
 * 注意:warning:：
 * 每个测试用例都要添加断言，验证结果
 * 灵活使用测试装置
 * 边界值要进行验证
 */
@DisplayName("计算器加法测试用例")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
//指定方法运行顺序
public class SumTest extends BaseTest {

    //@Test
    //注意：参数化的时候Test注解去掉，换成ParameterizedTest
    //自定义参数化显示名 name   "[{index}] {argumentsWithNames}"
    //[{index}]  [1]  [2]   [3]
    //argumentsWithNames 相当于一个数组 直接拿取下标即可，下标从0开始
    //这个是方法上的注解  ParameterizedTest + MethodSource
    @ParameterizedTest(name = "{0} + {1} = {2}")
    //每个测试用例更改名称,否则以参数值为名称
    //@ParameterizedTest()
    @MethodSource()
    @DisplayName("两数相加")
    @Order(1)
    void sumTest1(int a,int b,int res){
        //对应测试代码
        result = calculator.sum(a,b);
        assertEquals(res,result,"2个数相加的结果不正确");
    }
//参数源
    static Stream<Arguments> sumTest1() {
        return Stream.of(
                Arguments.arguments(11, 22, 33),
                Arguments.arguments(21, 28, 49),
                Arguments.arguments(40, 41, 81)
        );
    }

    @Test
    @DisplayName("三数相加")
    @Order(4)
    void sumTest2(){
        //对应测试代码
        int result = calculator.sum(1,1,1);
        assertEquals(3,result,"3个数相加的结果不正确");
    }

    @Test
    @DisplayName("2个数边界值的相加")
    @Order(3)
    void sumTest3(){
        //边界值判断
        Exception e = assertThrows(IllegalArgumentException.class, () -> calculator.sum(100, 99));
        //请输入范围内的整数！  e.getMessage()
        assertTrue(e.getMessage().contains("请输入范围内的整数！"));
    }


}
