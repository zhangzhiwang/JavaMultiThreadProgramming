package com.asiainfo.chapter1;

import java.util.Map;
import java.util.Random;

/**
 * 守护线程
 *
 * @author zhangzhiwang
 * @date Oct 1, 2019 11:48:01 PM
 */
public class MyThread19 extends Thread {
	public void run() {
		for(int i = 0; i < 100; i++) {
			System.out.println(i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		MyThread19 myThread19 = new MyThread19();
		myThread19.setDaemon(false);
		myThread19.start();
		
		Thread.sleep(5000);
		System.out.println("用户线程结束");
	}
}
