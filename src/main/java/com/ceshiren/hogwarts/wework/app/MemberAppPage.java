package com.ceshiren.hogwarts.wework.app;

import io.appium.java_client.AppiumDriver;

/**
 * @author wyl
 * @create 2022-02-27 14:43
 */
public class MemberAppPage extends BaseAppPage{

    public MemberAppPage(AppiumDriver driver){
        super(driver);
    }
    //获取个人资料，用于后续断言
    public UserProfile getProfile() throws Exception {
        UserProfile user = new UserProfile();
        user.setName(find("com.tencent.wework:id/jpy","id").getText());
        //user.setName(driver.findElement(By.id("com.tencent.wework:id/jpy")).getText());
        user.setMail(find("btd","id").getText());
        //user.setMail(driver.findElement(By.id("btd")).getText());
        return user;
    }
}
