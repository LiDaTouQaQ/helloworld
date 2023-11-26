package com.iweb.work.answer.two;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LYH
 * @date 2023/11/19 13:50
 */
public class Test {
    public static void main(String[] args) {
        TicketShop ticketShop = new TicketShop();
        List<Ikun> littleBlack = new ArrayList<Ikun>();
        for (int i = 0; i < 30; i++) {
            Ikun ikun = new Ikun(ticketShop,"ikun"+i);
            littleBlack.add(ikun);
        }
        for (Ikun i :littleBlack) {
            i.start();
        }
    }
}
