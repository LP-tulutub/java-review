package com.java.review.annotation;

import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
//@Documented //是否将改注释加入java文档中
public @interface FruitName {
    String value() default "";
}
