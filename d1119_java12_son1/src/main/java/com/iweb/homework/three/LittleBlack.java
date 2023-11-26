package com.iweb.homework.three;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author LYH
 * @date 2023/11/20 15:47
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LittleBlack extends Thread{
    private String blackName;
    private Basket basket;

    @Override
    public void run() {
        getEgg();
    }

    public void getEgg(){
        while (true){
            synchronized (basket.getBasket()){
                System.out.println(blackName+"试图拿蛋");
                if(basket.getSize()==0){
                    try {
                        System.out.println(blackName+"没蛋还拿剁手");
                        basket.getBasket().wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }else{
                    basket.remove();
                    System.out.println(blackName +"取出一个蛋,篮子的里蛋的数量"+basket.getSize());
                    basket.getBasket().notify();
                }
            }
        }
    }
}
