package com.hogwarts.JUnit5;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
public class NestExampleTest {
    @Nested
    class AuthorityManagment{
        @Nested
        class Management{
            @Test
            void managementLogin(){
                System.out.println("管理员登录测试");
            }
            @Nested
            class ManagementDelete{
                @Test
                void deleteUser(){
                    System.out.println("删除用户");
                }
            }
        }
    }
    @Nested
    class DataManagement{
        @Nested
        class CreditScore{
            @Nested
            class MortgageScore{
                @Test
                void getMortgageScore(){
                    System.out.println("房屋贷款");
                }
            }
        }
    }
}
