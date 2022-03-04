package com.hogwarts.junit5allure;

import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.Test;

/**
 * @author wyl
 * @create 2022-02-04 23:17
 */
public class AllureSeverityTest {
    @Test
    //定义测试用例等级
    @Severity(SeverityLevel.NORMAL)
    //@Severity(SeverityLevel.TRIVIAL)
    //@Severity(SeverityLevel.MINOR)
    public void normalTest() {
        assert 1 + 1 == 2;
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    public void criticalTest() {
        assert 1 + 1 == 2;
    }

    @Test
    @Severity(SeverityLevel.BLOCKER)
    public void blockerTest() {
        assert 1 + 1 == 2;
    }
}
