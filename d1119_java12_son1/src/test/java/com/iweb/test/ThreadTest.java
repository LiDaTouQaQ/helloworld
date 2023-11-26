package com.iweb.test;

import org.junit.Test;

/**
 * @author LYH
 * @date 2023/11/19 9:06
 */
public class ThreadTest {
    @Test
    public void threadTest(){
        // 实例化线程对象
        FightRice fr1 = new FightRice("lyh");
        FightRice fr2 = new FightRice("ldt");
        FightRice fr3 = new FightRice("lxt");
        // 线程的职责是运行完成自己run方法 但是需要注意的是线程需要通过调用start方法
        // 使线程自己进入到就绪态 进入到就绪态的线程 才会有机会被jvm进行调度
        // 单位时间内 只会有一个线程被jvm进行调度
        // jvm选择那个一个线程运行 运行多长时间 是程序员不可控的
        // 哪一个线程被创建 和 start顺序无关 也和线程对象的创建时间无关 只和jvm有关
        fr1.start();
        fr2.start();
        fr3.start();
        // 这调用方式只是普通的对象调用 jvm不会将他识别为线程 调用是顺序执行
        // fr1.run();

    }
}
