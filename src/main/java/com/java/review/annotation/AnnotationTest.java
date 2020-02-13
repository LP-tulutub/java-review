package com.java.review.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class AnnotationTest {
}

/**
 * 1.@SuppressWarnings(value="unchecked")作用？@SuppressWarnings("all")？
 *  告诉编译器忽略unchecked警告信息
 *  告诉编译器忽略所有警告信息
 * 2.@Override、@Deprecated代表什么？
 *  @Override 父类重写的方法
 *  @Deprecated 当前方法会被划掉(建议不使用的标志)
 * 3.自定义注解？
 *  定义注解+反射来解析注解
 */
class MyStudentReflectTest{
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException {
        Class clazz = Class.forName("com.java.review.annotation.MyStudent");

        //获得类的所有有效注解
        Annotation[] annotations=clazz.getAnnotations();
        for (Annotation a : annotations) {
            System.out.println(a);
        }
        //获得类的指定的注解
        MyTable st = (MyTable) clazz.getAnnotation(MyTable.class);
        System.out.println(st.value());
        //获得类的属性的注解
        Field f = clazz.getDeclaredField("studentName");
        MyField sxtField = f.getAnnotation(MyField.class);
        System.out.println(sxtField.columnName()+"--"+sxtField.type()+"--"+sxtField.length());

    }
}
class FruitRun {
    public static void main(String[] args) {
        FruitInfoUtil.getFruitInfo(Apple.class);
    }
}
class FruitGet {
    public static void main(String[] args) throws Exception {
        Apple apple = (Apple)FruitInfoUtil.getInfo(Apple.class);
        System.out.println(apple.getAppleName());
        System.out.println(apple.getAppleColor());
        System.out.println(apple.getAppleProvider());
    }
}


























