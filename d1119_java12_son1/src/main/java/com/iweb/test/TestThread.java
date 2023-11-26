package com.iweb.test;

/** 多线程
 * 通过创建线程的对象来实现多线程
 *
 * 创建方式
 * 1.继承Thread类
 * 2.实现Runnable接口
 * // 从线程扩展的方式来看 Runnable更好
 * 因为继承方式之后 该类不能继承其他类 用接口可以实现多个接口
 * // 不用理由 我们不能直接创建线程对象 使用线程池
 * 3.实现Callable接口(了解)
 * 4.实现Future接口(了解)
 * @author LYH
 * @date 2023/11/19 8:48
 */
public class TestThread {
    public static void main(String[] args) {
        // 通过Runnable接口完成线程对象实例化的时候
        // 需要借助Thread类完成实例化
        // FuckRice fr1 = new FuckRice();
        // Thread t1 = new Thread(fr1);
        // FuckRice fr2 = new FuckRice();
        // Thread t2 = new Thread(fr2);
        // t1.setName("lyh");
        // t2.setName("ldt");
        // t1.start();
        // t2.start();
        // 匿名内部类 本质是内部类的一种
        // 只不过开发者不需要提供类的名称 类名
        // 由jvm动态分配
        Thread t1 = new Thread(){
            @Override
            public void run(){
                for (int i = 0; i < 10; i++) {
                    System.out.println("匿名内部类"+this.getName());
                }
            }
        };
        t1.setName("ldt");
        Thread t2 = new Thread(){
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println("匿名内部类"+this.getName());
                }
            }
        };
        t2.setName("lxt");
        t1.start();
        t2.start();
        System.out.println(t1.getClass().getName());
        System.out.println(t2.getClass().getName());

    }
}
