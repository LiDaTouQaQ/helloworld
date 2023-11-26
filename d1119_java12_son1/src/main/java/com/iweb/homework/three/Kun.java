package com.iweb.homework.three;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author LYH
 * @date 2023/11/20 15:38
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Kun extends Thread{
    private Basket basket;

    @Override
    public void run() {
        egg();
    }

    public void egg(){
        while (true){
            synchronized (basket.getBasket()){
                System.out.println("哥哥试图下单");
                if(basket.getSize()==10){
                    try {
                        System.out.println("哥哥不能下单，502封住");
                        basket.getBasket().wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }else{
                    basket.add();
                    System.out.println("哥哥下了一个蛋，篮子里面蛋的个数"+basket.getSize());
                    basket.getBasket().notify();
                }
            }

        }
    }
}
