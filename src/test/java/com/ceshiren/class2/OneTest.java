package com.ceshiren.class2;

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
    void test3(){
        System.out.println("com.class2.packageB-----OneTest");

    }

}

