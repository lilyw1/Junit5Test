package com.hogwarts.junit5allure;

import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * @author wyl
 * @create 2022-02-04 23:21
 */
public class AllureStepTest {
    @Test
    public void someTest() throws Exception {
        //Some code...
        //步骤拆分，步骤较多时，方便确认是那个步骤出现的问题
        Allure.step("步骤1",this::step1Logic);
        Allure.step("步骤2",this::step2Logic);
        assertThat(1,equalTo(1));
        //Some more assertions...
    }
    @Step("This is step 1")
    private void step1Logic() {
        // Step1 implementation
        System.out.println("步骤1");
    }
    @Step("This is step 2")
    private void step2Logic() {
        // Step2 implementation
        System.out.println("步骤2");
    }
}
