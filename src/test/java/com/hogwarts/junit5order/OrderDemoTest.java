package com.hogwarts.junit5order;

import org.junit.jupiter.api.*;

/**
 * @author wyl
 * @create 2022-01-20 21:10
 */
    //1.设定排序方法为通过Order注解排序，注意需要和@Order结合使用
    //@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
    //2.通过方法的DisplayName排序
    //@TestMethodOrder(MethodOrderer.DisplayName.class)
    //3.随机排序
    //@TestMethodOrder(MethodOrderer.Random.class)
    //4.通过用例名称来控制执行顺序
    //@TestMethodOrder(MethodOrderer.MethodName.class)
public class OrderDemoTest {
    @Test
    //@Order(1)
    //@DisplayName("a")
    void Hogwarts1(){
        System.out.println("第一条测试用例");
    }


    @Test
    //@Order(2)
    //@DisplayName("b")
    void Hogwarts2(){
        System.out.println("第二条测试用例");
    }


    @Test
    //@Order(3)
    //@DisplayName("d")
    void Hogwarts3(){
        System.out.println("第三条测试用例");
    }

    @Test
    //@Order(4)
    //@DisplayName("c")

    void Hogwarts4(){
        System.out.println("第四条测试用例");
    }
}
