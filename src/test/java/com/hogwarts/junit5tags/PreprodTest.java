package com.hogwarts.junit5tags;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author wyl
 * @create 2022-01-20 23:37
 */
@Test
@Tag("Preprod")
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface PreprodTest {

}
