package com.iweb.test;

import com.iweb.DAO.StudentDAO;
import com.iweb.DAO.impl.StudentDAOImpl;
import com.iweb.Entity.Student;

import java.util.Date;
import java.util.List;

/** java database connection
 * 在Java中操作和读取数据库的一种方案
 * 规定了固定的几个接口 由数据库厂商自己实现接口 提供实现类
 * 由厂商所提供的实现类 组成了 jdbc 的jar包
 * Connection Statement PreparedStatement ResultSet DriverManager
 *
 *
 * ORM 模型 Object relation model 对象映射关系模型
 *
 * 映射关系
 * java中的类 映射 数据库中的表
 * Java中的对象 映射 数据库中的一行数据
 * Java中的类的成员变量 映射 数据库表的字段
 * Java中的对象的成员变量值 映射 数据库表的字段值
 * Java中的对象集合 映射 数据库的多行数据
 *
 * @author LYH
 * @date 2023/11/14 18:28
 */
public class TestJDBC {
    public static void main(String[] args) {
        // // 驱动加载
        // try {
        //     // 静态资源加载 包括静态代码块 和 静态方法
        //     Class.forName("com.mysql.jdbc.Driver");
        //
        // } catch (ClassNotFoundException e) {
        //     e.printStackTrace();
        // }
        // System.out.println("驱动加载成功");
        // // 创建连接
        String username = "root";
        String password = "a12345";
        String url = "jdbc:mysql://localhost:3306/test?characterEncoding=utf8";
        // 编译语句的创建
        // try(Connection c = DriverManager.getConnection(url,username,password);
        //         Statement s = c.createStatement();){
        //     String sql = "INSERT INTO student(NAME,gender,birthday,address,qqnumber)\n" +
        //             "VALUES('zyn','男','2002-7-16','常州',22222222)";
        //     s.execute(sql);
        // }catch (SQLException e){
        //     e.printStackTrace();
        // }

        // 将功能封装带DBUtil中
        // try(Connection c = DBUtil.getConnection();
        //     Statement s = c.createStatement();){
        //     String sql = "INSERT INTO student(NAME,gender,birthday,address,qqnumber)\n" +
        //             "VALUES('zzz','男','2002-7-16','苏州',22222222)";
        //     s.execute(sql);
        // }catch (SQLException e){
        //     e.printStackTrace();
        // }
        StudentDAO studentDAO = new StudentDAOImpl();
        // studentDAO.delete(8);
        Student s = new Student();
        s.setName("lyh");
        s.setAddress("北苑");
        s.setGender("男");
        s.setBirthday(new Date());
        s.setQqnumber(1222);
        // studentDAO.insert(s);
        s.setId(10);
        // studentDAO.update(s);
        // List<Student> students = new ArrayList<>();
        // students = studentDAO.listByPage("z",0,5);
        // students = studentDAO.listByNameLike("z");
        // studentDAO.testInsert();
        // System.out.println(studentDAO.listAll());

        // Student student = studentDAO.listByIdWithGrade(1);
        // System.out.println(student);
        List<Student> students = studentDAO.listAllWithGrade(0,3);
        System.out.println(students);
    }
}
