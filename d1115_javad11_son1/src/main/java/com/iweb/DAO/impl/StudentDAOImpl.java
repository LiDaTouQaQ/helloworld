package com.iweb.DAO.impl;

import com.iweb.DAO.GradeDAO;
import com.iweb.DAO.StudentDAO;
import com.iweb.Entity.Grade;
import com.iweb.Entity.Student;
import com.iweb.test.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author LYH
 * @date 2023/11/14 20:05
 */
public class StudentDAOImpl implements StudentDAO {
    @Override
    public void insert(Student student) {
        // String sql = "INSERT INTO student(NAME,gender,birthday,address,qqnumber) VALUES('"+
        //         student.getName()+"','"+student.getGender()+"','"+new SimpleDateFormat("yyyy-MM-dd").format(student.getBirthday()) +"','"+student.getAddress()+
        //         "',"+student.getQqnumber()+")";
        // System.out.println(sql);
        // try(Connection c = DBUtil.getConnection();
        // Statement s = c.createStatement();){
        //     s.execute(sql);
        // }catch (SQLException e){
        //     e.printStackTrace();
        // }
        // Statement 存在几种弊端
        // 1.参数较多的时候 拼接复杂
        // 2.statement 是先传参 再编译 性能较差
        // 3.statement 存在SQL注入攻击的问题

        // PrepareStatement
        // 1.参数传递简单 方法调用即可
        // 2.先编译 再传参 性能更好
        // 3.不存在sql注入攻击的问题 再参数传入之前 语句已经编译确定了
        String sql = "INSERT INTO student(NAME,gender,birthday,address,qqnumber)"+
                "values(?,?,?,?,?)";
        try(Connection c = DBUtil.getConnection();
            // Statement.RETURN_GENERATED_KEYS 参数使用后 可以获得自增长主键
            PreparedStatement ps = c.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS)){
            // 使用方法进行传参 用序号代表所传递参数问号的位置 这里是Java中唯一基1
            ps.setString(1,student.getName());
            ps.setString(2,student.getGender());
            ps.setDate(3,new Date(student.getBirthday().getTime()));
            ps.setString(4,student.getAddress());
            ps.setInt(5,student.getQqnumber());
            ps.execute();
            // 在执行完插入语句之后 mysql会为新数据分配自增长ID
            // JDBC 可以通过getGeneratorKeys 方法获取ID
            ResultSet rs = ps.getGeneratedKeys();
            if(rs.next()){
                student.setId(rs.getInt(1));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    // 由于没有写 c.setAutoCommit(false)
    // 所有的dml语句是默认自动commit提交的 不需要我们进行事物管理
    // 如果你写了 c.setAutoCommit(false)就需要在方法中最后手动调用
    @Override
    public void delete(Integer id) {
        String sql = "delete from student where id = " +id;
        try(Connection c = DBUtil.getConnection();
            Statement s = c.createStatement();){
            s.execute(sql);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    @Override
    public void update(Student student) {
        String sql = "UPDATE student set name=?,gender=?,birthday=?,address=?,qqnumber=? where id=?";
        try(Connection c = DBUtil.getConnection();
            PreparedStatement ps = c.prepareStatement(sql);){
            ps.setString(1,student.getName());
            ps.setString(2,student.getGender());
            ps.setDate(3,new Date(student.getBirthday().getTime()));
            ps.setString(4,student.getAddress());
            ps.setInt(5,student.getQqnumber());
            ps.setInt(6,student.getId());
            ps.execute();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public List<Student> listAll() {
        return listByPage(null,0,Integer.MAX_VALUE);
    }

    @Override
    public List<Student> listByNameLike(String key) {
        List<Student> students = new ArrayList<>();
        if (key == null | key.isEmpty()){
            return listAll();
        }
        String sql = "select * from student where name like concat('%',?,'%')";
        try(Connection c = DBUtil.getConnection();
            PreparedStatement ps = c.prepareStatement(sql);){
            ResultSet rs = null;
            ps.setString(1,key);
            rs = ps.executeQuery();
            while (rs.next()){
                Student s = new Student();
                s.setId(rs.getInt(1));
                s.setName(rs.getString("name"));
                s.setAddress(rs.getString("address"));
                s.setGender(rs.getString("gender"));
                s.setQqnumber(rs.getInt("qqnumber"));
                s.setBirthday(rs.getDate("birthday"));
                students.add(s);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return students.isEmpty() ? null : students;
    }

    @Override
    public List<Student> listByPage(Integer start, Integer count) {
        return listByPage(null,start,count);
    }

    @Override
    public List<Student> listByPage(String key, Integer start, Integer count) {
        List<Student> students = new ArrayList<>();
        String sql;
        if(key==null || key == ""){
            sql = "select * from student limit ?,?";
        }else{
            sql = "select * from student where name like concat('%',?,'%') limit ?,?";
        }
        try(Connection c = DBUtil.getConnection();
            PreparedStatement ps = c.prepareStatement(sql)){
            if(key == null || key == ""){
                ps.setInt(1,start);
                ps.setInt(2,count);
            }else {
                ps.setString(1,key);
                ps.setInt(2,start);
                ps.setInt(3,count);
            }
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Student s = new Student();
                s.setId(rs.getInt(1));
                s.setName(rs.getString("name"));
                s.setAddress(rs.getString("address"));
                s.setGender(rs.getString("gender"));
                s.setQqnumber(rs.getInt("qqnumber"));
                s.setBirthday(rs.getDate("birthday"));
                students.add(s);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return students.isEmpty() ? null : students;
    }

    @Override
    public void testInsert() {
        String sql = "INSERT INTO student values(?,?,?,?,?,?)";
        Connection c = null;
        try {
            c = DBUtil.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try(PreparedStatement ps = c.prepareStatement(sql);){
            // 关闭事务自动提交
            c.setAutoCommit(false);
            Random r = new Random();
            for (int i = 0; i < 10000; i++) {
                ps.setInt(1,r.nextInt(200)+10);
                ps.setString(2,"学生"+i);
                ps.setString(3,"男");
                ps.setDate(4,new Date(new java.util.Date().getTime()));
                ps.setString(5,"南京");
                ps.setLong(6,r.nextInt(100000)+1000);
                ps.execute();
            }
            c.commit();
        }catch (SQLException e){
            try {
                System.out.println("发生错误事务回滚");
                c.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    @Override
    public Student listByIdWithGrade(Integer sid) {
        String sql = "SELECT * from student where id=?";
        Student student = new Student();
        try(Connection c = DBUtil.getConnection();
            PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1,sid);
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                student.setId(sid);
                student.setName(rs.getString("name"));
                student.setGender(rs.getString("gender"));
                student.setBirthday(rs.getDate("birthday"));
                student.setAddress(rs.getString("address"));
                student.setQqnumber(rs.getInt("qqnumber"));
            }
            GradeDAO dao = new GradeDAOImpl();
            List<Grade> grades = dao.listBySid(sid);
            student.setGrades(grades);
        }catch (SQLException e){
            e.printStackTrace();
        }
        return student;
    }

    @Override
    public List<Student> listAllWithGrade() {
        String sql = "select * from student";
        List<Student> students = new ArrayList<>();
        try(Connection c = DBUtil.getConnection();
            PreparedStatement ps = c.prepareStatement(sql)) {
            Student student = new Student();
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                student.setId(rs.getInt("id"));
                student.setName(rs.getString("name"));
                student.setGender(rs.getString("gender"));
                student.setBirthday(rs.getDate("birthday"));
                student.setAddress(rs.getString("address"));
                student.setQqnumber(rs.getInt("qqnumber"));
                GradeDAOImpl dao = new GradeDAOImpl();
                List<Grade> grades = dao.listBySid(student.getId());
                student.setGrades(grades);
                students.add(student);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return students.isEmpty() ? null : students;
    }

    @Override
    public List<Student> listAllWithGrade(int start, int count) {
        List<Student> students = new ArrayList<>();
        String sql = "SELECT id from student limit ?,?";
        try(Connection c = DBUtil.getConnection();
        PreparedStatement ps = c.prepareStatement(sql);){
            ps.setInt(1,start);
            ps.setInt(2,count);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                int sid = rs.getInt("id");
                students.add(listByIdWithGrade(sid));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return students.isEmpty() ? null :students;
    }
}
