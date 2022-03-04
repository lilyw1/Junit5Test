package com.hogwarts.junit5assert;

import com.ceshiren.Calculator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author wyl
 * @create 2022-01-25 22:49
 */
public class AssertDemoTest {
    static Calculator calculator = new Calculator("计算器");

    @Test
    //这种断言方式，第一个断言失败，不会再去判断第个断言
    void test1() throws InterruptedException{

        System.out.println("这是第一个断言");
        int sum1=calculator.sum(1,5);
        assertEquals(4,sum1);

        System.out.println("这是第二个断言");
        int sum2=calculator.sum(4,5);
        assertEquals(6,4+5);


    }
    @Test
    void test2() throws InterruptedException{

        int sum1=calculator.sum(1,5);
        int sum2=calculator.sum(4,5);
        //直接在assertAll里面使用lambda表达式
        assertAll(
                ()->{System.out.println("这是第一个断言");
                    assertEquals(4,sum1);
                    },
                ()->{ System.out.println("这是第二个断言");
                    assertEquals(6,sum2);
                    }
        );
    }

    @Test
    void test3() throws InterruptedException{
        ArrayList<Executable> executables = new ArrayList<>();
        int sum1=calculator.sum(1,5);
        executables.add(()->assertEquals(9,sum1));

        int sum2=calculator.sum(4,5);
        executables.add(()->assertEquals(6,sum2));
        //把断言内容放在list内，统一断言
        assertAll("执行流错误信息",executables.stream());

    }

}
