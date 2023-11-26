package com.iweb.work.answer.one;

import lombok.Data;

import java.util.Random;

/**
 * @author LYH
 * @date 2023/11/19 11:40
 */
@Data
public class Hercules extends Thread{
    private int count = 0;
    public void run(){
        Random r = new Random();
        while (true){
            count = r.nextInt(100)+1;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
