package com.asiainfo.chapter1;

/**
 * 线程私有变量和共享变量
 *
 * @author zhangzhiwang
 * @date Oct 1, 2019 11:48:01 PM
 */
public class MyThread5 extends Thread {
	private int i;
	
	public synchronized void run() {
		i++;
		System.out.println(Thread.currentThread().getName() + "----->" + i);
	}
	
	public static void main(String[] args) {
		MyThread5 myThread5 = new MyThread5();
		for(int i = 0; i < 5; i++) {
			Thread thread = new Thread(myThread5);
			thread.start();
		}
	}
}
