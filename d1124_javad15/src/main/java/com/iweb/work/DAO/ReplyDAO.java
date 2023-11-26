package com.iweb.work.DAO;

import java.util.List;

/**
 * @author LYH
 * @date 2023/11/24 16:18
 */
public interface ReplyDAO {
    /** 用于获取话术
     * @param receive 传入的内容
     * @return 返回应当回复的内容
     */
    List<String> getResponse(String receive);
}
