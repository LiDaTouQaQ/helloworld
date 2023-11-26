package com.iweb.test6;

/** volatile 禁止指令重排序
 *
 * 设计模式 单例模式 该类只会实例化一个对象
 * 单例模式的类的特点
 * 1.私有构造方法
 * 2.本类自己的静态引用
 * 3.公共的获取实例方法
 *
 * 双重检查锁
 * @author LYH
 * @date 2023/11/24 13:53
 */
public class Test {
    public static void main(String[] args) {
        // Java中有指令重排序 会为了提高效率打乱指令的执行顺序
        // 创建对象
        // 1.new向堆申请空间
        // 2.通过构造方法完成初始化
        // 3.返回引用
        // 指令重排序后 132
        // 被volatile修饰的变量禁止重排序

    }
}
