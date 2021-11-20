package com.giao1;

import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.Properties;

/**
 * @author 9953
 * @date 2021/11/17 - 10:08
 */
public class classloadertest {
    public static void main(String[] args) throws  Exception{
  /*      //对于自定义类，使用系统类加载器进行加载
        ClassLoader classLoader=classloadertest.class.getClassLoader();
        System.out.println(classLoader);
        //使用getparent(),获取扩展类加载器
        ClassLoader classLoader1=classLoader.getParent();
        System.out.println(classLoader1);
        //调用扩展加载器getparent()，无法获取引导类加载器
        //引导类加载器主要负责加载java的核心类库，无法加载自定义类的。
        ClassLoader classLoader2 = classLoader1.getParent();
        System.out.println(classLoader2);

        ClassLoader classLoader3 = String.class.getClassLoader();
        System.out.println(classLoader3);
        */

        /*
        properties:用来读取配置文件
         */
//        Properties pros=new Properties();
//        FileInputStream fis=new FileInputStream("jdbc.properties");
//        pros.load(fis);
//
//        String user = pros.getProperty("user");
//        String password = pros.getProperty("password");
//        System.out.println(user+"*****"+password);
        show1();


    }


    public  static void show()throws Exception{
        Properties pros=new Properties();
        //配置文件的方式1
//        FileInputStream fis=new FileInputStream("jdbc.properties");
//        pros.load(fis);

        //读取配置文件的方式2
        //配置文件默认识别为，当前module的src下
        ClassLoader classLoader = classloadertest.class.getClassLoader();
        InputStream is = classLoader.getResourceAsStream("jdbc1.properties");
        pros.load(is);

        String user = pros.getProperty("user");
        String password = pros.getProperty("password");
        System.out.println(user+"*****"+password);
    }

    //权限修饰符 数据类型    变量名
    public static void show1(){
        Class clazz=Person.class;

        Field[] declaredField = clazz.getDeclaredFields();

        for (Field f :
                declaredField) {
            int modifier = f.getModifiers();
            System.out.println(modifier);

        }
    }
}
