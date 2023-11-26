package com.iweb.test4;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.sql.*;
import java.util.Properties;

/**
 * @author LYH
 * @date 2023/11/25 11:19
 */
public class DBUtil {
    public static Connection getConnection() throws Exception {
        File dbConfigFile = new File("D:\\Idea_workspace\\d1115_javad11_372\\d1125_javad16\\" +
                "src\\main\\java\\com\\iweb\\test4\\db.properties");
        Properties dbConfig = new Properties();
        try {
            dbConfig.load(new FileInputStream(dbConfigFile));
        } catch (IOException e) {
            e.printStackTrace();
        }
        String url = (String) dbConfig.get("url");
        String userName = (String) dbConfig.get("userName");
        String password = (String) dbConfig.get("password");

        Class.forName("com.mysql.jdbc.Driver");
        return DriverManager.getConnection(url, userName, password);
    }

    public static void main(String[] args) {
        try(Connection c = getConnection();
            PreparedStatement ps = c.prepareStatement("select now()")){
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                String date = rs.getString("now()");
                System.out.println(date);
            }
        }catch (Exception e){

        }
    }

}
