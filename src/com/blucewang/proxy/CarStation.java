package com.blucewang.proxy;

import java.util.Random;

/**
 * Created by bluceWang on 2017/1/7.
 */
public class CarStation implements IReturnTicket,IBuyTicket {

    @Override
    public void buyTicket() {
        try {
            Thread.sleep(new Random().nextInt(1000));
            System.out.println("����Ʊ�ɹ���");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void returnTicke() {
        System.out.println("��Ʊ�ɹ���");
    }
}
