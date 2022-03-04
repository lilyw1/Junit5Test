package com.hogwarts.junit5nest;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

/**
 * @author wyl
 * @create 2022-01-23 14:02
 */
public class NestDemoTest {
    @Nested
    class A{
        @Nested
        class B{
            @Nested
            class C{
                @Test
                void client(){
                    System.out.println("创建用户");
                }
            }
        }
        @Nested
        class B2{
            @Test
            void deleteUser(){
                System.out.println("删除用户");
            }
        }
    }
}
