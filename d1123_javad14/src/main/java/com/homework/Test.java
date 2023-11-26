package com.homework;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author LYH
 * @date 2023/11/23 21:44
 */
public class Test {
    public static void main(String[] args) {
        // synchronized
        One o = new One(0);
        for (int i = 0; i < 500; i++) {
            Thread a = new Thread(){
                @Override
                public void run() {
                    o.add();
                }
            };
            a.start();
            try {
                a.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            Thread b = new Thread(){
                @Override
                public void run() {
                    o.sub();
                }
            };
            b.start();
            try {
                b.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(o.getA());

        // ReentrantLock
        Two t = new Two(new ReentrantLock(),0);
        ThreadPoolExecutor tpe = new ThreadPoolExecutor(
                10,50,60, TimeUnit.SECONDS,new LinkedBlockingDeque<>());
        for (int i = 0; i < 500; i++) {
            tpe.execute(new Runnable(){
                @Override
                public void run() {
                    t.add();
                }
            });
            tpe.execute(new Runnable(){
                @Override
                public void run() {
                    t.sub();
                }
            });
        }
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(t.getA());

        // volatile AtomicInteger
        Three three = new Three();
        for (int i = 0; i < 500; i++) {
            tpe.execute(new Runnable() {
                @Override
                public void run() {
                    three.add();
                }
            });
            tpe.execute(new Runnable() {
                @Override
                public void run() {
                    three.sub();
                }
            });
        }
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(three.getA());
    }
}
