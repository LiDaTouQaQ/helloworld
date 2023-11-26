package com.iweb.test;

/** 守护线程 守护线程会在所有其他非守护线程都运行之后
 * 才停止运行
 * GC 本质也是守护线程
 *
 * synchronized 加锁
 * 被多线程进行资源竞争的对象 叫做同步对象
 * 每一个同步对象 都拥有一个同步对象锁 锁具有唯一性
 * 当线程进入synchronized所修饰的方法或者代码块中的时候
 * 当前线程会获取同步对象的锁 在方法运行完成之前 锁不会被释放
 * 如果在这个时候 其他线程被cpu切换到 像调用这个方法 会因为没有锁无法调用
 * 这个现象叫做线程的阻塞 其他线程必须要等到获取的锁的线程将锁释放了 才能够进入到方法中获取锁
 * synchronized保证的是 在单位时间内 能够执行相关代码的线程只有一个
 * @author LYH
 * @date 2023/11/19 10:35
 */
public class TestThread4 {
    public static void main(String[] args) {
        Thread t1 = new Thread(){
            @Override
            public void run() {
                int time = 0;
                while (true){
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("已经过去"+ ++time + "秒");
                }
            }
        };
        Thread t2 = new Thread(){
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println("线程t2,当前运行次数: "+(i+1));
                }
            }
        };
        // t1设置为守护线程
        t1.setDaemon(true);
        t1.start();
        t2.start();
        System.out.println("主线程开始sleep");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("主线程运行结束");
    }
}
