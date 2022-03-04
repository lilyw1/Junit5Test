package com.hogwarts.junit5order;

import org.junit.jupiter.api.*;

/**
 * @author wyl
 * @create 2022-01-20 21:10
 */
    //1.设定排序方法为通过Order注解排序，注意需要和@Order结合使用
    //@TestClassOrder(ClassOrderer.OrderAnnotation.class)
    //2.通过方法的DisplayName排序
    //@TestClassOrder(ClassOrderer.DisplayName.class)
    //3.随机排序
    //@TestClassOrder(ClassOrderer.Random.class)
    //4.通过用例名称来控制执行顺序
    //@TestClassOrder(ClassOrderer.ClassName.class)

public class OrderClassDemoTest {
    @Nested
    //@Order(4)
    @DisplayName("1")
    class HogwartsOne {
        @Test
        void test1() {
            System.out.println("第一条测试用例");
        }
    }

    @Nested
    //@Order(2)
    @DisplayName("2")
    class HogwartsTwo {
        @Test
        void test2() {
            System.out.println("第二条测试用例");
        }
    }

    @Nested
    //@Order(3)
    @DisplayName("3")
    class HogwartsThree {
        @Test
        void test3() {
            System.out.println("第三条测试用例");
        }
    }
}





