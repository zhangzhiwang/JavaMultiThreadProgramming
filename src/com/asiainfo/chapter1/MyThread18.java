package com.asiainfo.chapter1;

import java.util.Map;
import java.util.Random;

/**
 * 线程的优先级对效率的影响
 *
 * @author zhangzhiwang
 * @date Oct 1, 2019 11:48:01 PM
 */
public class MyThread18 extends Thread {
	long l = 0;
	
	public void run() {
		for (;;) {
				l = l + 1;
		}
	}

	public static void main(String[] args) throws InterruptedException {
			MyThread18 myThread17 = new MyThread18();
			myThread17.setPriority(MIN_PRIORITY);
			myThread17.start();
			
			MyThread17_1 myThread17_1 = myThread17.new MyThread17_1();
			myThread17_1.setPriority(MAX_PRIORITY);
			myThread17_1.start();
			
			Thread.sleep(10000);
			myThread17.stop();
			myThread17_1.stop();
			
			System.out.println("a=" + myThread17.l);
			System.out.println("b=" + myThread17_1.l);
	}

	class MyThread17_1 extends Thread {
		long l = 0;

		public void run() {
			for (;;) {
					l = l + 1;
			}
		}
	}
}
