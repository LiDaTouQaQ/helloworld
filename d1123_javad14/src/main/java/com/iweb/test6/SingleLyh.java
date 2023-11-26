package com.iweb.test6;

/** 双重检查锁的单例模式
 * 禁止了指令的重排序
 * 也保证了单例
 * 也保证了性能 锁只获取了一次
 * @author LYH
 * @date 2023/11/24 14:28
 */
public class SingleLyh {
    private volatile static SingleLyh singleLyh;
    private SingleLyh(){

    }
    public static SingleLyh getInstance(){
        // 为了提高性能 如果其他线程对象已经实例化了
        // 则通过return直接获取对象的引用 而不需要再获取锁了
        if(singleLyh == null){
            synchronized (SingleLyh.class){
                if(singleLyh == null){
                    singleLyh = new SingleLyh();
                }
            }
        }
        return singleLyh;
    }
}
