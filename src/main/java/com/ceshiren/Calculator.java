package com.ceshiren;

import org.slf4j.Logger;

import java.util.Arrays;
import java.util.UUID;
import java.util.stream.IntStream;

import static java.lang.invoke.MethodHandles.lookup;
import static org.slf4j.LoggerFactory.getLogger;

/**
 * @author wyl
 * @create 2022-01-23 14:42
 */
public class Calculator {
    //获得具有所需名称的记录器
    static final Logger logger = getLogger(lookup().lookupClass());
    public static int result = 0;

    //用例名
    String name;
    //唯一ID标识
    String id;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    //实例化
    public Calculator(String name) {
        this.name = name;
        logger.info("创建 {} ", name);
    }

    //创建Id
    public void initId(){
        id = UUID.randomUUID().toString();
        logger.info("生成ID：{} 并绑定", id);

    }
    //销毁Id
    public void destroyId() {
        if (id == null) {
            throw new IllegalArgumentException(name + " 没有初始化对应ID");
        }
        logger.info("释放ID: {}", id);
        id = null;
    }

    //关闭
    public void close() {
        logger.info("关闭 {} ", name);
    }


    //连续添加
    //范围为[-99,99]
    public int sum(int... numbers) {
        System.out.println("sum------");

        if(Arrays.stream(numbers).anyMatch(u -> u > 99) | Arrays.stream(numbers).anyMatch(u -> u < -99)){
            logger.warn("请输入范围内的整数");
            throw new IllegalArgumentException("请输入范围内的整数！");

        }else {
            return IntStream.of(numbers).sum();
        }

    }


    //从100开始相减
    public int subtract(int... numbers) {
        System.out.println("subtract------");

        if(Arrays.stream(numbers).allMatch(u -> u > 99) | Arrays.stream(numbers).allMatch(u -> u < -99)){
            logger.warn("请输入范围内的整数");
            throw new IllegalArgumentException("请输入范围内的整数！");
        }else {
            return IntStream.of(numbers).reduce(100, (a, b) -> a-b);
        }
    }
    //两数相减，[-99,99]
    public int subtract(int x,int y) {
        System.out.println("subtract------");
        if(x>99 | x<-99 | y>99 | y<-99){
            logger.warn("请输入范围内的整数");
            return 0;
        }else {
            return x-y;

        }
    }


    //平均值 average
    public double average(int... numbers) {
        if(Arrays.stream(numbers).allMatch(u -> u > 99) | Arrays.stream(numbers).allMatch(u -> u < -99)){
            logger.warn("请输入范围内的整数");
            return 0;
        }else {
            return IntStream.of(numbers).average().getAsDouble();
        }
    }


    //连续拼接
    public String concatStr(String... words) {
        return String.join(" ", words);

    }

}

