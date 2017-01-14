package com.blucewang.proxy.jdkproxy;

import java.util.Random;

public class Car implements Moveable {

	@Override
	public void move() {
		try {
			Thread.sleep(new Random().nextInt(1000));
			System.out.println("car is driving");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
