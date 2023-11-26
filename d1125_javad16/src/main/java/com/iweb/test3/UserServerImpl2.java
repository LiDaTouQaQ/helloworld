package com.iweb.test3;

/**
 * @author LYH
 * @date 2023/11/25 11:02
 */
public class UserServerImpl2 implements UserServer {
    @Override
    public void login() {
        System.out.println("扫掌登录");
    }

    @Override
    public void register() {
        System.out.println("巩膜注册");
    }
}
