package com.giao1;

import java.util.Random;

/**
 * 通过反射创建对应的运行时类对象
 * @author 9953
 * @date 2021/11/17 - 10:31
 */
public class newinstancetst {
    public static void main(String[] args) throws Exception {
  /*      Class clazz=Person.class;
        *//*
        newInstance():调用此方法，创建对应的运行时类的对象。内部调用了运行时类的空参的构造器
        1.运行时类必须提供空参的构造函数
        2.空参的构造器的访问权限要够，通常，设置为public。

        在javaBean中要求提供一个public的空参构造器。原因：
        1.便于通过反射，创建运行时类的对象
        2.便于自己成此运行时类时，默认调用super()时，保证父类有次构造器
         *//*
        Person obj =(Person) clazz.getDeclaredConstructor().newInstance();
        System.out.println(obj);*/

        int num=new Random().nextInt(3);
        String classPath="";
        switch (num){
            case 0:
                classPath="java.util.Date";
                break;
            case 1:
                classPath="java.lang.Object";
                break;
            case 2:
                classPath="com.giao1.Person";
                break;
        }
        Object instance = getInstance(classPath);
        System.out.println(instance);
        
    }
    /*
    创建一个指定类的对象
    classPath：指定类的全类名
    反射的动态性
     */
    public static Object getInstance(String classPath)throws Exception{
        Class clazz=Class.forName(classPath);
        return clazz.getDeclaredConstructor().newInstance();
    }
}
