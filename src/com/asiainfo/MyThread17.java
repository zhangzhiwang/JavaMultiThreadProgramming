package com.asiainfo;

import java.util.Map;
import java.util.Random;

/**
 * 线程的优先级高会获得更多的机会运行
 *
 * @author zhangzhiwang
 * @date Oct 1, 2019 11:48:01 PM
 */
public class MyThread17 extends Thread {
	public void run() {
		long begin = System.currentTimeMillis();
		long l = 0;
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 50000; j++) {
				Random random = new Random();
				random.nextDouble();
				l = l + j;
			}
		}
		long end = System.currentTimeMillis();
		System.out.println("+++++++++++线程1+++++++++:" + (end - begin));
	}

	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			MyThread17 myThread17 = new MyThread17();
			myThread17.setPriority(MIN_PRIORITY);
			myThread17.start();
			
			MyThread17_1 myThread17_1 = myThread17.new MyThread17_1();
			myThread17_1.setPriority(MAX_PRIORITY);
			myThread17_1.start();
		}
	}

	class MyThread17_1 extends Thread {
		public void run() {
			long begin = System.currentTimeMillis();
			long l = 0;
			for (int i = 0; i < 10; i++) {
				for (int j = 0; j < 50000; j++) {
					Random random = new Random();
					random.nextDouble();
					l = l + j;
				}
			}
			long end = System.currentTimeMillis();
			System.out.println("------------线程2:" + (end - begin) + "------------");
		}
	}
}
