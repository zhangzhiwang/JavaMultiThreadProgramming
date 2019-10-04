package com.asiainfo.chapter1;

import java.util.Map;
import java.util.Random;

/**
 * 当sleep()遇上interrupt()
 *
 * @author zhangzhiwang
 * @date Oct 1, 2019 11:48:01 PM
 */
public class MyThread14 extends Thread {
	public void run() {
		System.out.println("run start...");
		for(int i = 0; i < 5000000; i++) {
			System.out.println(i++);
			
		}
		try {
			Thread.sleep(1000000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("run end!");
	}
	
	public static void main(String[] args) throws InterruptedException {
		MyThread14 myThread14 = new MyThread14();
		myThread14.start();
		myThread14.interrupt();// interrupt()和sleep()方法无论谁先调用都会抛异常：java.lang.InterruptedException: sleep interrupted
		Thread.sleep(2000);
		
		System.out.println("main end!");
	}
}
