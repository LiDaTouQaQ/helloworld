package com.homework;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * @author LYH
 * @date 2023/11/16 8:51
 */
public class Two {
    public static void main(String[] args) {
        String username = "root";
        String password = "a12345";
        String url = "jdbc:mysql://localhost:3306/test?characterEncoding=utf8";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection c = DriverManager.getConnection(url,username,password);
            System.out.println("连接数据库成功");
            String sql = "select id,name from student";
            PreparedStatement ps = c.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Student student = new Student();
                student.setId(rs.getInt("id"));
                student.setName(rs.getString("name"));
                System.out.println(student);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}
