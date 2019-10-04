package com.asiainfo.chapter1;

/**
 * 判断线程是否存活
 *
 * @author zhangzhiwang
 * @date Oct 1, 2019 11:48:01 PM
 */
public class MyThread8 extends Thread {
	public void run() {
		System.out.println("run:" + this.isAlive());
	}
	
	public static void main(String[] args) throws InterruptedException {
		MyThread8 myThread8 = new MyThread8();
		System.out.println("new:" + myThread8.isAlive());
		myThread8.start();
		Thread.sleep(1000);
		System.out.println("end:" + myThread8.isAlive());
	}
}
