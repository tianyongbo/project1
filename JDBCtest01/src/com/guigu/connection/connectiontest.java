package com.guigu.connection;

import java.io.InputStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author 9953
 * @date 2021/11/16 - 19:26
 */
public class connectiontest {

    //方式一
    public void testconnection1() throws SQLException {
        //获取driver实现类的对象，
        Driver driver=new com.mysql.jdbc.Driver();

        //jdbc:mysql协议
        //localhost：ip地址
        //3306：默认mysql的端口号
        //test：test数据库

        String url="jdbc:mysql://localhost:3306/test";
        //将用户名和密码封装在properties中
        Properties info=new Properties();
        info.setProperty("user","root");
        info.setProperty("password","123456aA");

        Connection conn=driver.connect(url,info);

        System.out.println(conn);
    }

    //方式二
    public void testconnection2() throws Exception {
        //1.获取Driver实现类对象，使用反射
        Class clazz=Class.forName("com.mysql.jdbc.Driver");
        Driver driver=(Driver) clazz.newInstance();

        //2.提供要连接的数据库
        String url="jdbc:mysql://localhost:3306/test";

        Properties info=new Properties();
        info.setProperty("user","root");
        info.setProperty("password","123456aA");
        
        Connection conn=driver.connect(url,info);

        System.out.println(conn);
    }


    //方式三使用DriverManager替换Driver
    public void testconnection3() throws Exception {
        //1.获取driver类的实现对象
        Class clazz=Class.forName("com.mysql.jdbc.Driver");
        Driver driver=(Driver)clazz.newInstance();

        //2.提供另外三个连接的基本信息
        String url="jdbc:mysql://localhost:3306/test";
        String user="root";
        String password="123456aA";

        //注册驱动
        DriverManager.registerDriver(driver);
        //获取连接
        Connection conn = DriverManager.getConnection(url, user, password);
        System.out.println(conn);
    }
    //方式四 可以只是加载驱动，不用显示的注册驱动过了
    public void testconnection4() throws Exception {
        //1.提供另外三个连接的基本信息
        String url="jdbc:mysql://localhost:3306/test";
        String user="root";
        String password="123456aA";
        //2.加载Driver
        Class.forName("com.mysql.jdbc.Driver");
        //相较于方式3可以省略如下的操作。
//        Driver driver=(Driver)clazz.newInstance();
//        //注册驱动
//        DriverManager.registerDriver(driver);
        //为什么可以省略如上操作


        //获取连接
        Connection conn = DriverManager.getConnection(url, user, password);
        System.out.println(conn);
    }

    //方式五:将数据库连接需要的4个基本信息声明在配置文件中，通过读取配置文件的方式，获取连接
    /*
    这种方法的好处是
    1.实现了数据与代码的分离、实现了解耦
    2.如果要修改配置文件信息，可以避免程序重新打包
     */
    public void getconnection5()throws Exception{
        //读取配置文件中的4个基本信息
        InputStream is = connectiontest.class.getClassLoader().getResourceAsStream("jdbc.properties");

        Properties pros=new Properties();
        pros.load(is);

        String user=pros.getProperty("user");
        String password=pros.getProperty("password");
        String url=pros.getProperty("url");
        String driverClass=pros.getProperty("driverClass");

        //加载驱动
        Class.forName(driverClass);
        //获取连接
        Connection conn = DriverManager.getConnection(url, user, password);
        System.out.println(conn);
    }

    //练习
    public void connectiontest1()throws Exception{
        //1.读取配置文件中的4个基本信息
        InputStream is = connectiontest.class.getClassLoader().getResourceAsStream("jdbc.properties");

        Properties pros=new Properties();

        pros.load(is);

        String user = pros.getProperty("name");
        String password = pros.getProperty("password");
        String url = pros.getProperty("url");
        String driverClass = pros.getProperty("driverClass");

        //2.加载驱动
        Class.forName("com.mysql.jdbc.Driver");

        Connection conn = DriverManager.getConnection(url, user, password);
        System.out.println(conn);
        
    }
}
