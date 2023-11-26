package com.iweb.exercise;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LYH
 * @date 2023/11/19 14:31
 */
public class Test {
    public static void main(String[] args) {
        final Monster goblin = new Monster();
        goblin.setName("哥布林");
        goblin.setHp(10000);

        int n = 100000;
        List<Thread> addThreads = new ArrayList<Thread>();
        List<Thread> reduceThreads = new ArrayList<Thread>();
        // 定义一万个负责调用recover方法给哥布林回血的过程
        for (int i = 0; i < n; i++) {
            Thread t = new Thread(){
                @Override
                public void run() {
                    goblin.recover();
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };
            t.start();
            addThreads.add(t);
        }
        for (int i = 0; i < n; i++) {
            Thread t = new Thread(){
                @Override
                public void run() {
                    goblin.hurt();
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            };
            t.start();
            reduceThreads.add(t);
        }
        // 我们需要在主线程中访问哥布林的血量的
        // 需要保证以上2万线程跑完之后读取血量
        // 需要将以上2w线程join主线程
        for (Thread t :addThreads) {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        for (Thread t: reduceThreads) {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("哥布林最终血量: "+goblin.getHp());
    }
}
