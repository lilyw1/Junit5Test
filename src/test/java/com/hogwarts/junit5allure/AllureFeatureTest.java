package com.hogwarts.junit5allure;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Test;

/**
 * @author wyl
 * @create 2022-02-04 23:25
 */
//添加测试类别,模块名称
@Feature("登录操作")
public class AllureFeatureTest {
    @Test
    //添加测试类别,用例名称
    @Story("登录成功")
    public void test1() throws  Exception{
        System.out.println("success-0000");
    }

    @Test
    @Story("登录失败")
    public void test2() throws  Exception{
        System.out.println("fail-0001");
    }
    @Test
    @Story("登录失败")
    public void test3() throws  Exception{
        System.out.println("fail-0002");
    }
}
