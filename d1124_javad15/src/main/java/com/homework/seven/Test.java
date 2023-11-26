package com.homework.seven;

/**
 * @author LYH
 * @date 2023/11/24 22:03
 */
public class Test {
    public static int num = 0;

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            Thread t = new Thread(){
                @Override
                public void run() {
                    while (true){
                        synchronized (Test.class){
                            System.out.println("我是进程"+this.getName()+"获取到线程，此时num值为:"+num);
                            num++;
                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            };
            t.setName("线程"+i);
            t.start();
        }
    }
}
