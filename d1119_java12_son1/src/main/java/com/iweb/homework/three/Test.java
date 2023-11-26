package com.iweb.homework.three;

import java.util.LinkedList;
import java.util.List;

/**
 * @author LYH
 * @date 2023/11/20 15:50
 */
public class Test {
    public static void main(String[] args) {
        List<LittleBlack> blacks = new LinkedList<LittleBlack>();
        Basket basket = new Basket();
        Kun kun = new Kun(basket);
        kun.start();
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < 10; i++) {
            blacks.add(new LittleBlack("小黑子"+i,basket));
        }
        for (LittleBlack black : blacks) {
            black.start();
        }
    }
}
