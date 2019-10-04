package com.asiainfo.chapter1;

import java.util.Map;
import java.util.Random;

/**
 * 线程的优先级
 *
 * @author zhangzhiwang
 * @date Oct 1, 2019 11:48:01 PM
 */
public class MyThread16 extends Thread {
	public void run() {
		System.out.println("MyThread16:" + Thread.currentThread().getPriority());
		MyThread16_1 myThread16_1 = new MyThread16_1();
		myThread16_1.start();
	}
	
	public static void main(String[] args) {
		System.out.println("max:" + Thread.MAX_PRIORITY);
		System.out.println("min:" + Thread.MIN_PRIORITY);
		System.out.println("normal:" + Thread.NORM_PRIORITY);
		System.out.println("main1:" + Thread.currentThread().getPriority());
		Thread.currentThread().setPriority(6);
		System.out.println("main2:" + Thread.currentThread().getPriority());
		MyThread16 myThread16 = new MyThread16();
		myThread16.start();
	}
	
	class MyThread16_1 extends Thread {
		public void run() {
			System.out.println("----16_1:" + Thread.currentThread().getPriority());
		}
	}
}
