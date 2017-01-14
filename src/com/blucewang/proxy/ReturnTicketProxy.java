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
        System.out.println("������Ʊ����B");
        long startTime = System.currentTimeMillis();
        returnTicket.returnTicke();
        long endTime = System.currentTimeMillis();
        System.out.println("ͨ������B��Ʊ����ʱ��Ϊ��"+(endTime-startTime)+"����");
    }
}
