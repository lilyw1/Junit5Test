package com.hogwarts.junit5extend;

import org.junit.jupiter.api.*;

/**
 * @author wyl
 * @create 2022-01-19 20:50
 */
//BasedBTest继承 BasedATest
public class BasedBTest extends BasedATest{

    @BeforeAll
    static void beforeBAll(){
        System.out.println("BaseBTest----beforeBAll");
    }
    @AfterAll
    static void afterBAll(){
        System.out.println("BaseBTest----afterBAll");
    }
    @BeforeEach
    void beforeBEach(){
        System.out.println("BaseBTest----beforeBEach");
    }
    @AfterEach
    void afterBEachBAll(){
        System.out.println("BaseBTest----afterBEach");
    }

    @Test//测试用例前必加上，放在测试用例前
    void hogwarts3(){
        System.out.println("BaseBTest----hogwarts第三条测试用例");
    }
    @Test//测试用例前必加上，放在测试用例前
    void hogwarts4(){
        System.out.println("BaseBTest----hogwarts第四条测试用例");
    }
}
