package com.asiainfo;

/**
 * 线程私有变量和共享变量
 *
 * @author zhangzhiwang
 * @date Oct 1, 2019 11:48:01 PM
 */
public class MyThread6 extends Thread {
	private int i;
	
	public void run() {
		System.out.println(Thread.currentThread().getName() + "----->" + (i++));// 这里会有隐含的线程安全问题：如果run()方法没有同步，则即使println()方法是同步的，但是是先计算i++的值然后才作为println()方法的参数传进去，也就是说在调用println()方法之前已经出现了线程安全问题
	}
	
	public static void main(String[] args) {
		MyThread6 myThread5 = new MyThread6();
		for(int i = 0; i < 5; i++) {
			Thread thread = new Thread(myThread5);
			thread.start();
		}
	}
}
