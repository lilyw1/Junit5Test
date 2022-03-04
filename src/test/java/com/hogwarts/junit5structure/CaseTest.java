package com.hogwarts.junit5structure;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author wyl
 * @create 2022-01-18 23:10
 */
public class CaseTest {

    @Test
  //用例起别名
    @DisplayName("CaseTest的第一条用例标题别名")

    void hogwarts(){
        System.out.println("CaseTest的第一条测试用例");
        //测试用例的断言
        //assertEquals(2,1+1);
        //assertTrue(3>1);

        assertAll( "ALL",
                ()->assertEquals(3,2),
                ()->assertEquals(2,2),
                ()->assertEquals(4,1+1)
        );

    }

}
