package com.iweb.DAO;

import com.iweb.Entity.Grade;

import java.util.List;

/**
 * @author LYH
 * @date 2023/11/15 18:26
 */
public interface GradeDAO {
    /** 查询成绩表中的学生id
     * @param sid 学生id
     * @return 成绩列表
     */
    List<Grade> listBySid(Integer sid);
}
