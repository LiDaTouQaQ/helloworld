package com.iweb.test3;

import org.junit.experimental.theories.Theories;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author LYH
 * @date 2023/11/23 18:09
 */
public class Test {
    private static String now(){
        return new SimpleDateFormat("HH:mm:ss").format(new Date());
    }

    private static void log(String msg){
        System.out.printf("%s %s %s %n",now(),Thread.currentThread().getName(),msg);
    }

    public static void main(String[] args) {
        // 悲观锁的另一种实现方式 Reentrantlock
        // synchronized 会出现死锁的情况
        // Reentrantlock 不会出现线程死锁的情况 锁的获取和释放是通过调用方法实现的

        Lock lock = new ReentrantLock();
        Thread t1 = new Thread(){
            @Override
            public void run() {
                log("线程启动");
                log("试图获取锁");
                // 线程获取锁 同步对象 是lock对象自己
                lock.lock();
                log("获取到对象锁");
                log("模拟五秒的业务操作");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    log("释放锁");
                    lock.unlock();
                }
                log("线程运行结束");
            }
        };
        t1.setName("t1");
        t1.start();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Thread t2 = new Thread(){
            @Override
            public void run() {
                log("线程启动");
                log("试图获取锁");
                // 线程获取锁 同步对象 是lock对象自己
                lock.lock();
                log("获取到对象锁");
                log("模拟五秒的业务操作");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    log("释放锁");
                    lock.unlock();
                }
                log("线程运行结束");
            }
        };
        t2.setName("t2");
        t2.start();

        // 使用synchronized 进行线程调度 使用的是wait notify 和 notifyAll 方法
        // lock提供了类似的方法 先通过lock对象获取一个Condition对象
        // 调用该对象的await signal signalAll方法
        // Lock lock = new ReentrantLock();
        // Condition condition = lock.newCondition();
        // Thread t1 = new Thread(){
        //     @Override
        //     public void run() {
        //         try{
        //             log("线程启动");
        //             log("尝试获取到锁");
        //             lock.lock();
        //             log("获取到锁");
        //             log("五秒业务状态");
        //             Thread.sleep(5000);
        //             log("调用await方法临时释放锁 并进入到等待状态");
        //             condition.await();
        //             log("重新获取到锁 并且再进行五秒的业务操作");
        //             Thread.sleep(5000);
        //         }catch (Exception e){
        //             e.printStackTrace();
        //         }finally {
        //             log("释放锁");
        //             lock.unlock();
        //         }
        //     }
        // };
        // t1.setName("t1");
        // t1.start();
        // Thread t2 = new Thread(){
        //     @Override
        //     public void run() {
        //         try{
        //             log("线程启动");
        //             log("试图获取锁");
        //             lock.lock();
        //             log("获取到锁");
        //             log("模拟五秒操作");
        //             Thread.sleep(5000);
        //             log("唤醒处于wait状态的线程");
        //             condition.signal();
        //         }catch (Exception e){
        //             e.printStackTrace();
        //         }finally {
        //             log("释放锁");
        //             lock.unlock();
        //         }
        //         log("线程启动");
        //     }
        // };
        // t2.setName("t2");
        // t2.start();

        // // trylock() 试图获取锁
        // Lock lock = new ReentrantLock();
        // Thread t1 = new Thread(){
        //     boolean locked = false;
        //     @Override
        //     public void run() {
        //         try{
        //             log("线程启动");
        //             log("试图获取锁");
        //             // 线程会尝试去获取锁 但是只获取一秒
        //             // 如果获取到了 则方法返回值true
        //             // 如果获取不到 则返回false 并且放弃获取 直接执行后续代码
        //             locked = lock.tryLock(1, TimeUnit.SECONDS);
        //             if(locked){
        //                 log("成功获取到锁");
        //                 log("模拟五秒业务");
        //                 Thread.sleep(5000);
        //             }else{
        //                 log("经过一秒的尝试 没有获取到锁");
        //             }
        //         }catch (Exception e){
        //             e.printStackTrace();
        //         }finally {
        //             if(locked){
        //                 log("释放锁");
        //                 lock.unlock();
        //             }
        //         }
        //     }
        // };
        // t1.setName("t1");
        // t1.start();
        // try {
        //     Thread.sleep(2000);
        // } catch (InterruptedException e) {
        //     e.printStackTrace();
        // }
        // Thread t2 = new Thread(){
        //     boolean locked = false;
        //     @Override
        //     public void run() {
        //         try{
        //             log("线程启动");
        //             log("试图获取锁");
        //             // 线程会尝试去获取锁 但是只获取一秒
        //             // 如果获取到了 则方法返回值true
        //             // 如果获取不到 则返回false 并且放弃获取 直接执行后续代码
        //             locked = lock.tryLock(1, TimeUnit.SECONDS);
        //             if(locked){
        //                 log("成功获取到锁");
        //                 log("模拟五秒业务");
        //                 Thread.sleep(5000);
        //             }else{
        //                 log("经过一秒的尝试 没有获取到锁");
        //             }
        //         }catch (Exception e){
        //             e.printStackTrace();
        //         }finally {
        //             if(locked){
        //                 log("释放锁");
        //                 lock.unlock();
        //             }
        //         }
        //     }
        // };
        // t2.setName("t2");
        // t2.start();

        // Reentrantlock 和 synchronized 的区别
        // 1.lock 本质是个接口 而 synchronized 是Java中的关键字
        // synchronized是内置语言实现 Lock是代码层面的实现
        // 2.lock可以选择性的获取锁 如果一段时间内获取不到锁 就会放弃
        // synchronized 不可以 所以可以利用trylock的特性
        // 有效的避免死锁 而synchronized必须通过谨慎和良好的设计
        // 才能减少死锁的发生
        // 3.synchronized再发生异常或者让同步代码块运行结束的时候
        // 会自动释放锁 而lock接口必须通过调用unlock方法来手动释放锁
        // 如果忘记释放锁 一样会有锁

        // 悲观锁的意思是 会悲观的认为所有线程都会修改数据 是一种排他锁

        // 原子操作 不可以被线程中断的操作
        // 具备原子性的操作
        int a = 1;
        System.out.println("");
        // 不具备原子性
        a++;

        // java中提供了一些类 叫做原子类
        // 原子类的所有操作都是线程安全的(具有原子性)
        AtomicInteger ai = new AtomicInteger();
        // ConcurrentHashMap 线程安全的hashMap 使用的乐观锁
        // HashTable也是安全的 但是使用的是synchronized关键字
        // 是悲观锁
        ConcurrentHashMap chm = new ConcurrentHashMap<>();
        // ConcurrentHashMap在jdk1.7使用的是分段锁 Segment
        // ConcurrentHashMap在jdk1.8使用的是自旋锁
        // 自旋锁的本质是死循环 一直尝试获取锁 如果获取锁的时候
        // 锁被其他线程所持有 通过循环在下一次继续尝试
        // 可以有效避免阻塞


    }
}
