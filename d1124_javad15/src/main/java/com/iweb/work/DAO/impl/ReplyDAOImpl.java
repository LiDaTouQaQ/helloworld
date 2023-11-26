package com.iweb.work.DAO.impl;

import com.iweb.work.DAO.ReplyDAO;
import com.iweb.work.entity.Reply;
import com.iweb.work.util.DBUtil;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author LYH
 * @date 2023/11/24 16:18
 */
public class ReplyDAOImpl implements ReplyDAO {
    @Override
    public List<String> getResponse(String receive) {
        String sql = "select * from reply where receive=?";
        List<String> replyList = new ArrayList<>();
        try (Connection c = DBUtil.getConnect();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, receive);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                replyList.add(rs.getString("response"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return replyList.isEmpty() ? null : replyList;
    }
}
