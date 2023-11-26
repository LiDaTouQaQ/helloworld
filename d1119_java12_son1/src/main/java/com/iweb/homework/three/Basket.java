package com.iweb.homework.three;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.LinkedList;
import java.util.List;

/**
 * @author LYH
 * @date 2023/11/20 15:35
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Basket {
    private LinkedList<String> basket = new LinkedList<String>();
    public void add(){
        basket.add("o");
    }
    public void remove(){
        basket.pollLast();
    }
    public int getSize(){
        return basket.size();
    }
}

