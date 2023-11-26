package com.iweb.test3;

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
        System.out.println("为:"+name+"恢复了1点生命值，当前生命值为: "+hp);
        this.notify();
    }
    public synchronized void hurt(){
        if(hp==1){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        hp--;
        System.out.println("为:"+name+"降低了1点生命值，当前生命值为: "+hp);
    }
}
