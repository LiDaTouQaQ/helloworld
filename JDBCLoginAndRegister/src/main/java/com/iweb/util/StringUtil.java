package com.iweb.util;

import java.util.Random;

/**
 * @author LYH
 * @date 2023/11/10 14:18
 */
public class StringUtil {
    private static final String STR_POOL = "qwertyuiopasdfghjkllzxcvbnm123456789";
    private static final Random r = new Random();
    public static String getCaptchaCode(){
        StringBuilder sb = new StringBuilder();
        int count = r.nextInt(3)+4;
        for(int i=0;i<count;i++){
            sb.append(STR_POOL.charAt(r.nextInt(STR_POOL.length())));
        }
        return sb.toString();
    }
}
