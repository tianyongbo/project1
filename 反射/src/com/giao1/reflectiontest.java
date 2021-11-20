package com.giao1;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Scanner;

/**
 * @author 9953
 * @date 2021/11/16 - 20:46
 */
public class reflectiontest {
    public static void main(String[] args) throws Exception{
        //反射前对于Person类的操作

     /*   Person p1=new Person("tome",12);
        //2.通过对象调用属性和方法
        p1.age=10;
        System.out.println(p1.toString());
        p1.show();
        //在Person外部是不可以Person类的对象调用其内部的私有结构
        //比如：name、showNation（）以及私有的构造器*/
        //test2();
        test3();
    }

    //疑问：通过直接new的方式或反射的方式都可以调用公共的结构，开发中到底用哪个？
    //建议直接new的方式
    //什么时候用：反射的方式。  反射的特征：动态性
    //疑问？反射机制与面对对象中的封装性是矛盾的，如何看待两个技术
    //不矛盾。
    /*
    关于java.lang.Class类的理解
    1.类的加载过程
    程序经过javac.exe命令以后，会生成一个或多个字节码文件(.class结尾)，接着我们使用
    java.exe命令对某个字节码文件进行解释运行。相当于将某个字节码文件加载到内存中，此过程
    就称为类的加载。加载到内存的类，我们就称为运行时类，此运行时类，就作为一个Class的一个实例
    2.换句话说，Class的实例就对应着一个运行时类。
    3.加载到内存中的运行时类，会缓存一定的时间，在此时间之内，我们可以通过不同的方式来获取此运行时类。

    注：只要数组的元素类型与维度一样，就是同一个Class
     */
    public static void test2() throws Exception {
        Class clazz = Person.class;
        //1.通过反射创建Person类的对象
        Constructor cons = clazz.getConstructor(String.class, int.class);

        Object obj = cons.newInstance("tom", 12);
        Person p = (Person) obj;
        System.out.println(obj.toString());
        //2.通过反射，调用对象指定的属性、方法
        //调用属性
        Field age = clazz.getDeclaredField("age");
        age.set(p, 10);
        System.out.println(p.toString());

        //调用方法
        Method show = clazz.getDeclaredMethod("show");
        show.invoke(p);

        //通过反射可以调用Person类的私有结构、私有构造器、方法、属性
        //调用私有的构造器
        Constructor cons1 = clazz.getDeclaredConstructor(String.class);
        cons1.setAccessible(true);
        Person p1=(Person)cons1.newInstance("jerry");
        System.out.println(p1.toString());

        //调用私有属性
        Field name=clazz.getDeclaredField("name");
        name.setAccessible(true);
        name.set(p1,"hanmeimei");
        System.out.println(p1);
        
        //调用私有方法
        Method showNation = clazz.getDeclaredMethod("showNation", String.class);
        showNation.setAccessible(true);
        String nation=(String) showNation.invoke(p1,"中国");//相当于String nation=p1.showNation("中国")
        System.out.println(nation);
        

    }

    //获取Class实例的方式（前三种方式需要掌握）
    public static void test3() throws Exception {
        //方式一:调用运行时类的属性.class
        Class<Person> clazz1=Person.class;
        System.out.println(clazz1);

        //方式二：通过运行时类的对象
        Person p1=new Person();
        Class clazz2=p1.getClass();
        System.out.println(clazz2);

        //方式三：调用Class的静态方法，forname(String classPath)
        Class clazz3 = Class.forName("com.giao1.Person");
        System.out.println(clazz3);

        //方式四：使用类的加载类，classloader(了解)
        ClassLoader classLoader = reflectiontest.class.getClassLoader();
        Class clazz4 = classLoader.loadClass("com.giao1.Person");
        System.out.println(clazz4);
        
    }
}
