package com.ceshiren.excercise.str;

import com.ceshiren.excercise.BaseTest;
import org.junit.jupiter.api.*;

import java.lang.reflect.Method;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author wyl
 * @create 2022-01-23 22:24
 */
@DisplayName("计算器字符串测试用例")
public class StrsTest extends BaseTest {

    @Test
    @DisplayName("2个英文字符拼接")
    @Tag ("en")
    //设置标签为英文
    void str1Test(TestInfo testInfo){
       //logger.info("测试方法名：{}",testInfo.getTestMethod());
       //输出Optional[void com.ceshiren.Excercise.StrsTest.str1Test(org.junit.jupiter.api.TestInfo)]
        Optional<Method> testMethod = testInfo.getTestMethod();
        Optional<String> s = testMethod.map(Method::getName);
        //System.out.println(s); Optional[str1Test]过滤出方法名来判断返回result还是resultstr
//        //建议大家研究一下s.filter().
//        s.filter(str -> str.contains("str")).ofNuallable().or
     //   s.isPresent();//不建议使用，因为它是判断对象  null != obj
        resultStr = calculator.concatStr("Hello","Junit5");
        assertEquals("Hello Junit5",resultStr);
    }


    @Test
    @Tags({
            @Tag("test1"),
            @Tag("test4"),
            @Tag("en")
    })
    @DisplayName("3个英文字符拼接")
    void strs2Test(){
//        yaml
        resultStr = calculator.concatStr("This","is", "Junit5");
        assertEquals("This is Junit5",resultStr);
    }

    @Test
    @Tag("zh")
    @DisplayName("2个中文字符拼接")
    void strs3Test(){
        resultStr = calculator.concatStr("这是", "北京");
        assertEquals("这是 北京",resultStr);
    }
}
