package com.iweb.work.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author LYH
 * @date 2023/11/24 16:08
 */
public class DBUtil {
    private static final String USERNAME = "root";
    private static final String PASSWORD = "a12345";
    private static final String URL = "jdbc:mysql://localhost:3306/test?characterEncoding=utf8";

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnect() throws SQLException {
        return DriverManager.getConnection(URL,USERNAME,PASSWORD);
    }

}
