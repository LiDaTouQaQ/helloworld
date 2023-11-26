package com.iweb.test3;

/**
 * @author LYH
 * @date 2023/11/25 11:02
 */
public class UserServerImpl1 implements UserServer{
    @Override
    public void login() {
        System.out.println("用户名密码登录");
    }

    @Override
    public void register() {
        System.out.println("用户密码注册");
    }
}
