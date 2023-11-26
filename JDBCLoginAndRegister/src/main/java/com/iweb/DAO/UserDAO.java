package com.iweb.DAO;

import com.iweb.entity.User;

/**
 * @author LYH
 * @date 2023/11/16 10:19
 */
public interface UserDAO {
    /** 用于登录时查询 数据库是否存在对应user和password
     * @param user 作为查询所用到的参数实体
     * @return true 为存在此用户 false 为不存在此用户 或者 数据库出错
     */
    boolean selectUserNameToPassword(User user);

    /** 用于注册插入数据库
     * @param user 作为插入数据库表记录的一个实体
     * @return true 插入成功 false  插入失败
     */
    boolean insertIntoUser(User user);

    /** 用户更新用户信息
     * @param user 传入用户实体 根据实体中的信息 在表中做全更改
     * @return true 修改成功 false 修改失败
     */
    boolean updateUserInfo(User user);
}
