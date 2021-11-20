package java2;

import java1.Person;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 调用运行时类中指定的结构：属性、方法、构造器
 * @author 9953
 * @date 2021/11/17 - 15:29
 */
public class refelectiontest {
    public static void main(String[] args) throws Exception{
        testconstructor();

    }

    /*
    如果操作运行时类中的指定的属性--需要掌握
     */
    public static void test1()throws Exception{
        Class clazz= Person.class;

        //创建运行时的对象
        Person p = (Person) clazz.getDeclaredConstructor().newInstance();
        //获取指定属性：要求运行时类中的属性声明为public
        //通常不采用此方式
//        Field id = clazz.getField("id");
        //clazz.getDeclaredField()获取指定名的属性
        Field name = clazz.getDeclaredField("name");
        //设置当前属性的值
        /*
        set方法：参数1：指明设置哪个对象的属性
                参数2：将此属性设置为多少
         */
        //保证当前属性是可访问的
        name.setAccessible(true);
        //获取、设置指定对象的属性
        name.set(p,"tome");

        System.out.println( name.get(p));
    }

     /*
    如果操作运行时类中的指定的方法--需要掌握
     */
    public static void testMethod()throws Exception{
        Class clazz=Person.class;

        Person p =(Person) clazz.getDeclaredConstructor().newInstance();

        //获取指定的某个方法
        /*
        getDeclaredMethod():参数1：指明获取的方法的名称
                            参数2：指明获取的方法的形参列表
         */
        Method show = clazz.getDeclaredMethod("show", String.class);

        //保证当前方法是可访问的
        show.setAccessible(true);
        /*
        invoke():参数1，方法的调用者
                   参数2：给方法形参赋值的实参
         invoke()的返回值即为对应类中调用的方法的返回值
         */
        Object returnvalue = show.invoke(p, "cnn");
        System.out.println(returnvalue);

        System.out.println("*****************调用静态方法*********************");

        Method showdesc = clazz.getDeclaredMethod("showdesc");

        showdesc.setAccessible(true);
        //如果调用的运行时类中的方法没有返回值，则此invoke()返回null。
        Object invoke = showdesc.invoke(p);
        System.out.println(invoke);
    }

    /*
    如果操作运行时类中的构造器--需要掌握
     */
    public static void testconstructor()throws Exception{
        Class clazz=Person.class;

        //private person(string name)
        Constructor declaredConstructor = clazz.getDeclaredConstructor(String.class);

        declaredConstructor.setAccessible(true);

        //3.调用此构造器创建运行时类的对象
        Person tom =(Person) declaredConstructor.newInstance("Tom");

        System.out.println(tom);

    }
}

