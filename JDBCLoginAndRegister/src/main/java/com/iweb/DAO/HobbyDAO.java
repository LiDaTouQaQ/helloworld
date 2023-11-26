package com.iweb.DAO;

import com.iweb.entity.Hobby;
import com.iweb.entity.User;

import java.util.List;

/**
 * @author LYH
 * @date 2023/11/16 13:51
 */
public interface HobbyDAO {
    /** 用于返回指定用户的爱好列表
     * @param user 用户id
     * @return 爱好列表
     */
    List<Hobby> selectAllHobby(User user);

    /** 根据User中的hobby字段 向数据库添加或者修改hobby
     * @param user
     * @return
     */
    boolean insertHobby(User user);
    boolean deleteHobby(User user);
}
