package com.iweb.work.answer.two;

/**
 * @author LYH
 * @date 2023/11/19 13:45
 */
public class Ikun extends Thread{
    private String name;
    private TicketShop ticketShop;
    @Override
    public void run() {
        Ticket ticket = ticketShop.getTicket();
        if(ticket == null){
            System.out.println(name+"没有抢到票");
        }else{
            System.out.println(name+"抢到票"+ticket.getSno());
        }
    }
    public Ikun(TicketShop ticketShop,String name){
        this.ticketShop = ticketShop;
        this.name = name;
    }
}
