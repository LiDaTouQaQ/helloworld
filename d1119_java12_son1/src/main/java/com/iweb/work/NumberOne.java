package com.iweb.work;

import java.util.Random;

/**
 * @author LYH
 * @date 2023/11/19 11:00
 */
public class NumberOne extends Thread {
    public volatile static boolean start = true;
    public volatile boolean skillStart = false;
    public volatile boolean strikes = false;
    public static Random r = new Random();
    public synchronized void isStrikes() throws InterruptedException {
        while (start){
            Thread.sleep(1000);
            System.out.println("大理石出手了");
            if(r.nextInt(100)<70 & start & skillStart){
                System.out.println("大理石打断技能");
                setStrickes();
                setSkillStart();
            }
        }
    }
    public NumberOne(){
    }
    public synchronized void setStrickes(){
        this.strikes = !this.strikes;
    }
    public void game() throws InterruptedException {
        while (start){
            skill("接");
            skill("化");
            skill("发");
            skill("闪电五连鞭");
            if(r.nextInt(100)<5){
                start = false;
                System.out.println("马老师被击败了");
            }
        }
    }
    public synchronized void setSkillStart(){
        this.skillStart = !this.skillStart;
    }
    public void skill(String name) throws InterruptedException {
        Thread.sleep(1000);
        if(!this.strikes){
            System.out.println("释放技能: "+name);
        }else{
            System.out.println("技能"+name+"释放失败");
            setStrickes();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        final NumberOne n = new NumberOne();
        Thread t1 = new Thread(){
            @Override
            public void run() {
                try {
                    n.game();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        Thread t2 = new Thread(){
            @Override
            public void run() {
                try {
                    n.isStrikes();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };
        t1.start();
        t2.start();
    }
}
