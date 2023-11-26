package com.iweb.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author LYH
 * @date 2023/11/16 10:32
 */
@Data
@NoArgsConstructor
public class Hobby {
    private int id;
    private int uid;
    private String content;
    @Override
    public String toString() {
        return "爱好='" + content + ' ';
    }
    public Hobby(int uid,String content){
        this.uid = uid;
        this.content = content;
    }
}
