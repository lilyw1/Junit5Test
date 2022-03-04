package com.ceshiren.excercise;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

/**
 * @author wyl
 * @create 2022-02-03 0:15
 */
@Suite
//测试套件加标签,更改类名SuiteTest
//@SuiteDisplayName("加法、字符串拼接")
//@SelectPackages({"com.ceshiren.excercise.num","com.ceshiren.excercise.str"})
@SelectClasses({com.ceshiren.excercise.num.SumTest.class,com.ceshiren.excercise.str.StrsTest.class})
/*@IncludeTags({
        "en",
       "test1"
})

 */
//或的关系，并非要同时en和test1
public class SuiteTest {
}
