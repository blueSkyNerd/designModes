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
        System.out.println("我是买票代理A");
        long startTime = System.currentTimeMillis();
        buyTicket.buyTicket();
        long endTiem = System.currentTimeMillis();
        System.out.println("通过A代理买票花的时间为"+(endTiem-startTime)+"毫秒");
    }
}
