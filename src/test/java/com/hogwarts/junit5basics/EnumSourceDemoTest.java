package com.hogwarts.junit5basics;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

public class EnumSourceDemoTest {
    //1.定义枚举类
    public enum hogwartsUnit{
        Harry("Harry", 18),
        Lily("Lily",20),
        Allen("Allen", 10);

        private  final String name;
        private final int age;

        private hogwartsUnit(String name,int age){
            this.name = name;
            this.age = age;
        }

    }

    //2.测试方法添加注释
    @ParameterizedTest
    //通过names指定枚举对象范围
    @EnumSource(names = {"Harry","Allen"})

    void EnumSourceDemo(hogwartsUnit unit){
        System.out.println(unit.name+"的年龄是："+ unit.age);
    }

    @ParameterizedTest
    //通过names指定枚举对象范围,通过mode指定规则
    //EXCLUE不包含
    @EnumSource(mode = EnumSource.Mode.EXCLUDE,names = {"Harry","Allen"})

    void EnumSourceDemo2(hogwartsUnit unit){
        System.out.println(unit.name+"的年龄是："+ unit.age);
    }

    @ParameterizedTest
    //通过names指定枚举对象范围,通过mode指定规则
    //MATCH_ALL正则匹配，names中填匹配规则
    @EnumSource(mode = EnumSource.Mode.MATCH_ALL,names = {"A.*"})

    void EnumSourceDemo3(hogwartsUnit unit){
        System.out.println(unit.name+"的年龄是："+ unit.age);
    }
}
