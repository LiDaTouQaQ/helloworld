package com.iweb.DAO.impl;

import com.iweb.DAO.HobbyDAO;
import com.iweb.DAO.UserDAO;
import com.iweb.entity.User;
import com.iweb.util.DBUtil;

import java.sql.*;

/**
 * @author LYH
 * @date 2023/11/16 10:24
 */
public class UserDAOImpl implements UserDAO {
    HobbyDAO hobbyDAO = new HobbyDAOImpl();
    @Override
    public boolean selectUserNameToPassword(User user) {
        boolean flag = false;
        String sql = "select * from user where username=? and password=?";
        try(Connection c = DBUtil.getConnection();
            PreparedStatement ps = c.prepareStatement(sql)){
            ps.setString(1,user.getUserName());
            ps.setString(2,user.getPassword());
            ResultSet rs =ps.executeQuery();
            if(rs.next()){
                user.setId(rs.getInt("id"));
                // 获取该用户的爱好列表
                user.setHobbyList(hobbyDAO.selectAllHobby(user));
                flag = true;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public boolean insertIntoUser(User user) {
        boolean flag = false;
        String sql = "insert into user(username,password) values(?,?)";
        try(Connection c = DBUtil.getConnection();
            PreparedStatement ps = c.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS)){
            ps.setString(1,user.getUserName());
            ps.setString(2,user.getPassword());
            ps.execute();
            ResultSet rs = ps.getGeneratedKeys();
            if(rs.next()){
                if(rs.getInt(1)>0){
                    flag = true;
                }
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public boolean updateUserInfo(User user) {
        boolean flag = false;
        String sql = "update user set username=?,password=? where id = ?";
        try(Connection c = DBUtil.getConnection();
            PreparedStatement ps = c.prepareStatement(sql)){
            ps.setString(1,user.getUserName());
            ps.setString(2,user.getPassword());
            ps.setInt(3,user.getId());
            if(!hobbyDAO.insertHobby(user)){
                flag = false;
            }else{
                int num = ps.executeUpdate();
                if(num == 1){
                    flag = true;
                }
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return flag;
    }
}
