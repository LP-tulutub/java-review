package com.java.review.annotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class FruitInfoUtil {

    static Field[] fields = null;

    public static void getFruitInfo(Class<?> clazz){

        String strFruitName=" 水果名称：";
        String strFruitColor=" 水果颜色：";
        String strFruitProducer="供应商信息：";

        fields = clazz.getDeclaredFields();

        for(Field field :fields){
            if(field.isAnnotationPresent(FruitName.class)){
                FruitName fruitName = (FruitName) field.getAnnotation(FruitName.class);
                strFruitName=strFruitName+fruitName.value();
                System.out.println(strFruitName);
            }
            else if(field.isAnnotationPresent(FruitColor.class)){
                FruitColor fruitColor= (FruitColor) field.getAnnotation(FruitColor.class);
                strFruitColor=strFruitColor+fruitColor.fruitColor().toString();
                System.out.println(strFruitColor);
            }
            else if(field.isAnnotationPresent(FruitProvider.class)){
                FruitProvider fruitProvider= (FruitProvider) field.getAnnotation(FruitProvider.class);
                strFruitProducer=" 供应商编号："+fruitProvider.id()+" 供应商名称："+fruitProvider.name()+" 供应商地址："+fruitProvider.address();
                System.out.println(strFruitProducer);
            }
        }
    }

    public static Object getInfo(Class<?> clazz) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {

        fields = clazz.getDeclaredFields();

        FruitName fruitName = null;
        FruitColor fruitColor = null;
        FruitProvider fruitProvider = null;
        //获得所有属性的类型
        Class[] classes = new Class[fields.length];
        int i = 0;
        for (Field field : fields) {
            if (field.isAnnotationPresent(FruitName.class)) {
                fruitName = (FruitName) field.getAnnotation(FruitName.class);
            } else if (field.isAnnotationPresent(FruitColor.class)) {
                fruitColor = (FruitColor) field.getAnnotation(FruitColor.class);
            } else if (field.isAnnotationPresent(FruitProvider.class)) {
                fruitProvider = (FruitProvider) field.getAnnotation(FruitProvider.class);
            }
            classes[i] = field.getType();
            i++;
        }
        
        Class<?> aClass = Class.forName(clazz.getName());
        Constructor<?> declaredConstructor = aClass.getDeclaredConstructor(classes);
        declaredConstructor.setAccessible(true);

        String appleName = fruitName.value();
        String appleColor = fruitColor.fruitColor().toString();
        String appleProvider = fruitProvider.name();

        Object obj = declaredConstructor.newInstance(appleName, appleColor, appleProvider);
        return obj;

    }










}
