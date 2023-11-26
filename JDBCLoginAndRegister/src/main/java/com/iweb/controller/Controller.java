package com.iweb.controller;


import com.iweb.entity.User;
import com.iweb.service.Service;
import com.iweb.view.View;

/**
 * @author LYH
 * @date 2023/11/10 14:54
 */
public class Controller {
    public static User CURRENT_USER = null;
    public static void mainController(String key){
        User inputUser = null;
        switch (key){
            case "1": {
                // TODO: 2023/11/10 调用登录相关业务
                inputUser = View.loginView();
                boolean login = Service.login(inputUser);
                // 根据登录逻辑调用的结果 决定下一步跳转的视图
                if (login) {
                    // 跳转到下一步视图
                    View.userInfoView();
                } else {
                    View.log("登录失败");
                    View.mainView();
                }
                break;
            }
            case "2": {
                // TODO: 2023/11/10 调用注册相关业务
                inputUser = View.registerView();
                if (inputUser == null) {
                    View.mainView();
                } else {
                    boolean register = Service.register(inputUser);
                    if (register) {
                        View.log("注册成功");
                        View.mainView();
                    } else {
                        View.log("注册失败");
                        View.mainView();
                    }
                }
                break;
            }
            default:
                break;
        }
    }
    public static void userIndexController(String inputKey){
        switch (inputKey){
            case "1":
                View.userMsgView(CURRENT_USER);
                break;
            case "2":
                View.updateUserView();
                if(Service.update(CURRENT_USER)){
                    View.log("信息修改成功");
                }else{
                    View.log("信息修改失败");
                }
                break;
            default:
                break;
        }
    }
}
