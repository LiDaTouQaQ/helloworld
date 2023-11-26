package com.homework.eight;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author LYH
 * @date 2023/11/24 22:09
 */
public class Eight {
    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        Thread t1 = new Thread(){
            @Override
            public void run() {
                while (true){
                    try {
                        if(lock.tryLock(10, TimeUnit.SECONDS)){
                            System.out.println("A");
                            lock.unlock();
                            Thread.sleep(1000);
                        }else{
                            Thread.sleep(100);
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        };
        Thread t2 = new Thread(){
            @Override
            public void run() {
                while (true){
                    try {
                        if(lock.tryLock(10, TimeUnit.SECONDS)){
                            System.out.println("B");
                            lock.unlock();
                            Thread.sleep(1000);
                        }else{
                            Thread.sleep(100);
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        t1.start();
        t2.start();
    }
}
