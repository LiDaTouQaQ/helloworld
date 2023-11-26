package com.iweb.DAO.impl;

import com.iweb.DAO.GradeDAO;
import com.iweb.Entity.Grade;
import com.iweb.test.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author LYH
 * @date 2023/11/15 18:30
 */
public class GradeDAOImpl implements GradeDAO {
    @Override
    public List<Grade> listBySid(Integer sid) {
        List<Grade> grades = new ArrayList<>();
        String sql = "SELECT * from grade where sid=?";
        try(Connection c = DBUtil.getConnection();
            PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1,sid);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Grade g = new Grade();
                g.setGrade(rs.getBigDecimal("grade"));
                g.setSid(rs.getInt("sid"));
                g.setId(rs.getInt("id"));
                g.setSubject(rs.getString("subject"));
                grades.add(g);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return grades.isEmpty() ? null : grades;
    }
}
