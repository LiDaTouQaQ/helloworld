package com.iweb.homework.one;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.LinkedList;

/**
 * @author LYH
 * @date 2023/11/20 14:03
 */
@Data
@NoArgsConstructor
public class Docker {
    private LinkedList<String> cup = new LinkedList<String>();
    public synchronized void add(String name) throws InterruptedException {
        if(cup.size()<20){
            cup.add(name);
            System.out.println("存入一个数据: "+name+" 当前容器容量"+cup.size());
        }else{
            this.wait();
        }
    }
    public synchronized void remove(String action) throws InterruptedException {
        if(!cup.isEmpty()){
            String name = cup.pollLast();
            System.out.println(action+"取得一个元素: "+name+" 当前容器容量"+cup.size());
            this.notify();
        }else{
            this.wait();
        }
    }
}
