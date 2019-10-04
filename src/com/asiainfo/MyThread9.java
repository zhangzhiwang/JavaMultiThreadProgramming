package com.asiainfo;

/**
 * sleep()方法
 *
 * @author zhangzhiwang
 * @date Oct 1, 2019 11:48:01 PM
 */
public class MyThread9 extends Thread {
	public void run() {
		System.out.println("run begin...");
		try {
			Thread.sleep(15000);// 当前线程休眠
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("run end!");
	}
	
	public static void main(String[] args) throws InterruptedException {
//		MyThread9 myThread9 = new MyThread9();
//		System.out.println("main begin...");
////		myThread9.run();
//		myThread9.start();
//		System.out.println("main end!");
		
		long begin = System.currentTimeMillis();
		Thread.sleep(2000,999999);
		long end = System.currentTimeMillis();
		System.out.println(end - begin);
	}
}
