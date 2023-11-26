package com.iweb.work.controller;

import com.iweb.work.DAO.ReplyDAO;
import com.iweb.work.DAO.impl.ReplyDAOImpl;

import java.util.List;
import java.util.Random;

/**
 * @author LYH
 * @date 2023/11/24 16:34
 */
public class ReplyServer {
    static ReplyDAO replyDAO = new ReplyDAOImpl();
    public static String getRsponse(String receive){
        List<String> strs = replyDAO.getResponse(receive);
        if(strs == null || strs.isEmpty()){
            return "不好意思我没听懂";
        }
        Random r = new Random();
        String ready = strs.get(r.nextInt(strs.size()));
        return ready;
    }
}
