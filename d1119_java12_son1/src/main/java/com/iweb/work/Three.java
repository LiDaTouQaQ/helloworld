package com.iweb.work;

/**
 * @author LYH
 * @date 2023/11/19 15:58
 */
public class Three {
    public synchronized void print(String str){
        System.out.println(str);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        final Three t = new Three();
        Thread t1 = new Thread(){
            @Override
            public void run() {
                while (true){
                    synchronized (t){
                        t.print("A");
                        try {
                            t.wait();
                            t.notify();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        };
        Thread t2 = new Thread(){
            @Override
            public void run() {
                while (true){
                    synchronized (t){
                        t.print("B");
                        try {
                            t.notify();
                            t.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                    }
                }
            }
        };
        t1.start();
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t2.start();
    }
}
