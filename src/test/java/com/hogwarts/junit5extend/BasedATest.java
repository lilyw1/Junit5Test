package com.hogwarts.junit5extend;

import org.junit.jupiter.api.*;

/**
 * @author wyl
 * @create 2022-01-19 20:50
 */
public class BasedATest {

    @BeforeAll
    static void beforeAAll(){
        System.out.println("BaseATest----beforeAAll");
    }
    @AfterAll
    static void afterAAll(){
        System.out.println("BaseATest----afterAAll");
    }
    @BeforeEach
    void beforeAEach(){
        System.out.println("BaseATest----beforeAEach");
    }
    @AfterEach
    void afterAEachAAll(){
        System.out.println("BaseATest----afterAEach");
    }

    @Test//测试用例前必加上，放在测试用例前
    void hogwarts1(){
        System.out.println("BaseATest----hogwarts第一条测试用例");
    }
    @Test//测试用例前必加上，放在测试用例前
    void hogwarts2(){
        System.out.println("BaseATest----hogwarts第二条测试用例");
    }
}
