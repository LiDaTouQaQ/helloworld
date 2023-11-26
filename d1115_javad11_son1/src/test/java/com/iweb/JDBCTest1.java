package com.iweb;

import com.iweb.DAO.StudentDAO;
import com.iweb.DAO.impl.StudentDAOImpl;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author LYH
 * @date 2023/11/15 20:41
 */
public class JDBCTest1 {
    private StudentDAO studentDAO;
    // 在其他测试方法运行之前 被该注解修饰的方法会自动执行
    @Before
    public void init(){
        studentDAO = new StudentDAOImpl();
    }
    @Test
    public void testListAllWithGrade(){
        // System.out.println(studentDAO.listByIdWithGrade(1));
        // 断言类 判断代码和预期值是否相同
        Assert.assertEquals(8,studentDAO.listAll().size());
        Assert.assertNull(studentDAO.listByNameLike("管"));
    }

    @Test
    public void testListAll(){
        System.out.println(studentDAO.listAll());
    }
    @After
    public void destroy(){
        System.out.println("在这个方法中进行资源销毁和对象处理");
    }
}
