package java2;


import java1.Person;

import java.lang.annotation.Annotation;
import java.lang.reflect.*;

/**
 * 获取当前运行时类的属性结构
 * @author 9953
 * @date 2021/11/17 - 11:05
 */
public class FieldTest {

    public static void main(String[] args) {
        Class clazz=Person.class;

        //获取属性结构
        //getFields()获取当前运行时类机器父类中声明为public访问权限的属性
        Field[] fields = clazz.getFields();
        for (Field f:
             fields) {
            System.out.println(f);
        }
        System.out.println("--------------------");

        //getDeclaredFields():获取当前运行时类中声明的所有属性（不包含父类中的属性）
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field f:
             declaredFields) {
            System.out.println(f);
        }
        System.out.println("-------------测试方法-------------");

        showpackage();
        
    }

    //权限修饰符 数据类型    变量名
    public static void show(){
        Class clazz=Person.class;
        
        Field[] declaredFields = clazz.getDeclaredFields();

        for (Field f :
                declaredFields) {
            //1.权限修饰符
            int modifier=f.getModifiers();
            System.out.print(Modifier.toString(modifier));
            
            //2.数据类型
            Class type=f.getType();
            System.out.print("\t"+type.getName());

            //3.变量名
            String name = f.getName();
            System.out.println("\t"+name);

        }


    }
    
    
    public static void showmethod(){
        Class clazz=Person.class;
        //getMethods():获取当前运行时类及其所有父类中声明为public的方法
        Method[] methods = clazz.getMethods();
        for (Method m :
                methods) {
            System.out.println(m);
        }

        System.out.println("------------------------------");
        
        //getDeclaredMethods():获取当前运行时类中声明的所有方法，不包含父类的声明
        Method[] declaredMethods = clazz.getDeclaredMethods();
        for (Method m :
                declaredMethods) {
            System.out.println(m);
        }

    }

    /*
    @xxxx
    权限修饰符   返回值类型   方法名(参数类型1 形参名1,...)throws Exception
     */
    public static void showmethod1(){
        Class clazz=Person.class;
        //获取方法声明的注解

        Method[] declaredMethods = clazz.getDeclaredMethods();
        for (Method m : declaredMethods) {
            Annotation[] annos = m.getAnnotations();
            for (Annotation a : annos) {
                System.out.println(a);

            }
            //权限修饰符
            System.out.print( Modifier.toString(m.getModifiers())+"\t");

            //返回值类型
            System.out.print(m.getReturnType().getName()+"\t");

            //返回方法名
            System.out.print(m.getName());
            System.out.print("(");
            
            //获取形参列表
            Class[] parameterTypes = m.getParameterTypes();
            if(!(parameterTypes==null&&parameterTypes.length==0)){
                for(int i=0;i<parameterTypes.length;i++){
                    if(i==parameterTypes.length-1){
                        System.out.print(parameterTypes[i].getName()+"args"+i+")");
                    }
                    System.out.print(parameterTypes[i].getName()+"args"+i);
                }
            }

            //抛出的异常
            Class[] exceptionTypes = m.getExceptionTypes();

            if(!(exceptionTypes==null&&exceptionTypes.length==0)){
                System.out.print("throws");
                for (int i = 0; i < exceptionTypes.length; i++) {
                    if(i==exceptionTypes.length-1){
                        System.out.println(exceptionTypes[i].getName());
                        break;
                    }
                    System.out.println(exceptionTypes[i].getName()+",");
                }
                

            }
            System.out.println();
            
        }


    }

    /*
    获取构造器结构
     */
    public static void showconstructor(){
        Class clazz=Person.class;
        //getConstructors()：获取当前运行时类中声明为public的构造器
        Constructor[] constructors = clazz.getConstructors();
        for (Constructor c : constructors) {
            System.out.println(c);
        }

        System.out.println("----------------");

        Constructor[] declaredConstructors = clazz.getDeclaredConstructors();
        for (Constructor c :
                declaredConstructors) {
            System.out.println(c);
        }


    }

    /*
    获取运行时类的父类
     */
    public static void showFu(){
        Class clazz=Person.class;

        Type genericSuperclass = clazz.getGenericSuperclass();
        System.out.println(genericSuperclass);

    }

    /*
    获取运行时类的带泛型的父类的泛型

    代码：逻辑性代码 vs 功能性代码
    
     */
    public static void showFu1(){
        Class clazz=Person.class;

        Type genericSuperclass = clazz.getGenericSuperclass();
        ParameterizedType genericSuperclass1 = (ParameterizedType) genericSuperclass;
        Type[] actualTypeArguments = genericSuperclass1.getActualTypeArguments();
        System.out.println(actualTypeArguments[0]);

    }
    
    /*
    获取运行时类的接口
     */
    public static void showinterface(){
        Class clazz=Person.class;

        Class[] interfaces = clazz.getInterfaces();
        for (Class c :
                interfaces) {
            System.out.println(c);
            
        }
        //获取运行时类的父类实现的接口
        Class[] interfaces1 = clazz.getSuperclass().getInterfaces();
        for (Class c:
             interfaces1) {
            System.out.println(c);
        }
    }

    /*
    获取运行时类声明的注解
     */
    public static void showpackage(){
        Class clazz=Person.class;

        Annotation[] annotations = clazz.getAnnotations();
        for (Annotation a :
                annotations) {
            System.out.println(a);
            
        }
    }
}
