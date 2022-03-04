package com.ceshiren.excercise.num;

import com.ceshiren.excercise.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author wyl
 * @create 2022-02-02 23:40
 */
@DisplayName("计算器减法测试用例")
public class SubTest extends BaseTest {

    @Test
    @DisplayName("2个数相减")
    void sub1Test(){
        result = calculator.subtract(90, 30);
        assertEquals(60,result,"2个数相减结果不正确");
    }

    @Test
    @DisplayName("3个数相减")
    void sub2Test(){
        result = calculator.subtract(10, 30,5);//100-10-30-5=55
        assertEquals(55,result,"3个数相减结果不正确");
    }


    @Test
    @DisplayName("2个数边界值的相减")
    void sub3Test(){
        //边界值判断
        result = calculator.subtract(100,-100);
        //System.out.println(result);
        //请输入范围内的整数！  e.getMessage()
        assertEquals(result,0);
    }
    @Test
    @DisplayName("3个数边界值的相减")
    void sub4Test(){
        //边界值判断
        Exception e = assertThrows(IllegalArgumentException.class, () -> calculator.subtract(102,100,100));
        //请输入范围内的整数！  e.getMessage()
        assertTrue(e.getMessage().contains("请输入范围内的整数！"));
    }
}
