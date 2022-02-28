package com.ceshiren.hogwarts.wework.app;
import io.appium.java_client.AppiumDriver;

/**
 *@description 通讯录界面功能
 * @author wyl
 * @create 2022-02-27 14:41
 */
public class ContactAppPage extends BaseAppPage{

    public ContactAppPage(AppiumDriver driver){
        super(driver);
    }

    //直接点击进入个人页
    public MemberAppPage toMember(){
        return new MemberAppPage(driver);
    }
    //搜索进入个人页
    public MemberAppPage searchMember(String pattern) throws Exception {
        //点击搜索框
        click("com.tencent.wework:id/kci","id");
        //driver.findElement(By.id("com.tencent.wework:id/kci")).click();
        find("android.widget.EditText").sendKeys(pattern);
        //driver.findElement(By.cssSelector("android.widget.EditText")).sendKeys(pattern);
        click("com.tencent.wework:id/fkc","id");
        //driver.findElement(By.id("com.tencent.wework:id/fkc")).click();
        return new MemberAppPage(driver);
    }

    public  ContactAppPage addMember(UserProfile user1) throws Exception {
        //研发写的id是不变的，但是经过混淆会变成随机id
        click("kcc","id");
        //driver.findElement(By.id("kcc")).click();
        click("*[text = 添加成员]");
        //driver.findElement(By.cssSelector("*[text = 添加成员]")).click();
        click("*[text = 手动输入添加]");
        //driver.findElement(By.cssSelector("*[text = 手动输入添加]")).click();
        find("bsm","id").sendKeys(user1.getName());
        //driver.findElement(By.id("bsm")).sendKeys(user1.getName());
        find("hgi","id").sendKeys(user1.getMobile());
        //driver.findElement(By.id("hgi")).sendKeys(user1.getMobile());
        click("*[text = 保存]");
        //driver.findElement(By.cssSelector("*[text = 保存]")).click();
        find("*[text = 手动输入添加]");
        //driver.findElement(By.cssSelector("*[text = 手动输入添加]"));
        //等待手动输入添加出现,点击返回
        back();
        //driver.navigate().back();
        find("*[text = 添加成员]");
        //driver.findElement(By.cssSelector("*[text = 添加成员]"));
        //等待添加成员出现,点击返回
        back();
        //driver.navigate().back();
        return this;

    }
}
