package com.hogwarts.junit5suite;

import org.junit.platform.suite.api.*;

/**
 * @author wyl
 * @create 2022-01-23 23:01
 */

@Suite
@SelectPackages("com.ceshiren")
//执行包含SuiteTag1的测试类
//@IncludeTags("SuiteTag1")
//执行不包含SuiteTag1的测试类
@ExcludeTags("SuiteTag1")
//正则匹配需要执行的类名，需要把包名也写上
//@IncludeClassNamePatterns("com.ceshiren.class1.*eTest$")
//正则匹配不需要执行的类名
//@ExcludeClassNamePatterns("com.ceshiren.class1.*oTest$")
@SuiteDisplayName("执行多个测试包的测试用例")
public class SuiteDemo2Test {

}
