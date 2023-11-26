package com.iweb.test;

/**
 * 实现Runnable接口
 *
 * @author LYH
 * @FunctionalInterface 函数式接口 接口可以像箭头函数那样调用
 * @date 2023/11/19 9:18
 */
public class FuckRice implements Runnable {
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("这是一个线程: " + Thread.currentThread().getName());
        }
    }
}
