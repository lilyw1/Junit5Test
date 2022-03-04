package com.ceshiren.class1;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

/**
 * @author wyl
 * @create 2022-01-23 23:03
 */
public class OneTest {
    @Test
    @Tag("SuiteTag")
    @Tag("SuiteTag1")
    void test1(){
        System.out.println("com.class1.packageA-----OneTest");

    }

    @Test
    @Tag("SuiteTag")
    @Tag("SuiteTag1")
    void test6(){
        System.out.println("com.class1.packageA-----OneTestaaaa");

    }

}

