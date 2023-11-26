package com.iweb.test1;

/** 消费者负责处理馒头 所有消费者线程绑定的篮子必须是同一个
 * @author LYH
 * @date 2023/11/22 19:00
 */
public class Consumer implements Runnable{
    private Basket bt;
    public Consumer(Basket bt){
        this.bt = bt;
    }

    public void run() {
        for (int i = 0; i < 20; i++) {
            ManTou mt = bt.pop();
            System.out.println("消费者消费了"+mt);
        }
    }
}
