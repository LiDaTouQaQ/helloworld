package com.iweb.test;

/** 反射 和 注解
 * 将Java的类当作是一种对象 类对象
 * @author LYH
 * @date 2023/11/25 9:02
 */
public class Test {
    {
        System.out.println("静态属性被加载");
    }
    public static void main(String[] args) throws ClassNotFoundException {
        // 三种方式获取类的类对象
        // 1.调用Class.forName获取
        Class c1 = Class.forName("com.iweb.test.Test");
        // 2.利用类对象所对应的类的实例获取
        Class c2 = new Test().getClass();
        // 3.使用.class 直接获取
        Class c3 = Test.class;
        // 类对象在同一个jvm中 不管获取多少次 获取的永远都是同一个
        // 类加载只会执行一次 而类对象在会在类加载的时候自动创建
        System.out.println(c1==c2);
        System.out.println(c1==c3);
        // 类对象在获取的时候 会自动加载对应类的静态属性
        // .class 方式获取类的静态信息的时候 是不会加载类的静态属性的
    }
}
