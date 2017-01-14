package com.blucewang.proxy;

/**
 * Created by bluceWang on 2017/1/7.
 */
public class ReturnTicketProxy extends CarStation implements IReturnTicket {

    private IReturnTicket returnTicket;

    public ReturnTicketProxy(IReturnTicket returnTicket) {
        this.returnTicket = returnTicket;
    }

    public ReturnTicketProxy() {
        this.returnTicket=new CarStation();
    }

    @Override
    public void returnTicke() {
        System.out.println("我是退票代理B");
        long startTime = System.currentTimeMillis();
        returnTicket.returnTicke();
        long endTime = System.currentTimeMillis();
        System.out.println("通过代理B退票所花时间为："+(endTime-startTime)+"毫秒");
    }
}
