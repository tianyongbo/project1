package com.guigu.connection;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

/**
 * @author 9953
 * @date 2021/11/18 - 10:47
 */
public class CURD {
    public static void main(String[] args) throws Exception {
        InputStream is = CURD.class.getClassLoader().getResourceAsStream("jdbc.properties");

        Properties pros=new Properties();

        pros.load(is);

        String user = pros.getProperty("user");
        String password = pros.getProperty("password");
        String url = pros.getProperty("url");
        String driverClass = pros.getProperty("driverClass");

        Class.forName(driverClass);

        Connection connection = DriverManager.getConnection(url, user, password);

        System.out.println(connection);

    }
}
