package com.hogwarts.junit5suite;

import org.junit.platform.suite.api.ExcludePackages;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SuiteDisplayName;

/**
 * @author wyl
 * @create 2022-01-23 23:01
 */

@Suite
//通过类名指定测试用例，导入相关测试类import com.ceshiren.class2.TwoTest;import com.ceshiren.class1.OneTest;
//@SelectClasses({TwoTest.class, OneTest.class})
//通过包名来选择要执行的用例
//@SelectPackages("com.ceshiren.class1")
@SelectPackages({"com.ceshiren"})
//@IncludePackages("com.ceshiren.class2")
@ExcludePackages("com.ceshiren.class1")
@SuiteDisplayName("执行多个测试包的测试用例")
public class SuiteDemoTest {

}
