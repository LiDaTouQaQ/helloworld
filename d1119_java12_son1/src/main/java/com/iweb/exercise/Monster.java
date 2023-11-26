package com.iweb.exercise;

import lombok.Data;

/**
 * @author LYH
 * @date 2023/11/19 14:29
 */
@Data
public class Monster {
    public String name;
    private float hp;
    // synchronized如果用来修饰实例方法
    // 同步对象就是当前对象this
    public synchronized void recover(){
        // 1.先获取hp 2.计算hp+1 3.对hp赋值
        hp++;
    }
    public void hurt(){
        synchronized (this){
            hp--;
        }
    }
}
