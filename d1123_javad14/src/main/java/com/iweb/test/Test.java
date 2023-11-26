package com.iweb.test;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/** java 自带的线程池
 * @author LYH
 * @date 2023/11/23 16:06
 */
public class Test {
    public static void main(String[] args) {
        // corePoolSize 初始线程数
        // maximunPoolSize 线程池允许的最大线程数
        // keepAliveTime
        // TimeUnit.SECONDS 规定时间内新建的线程没被使用会被归还
        // new LinkedBlockingDeque<>() 用来装任务的的数据结构
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                10,15,60, TimeUnit.SECONDS,new LinkedBlockingDeque<>());
        threadPoolExecutor.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("任务一");
            }
        });
        showSeason(Season.SPRING);
    }

    // 枚举类
    public static void showSeason(Season season){
        switch (season){
            case SPRING:
                System.out.println("万物复苏");
                break;
            case SUMMER:
                System.out.println("夏天来了");
                break;
            case AUTUMN:
                System.out.println("秋天来了");
                break;
            case WINTER:
                System.out.println("就是当下");
                break;
            default:
                System.out.println("输入有误");
        }
    }
}
