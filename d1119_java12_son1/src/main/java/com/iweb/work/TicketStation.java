package com.iweb.work;

import java.util.Random;

/**
 * @author LYH
 * @date 2023/11/19 11:23
 */
public class TicketStation extends Thread {
    public Ticket[] tickets = new Ticket[5];
    public Person[] people = new Person[30];
    public int count = 0;
    public TicketStation(){
        for (int i = 0; i < 5; i++) {
            tickets[i].buy = false;
            tickets[i].name = "票"+i;
        }
        for (int i = 0; i < 30; i++) {
            people[i].name = "用户"+i;
        }
    }
    public void getTicker(Person person){
        Random r = new Random();
        int num = r.nextInt(5);
        if(!tickets[num].buy){
            tickets[num].buy = true;
            tickets[num].name += person.name;
            count++;
        }
    }

    public static void main(String[] args) {
        final TicketStation ts = new TicketStation();
        final Thread t1 = new Thread(){
            @Override
            public void run() {
                if(ts.count==5){
                    System.out.println("抢票结束了");
                }
            }
        };
        t1.start();

    }
}
