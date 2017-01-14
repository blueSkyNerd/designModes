package com.blucewang.proxy;

/**
 * Created by bluceWang on 2017/1/7.
 */
public class BuyTicketProxy extends CarStation implements IBuyTicket {

    private IBuyTicket buyTicket;

    public BuyTicketProxy(IBuyTicket buyTicket) {
        this.buyTicket = buyTicket;
    }
    public BuyTicketProxy() {
        this.buyTicket= new CarStation();
    }

    @Override
    public void buyTicket() {
        System.out.println("������Ʊ����A");
        long startTime = System.currentTimeMillis();
        buyTicket.buyTicket();
        long endTiem = System.currentTimeMillis();
        System.out.println("ͨ��A������Ʊ����ʱ��Ϊ"+(endTiem-startTime)+"����");
    }
}
