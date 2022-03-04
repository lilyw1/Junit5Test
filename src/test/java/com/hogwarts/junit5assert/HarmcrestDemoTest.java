package com.hogwarts.junit5assert;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

/**
 * @author wyl
 * @create 2022-01-25 23:41
 */
public class HarmcrestDemoTest {
    @Test
    void UsingIsForMatch(){
        String testString = "hamcrest core Is match";

        assertThat(testString, is("hamcrest core Is match"));
        assertThat(testString, is(equalTo("hamcrest core Is match")));
    }

    @Test
    void UsingEqualToForMatch(){
        String actualString = "equalTo match";
        List<String> actualList = Arrays.asList("equalTo", "match");
        Object original = 100;

        assertThat(actualString, is(equalTo("equalTo match")));
        assertThat(actualList, is(equalTo(Arrays.asList("equalTo", "match"))));
        assertThat(original, equalToObject(100));//类型
    }

    @Test
    void UsingNotForMatch(){
        String testString = "hamcrest not match";

        assertThat(testString, not("hamcrest other match"));
        assertThat(testString, is(not(equalTo("hamcrest other match"))));
        assertThat(testString, is(not(instanceOf(Integer.class))));//判断不是整数类型

    }

    @Test
    void UsingHasItemForMatch(){
        List<String> list = Arrays.asList("java", "hamcrest", "junit5");

        assertThat(list, hasItem("java"));
        assertThat(list, hasItem(isA(String.class)));//判断有没有String类型

        assertThat(list, hasItems("java", "junit5"));
        assertThat(list, hasItems(isA(String.class), endsWith("est")));
    }

    @Test
    void UsingAllOfForMatch(){
        String testString = "Achilles is powerful";
        assertThat(testString, allOf(
                startsWith("Achi"), endsWith("ul"), containsString("Achilles")));

    }
    @Test
    void UsinganyOfForMatch(){
        String testString2 = "Hector killed Achilles";
        assertThat(testString2, anyOf(startsWith("Hec"), containsString("baeldung")));
    }

    @Test
    void UsingBothForMatch(){
        String testString = "daenerys targaryen";
        assertThat(testString, both(startsWith("daene")).and(containsString("yen")));

    }

    @Test
    void UsingEitherForMatch(){
        String testString = "daenerys targaryen";
        assertThat(testString, both(startsWith("daene")).and(containsString("yen")));
        assertThat(testString, either(startsWith("ntar")).or(containsString("targaryen")));

    }

}

