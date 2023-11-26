package com.iweb.test3;

/** 线程交互 wait notify notifyAll 同步对象的方法都在(object) 中定义
 * 这三个方法必须要出现在同步代码块中
 *
 * wait 方法表示 让占有当前同步对象锁的线程 进入到等待状态 临时释放锁
 * 直到同步对象调用了notify或者notifyAll方法 线程在重新获取到锁的前提下
 * 从wait的地方继续运行
 * 默认情况下 处于wait状态的线程 如果同步对象没有调用notify方法去唤醒 就会一直处于wait状态
 *
 * notify 方法 每一个同步对象都会有一个等待列表 记录的是被其所wait的线程是哪些
 * notify 方法的作用 是从当前同步对象的等待列表中选择一个线程进行唤醒
 *
 * notifyAll 唤醒同步对象等待列表中 所有处于wait状态的线程
 *
 * @author LYH
 * @date 2023/11/19 15:35
 */
public class Test {
    public static void main(String[] args) {
        final Monster goblin = new Monster();
        goblin.setName("哥布林");
        goblin.setHp(100);
        Thread t1 = new Thread(){
            @Override
            public void run() {
                while (true){
                    goblin.hurt();
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        Thread t2 = new Thread(){
            @Override
            public void run() {
                while (true){
                    goblin.recover();
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        t1.start();
        t2.start();
    }
}
