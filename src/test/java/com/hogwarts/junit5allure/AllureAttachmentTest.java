package com.hogwarts.junit5allure;

import io.qameta.allure.Allure;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * @author wyl
 * @create 2022-02-04 23:40
 */
public class AllureAttachmentTest {
    @Test
    public void addattachTest(){
        // 添加文本展示
        Allure.addAttachment("文本信息", "My attachment content");
        // 添加截图展示
        try {
            Allure.addAttachment("图片信息", "image/jpg",new FileInputStream("E:/desktop/简历/1.jpg"),".jpg");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
