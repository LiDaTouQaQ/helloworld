package com.iweb.test6;

/** 懒汉模式(延迟加载)
 * 在多线程场景下 获取的对象可能不是同一个 不支持线程安全
 * 如果保证了线程安全 会导致性能下降
 * @author LYH
 * @date 2023/11/24 14:11
 */
public class SingleTon {
    private static SingleTon singleTon;
    private SingleTon(){

    }

    public static synchronized SingleTon getSingleTon() {
        if(singleTon == null){
            singleTon = new SingleTon();
        }
        return singleTon;
    }
}
