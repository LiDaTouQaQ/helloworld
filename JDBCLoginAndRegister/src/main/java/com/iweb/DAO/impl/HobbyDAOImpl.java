package com.iweb.DAO.impl;

import com.iweb.DAO.HobbyDAO;
import com.iweb.entity.Hobby;
import com.iweb.entity.User;
import com.iweb.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author LYH
 * @date 2023/11/16 13:52
 */
public class HobbyDAOImpl implements HobbyDAO {
    @Override
    public List<Hobby> selectAllHobby(User user) {
        List<Hobby> list = new ArrayList<>();
        String sql = "select * from hobby where uid=?";
        try (Connection c = DBUtil.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, user.getId());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Hobby hobby = new Hobby();
                hobby.setId(rs.getInt("id"));
                hobby.setUid(rs.getInt("uid"));
                hobby.setContent(rs.getString("content"));
                list.add(hobby);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list.isEmpty() ? null : list;
    }

    @Override
    public boolean insertHobby(User user) {
        boolean flag = false;
        deleteHobby(user);
        String sql = "insert into hobby(uid,content) values(?,?)";
        try (Connection c = DBUtil.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            for (Hobby h : user.getHobbyList()) {
                ps.setInt(1,h.getUid());
                ps.setString(2,h.getContent());
                ps.execute();
            }
            flag = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public boolean deleteHobby(User user) {
        boolean flag = false;
        String sql = "delete from hobby where uid=?";
        try (Connection c = DBUtil.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, user.getId());
            int num = ps.executeUpdate();
            if (num >= 0) {
                flag = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }
}
