package com.iweb.Entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

/**
 * @author LYH
 * @date 2023/11/14 19:45
 */
@Data
@NoArgsConstructor
public class Student {
    private Integer id;
    private String name;
    private String gender;
    private Date birthday;
    private String address;
    private Integer qqnumber;
    private List<Grade> grades;

}
