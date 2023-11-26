package com.iweb.view;

import com.iweb.controller.Controller;
import com.iweb.entity.Hobby;
import com.iweb.entity.User;
import com.iweb.util.StringUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author LYH
 * @date 2023/11/10 14:42
 */
public class View {
    private static Scanner sc = new Scanner(System.in);
    public static void log(String message){
        if(message.isEmpty()){
            System.out.println();
            return;
        }
        for (int i = 0; i < message.length(); i++) {
            System.out.print(message.charAt(i));
            try {
                Thread.sleep(0);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };
        System.out.println();
    }
    public static void mainView(){
        System.out.println("用户登录系统");
        log("---------------");
        log("输入操作的业务");
        log("1.登录");
        log("2.注册");
        String inputKey = sc.nextLine();
        Controller.mainController(inputKey);

    }

    public static User loginView(){
        log("请输入用户名: ");
        String inputUserName = sc.nextLine();
        log("请输入密码: ");
        String inputPassword = sc.nextLine();
        // 对输入的数据进行封装
        User inputUser = new User();
        inputUser.setUserName(inputUserName);
        inputUser.setPassword(inputPassword);
        return inputUser;
    }

    public static void userInfoView(){
        log("输入要操作的功能序号");
        log("1.查看用户信息");
        log("2.修改用户信息");
        String inputKey = sc.nextLine();
        Controller.userIndexController(inputKey);
    }
    public static void userMsgView(User user){
        log("用户名: "+user.getUserName());
        log("密码: "+user.getPassword());
        // TODO: 2023/11/16 后续添加爱好信息展示
        List<Hobby> list = Controller.CURRENT_USER.getHobbyList();
        if(list != null){
            for (Hobby h :list) {
                log(h.toString());
            }
        }
        userInfoView();
    }
    public static void updateUserView(){
        List<Hobby> hobbyList = new ArrayList<>();
        log("输入修改后的用户名:");
        String inputUserName = sc.nextLine();
        log("输入修改后的密码:");
        String inputPassword = sc.nextLine();
        Controller.CURRENT_USER.setUserName(inputUserName);
        Controller.CURRENT_USER.setPassword(inputPassword);
        log("输入爱好内容: ");
        hobbyList.add(new Hobby(Controller.CURRENT_USER.getId(),sc.nextLine()));
        log("是否继续输入:");
        while (sc.nextLine().equalsIgnoreCase("y")){
            log("输入爱好内容: ");
            hobbyList.add(new Hobby(Controller.CURRENT_USER.getId(),sc.nextLine()));
            log("是否继续输入:");
        }
        Controller.CURRENT_USER.setHobbyList(hobbyList);
        userInfoView();
    }
    public static User registerView(){
        log("输入登录用户名");
        String inputUserName = sc.nextLine();
        log("输入登录密码");
        String inputPassword = sc.nextLine();
        String captcha = StringUtil.getCaptchaCode();
        log("输入验证码"+captcha);
        String inputCaptcha = sc.nextLine();
        if(inputCaptcha.equals(captcha)){
            User inputUser = new User();
            inputUser.setUserName(inputUserName);
            inputUser.setPassword(inputPassword);
            return inputUser;
        }else{
            log("验证码输入错误");
            return null;
        }
    }

    public static void main(String[] args) {
        mainView();
    }
}
