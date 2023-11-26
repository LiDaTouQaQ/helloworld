package com.iweb.service;

import com.iweb.DAO.UserDAO;
import com.iweb.DAO.impl.UserDAOImpl;
import com.iweb.controller.Controller;
import com.iweb.entity.User;

/**
 * @author LYH
 * @date 2023/11/10 15:04
 */
public class Service {
    private static UserDAO userDAO = new UserDAOImpl();

    /**
     * @param inputUser
     * @return
     */
    public static boolean login(User inputUser){
        boolean flag = userDAO.selectUserNameToPassword(inputUser);
        if(flag){
            Controller.CURRENT_USER = inputUser;
        }else{
            Controller.CURRENT_USER = new User();
        }
        return flag;
    }
    public static boolean register(User inputUser){
        return userDAO.insertIntoUser(inputUser);
    }
    public static boolean update(User user){
        return userDAO.updateUserInfo(user);
    }
}
