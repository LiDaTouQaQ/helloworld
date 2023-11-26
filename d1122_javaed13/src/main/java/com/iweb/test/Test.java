package com.iweb.test;

/** 面试会问的
 * @author LYH
 * @date 2023/11/22 18:27
 */
public class Test {
    // 静态方法的同步对象是当前类所对应的class反射对象
    public synchronized static void li(){

    }
    // 等价于
    // Test.class 是反射对象
    // 每一个类的反射对象 全局唯一
    public static void l(){
        synchronized (Test.class){

        }
    }

}
