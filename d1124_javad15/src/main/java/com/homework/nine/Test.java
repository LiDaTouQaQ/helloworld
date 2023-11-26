package com.homework.nine;

/**
 * @author LYH
 * @date 2023/11/24 22:17
 */
public class Test {
    public static void main(String[] args) {
        Object o1 = new Object();
        Object o2 = new Object();
        Thread t1 = new Thread(){
            @Override
            public void run() {
                synchronized (o1){
                    System.out.println("线程1获取到o1的锁");
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("线程1试图获取到o2的锁");
                    synchronized (o2){
                        System.out.println("获取到o2的锁");
                    }
                }
            }
        };
        Thread t2 = new Thread(){
            @Override
            public void run() {
                synchronized (o2){
                    System.out.println("线程2获取到o2的锁");
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("线程2试图获取o1的锁");
                    synchronized (o1){
                        System.out.println("线程2获取到o1的锁");
                    }
                }
            }
        };
        t1.start();
        t2.start();
    }
}
