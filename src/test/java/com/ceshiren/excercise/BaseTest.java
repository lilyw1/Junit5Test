package com.ceshiren.excercise;

import com.ceshiren.Calculator;
import org.junit.jupiter.api.*;
import org.slf4j.Logger;

import static java.lang.invoke.MethodHandles.lookup;
import static org.slf4j.LoggerFactory.getLogger;

/**
 * @author wyl
 * @create 2022-01-23 17:01
 */
public class BaseTest {
    public static final Logger logger = getLogger(lookup().lookupClass());
    public static Calculator calculator;
    public int result;
    //字符串的运算结果
    public String resultStr;

    @BeforeAll
    //必须是static类型
    static void beforeAll(){
        logger.info("BasedTest---beforeAll");
        //实例化，创建初始化对象
        calculator = new Calculator("计算器");
    }

    @BeforeEach
    void beforeEach(){
        //为啥不打印？！！,logback中定义了作用域，换了包名就不生效
        logger.info("BasedTest---beforeEach");
        //System.out.println("BaseTest--beforeEach");
        //在测试方法中生成ID唯一标识
        calculator.initId();
        //log打印：开始进行计算
        logger.info("开始进行计算");


    }
    @AfterEach
    void afterEach(TestInfo testInfo){

        logger.info("BasedTest---AfterEach");
        //包括测试方法类的tag标签的所有内容都会拿到
        //有一个顺序，先加载类tag的标签，再加载方法上的tag标签，最后是一个数组的内容
        testInfo.getTags();
        //log打印计算结果result
        logger.info("计算结果：{}",result);
        //销毁ID
        calculator.destroyId();
    }
    @AfterAll
    static void afterAll(){
        logger.info("BasedTest---afterAll");
        //清空测试数据
        //关闭计算器
        calculator.close();
    }
}
