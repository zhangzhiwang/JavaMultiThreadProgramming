package com.asiainfo;

/**
 * 自定义线程类
 *
 * @author zhangzhiwang
 * @date Oct 1, 2019 11:48:01 PM
 */
public class MyThread extends Thread {
	public void run() {
		System.out.println("run");
	}
	
	public static void main(String[] args) throws InterruptedException {
		MyThread myThread = new MyThread();
		myThread.start();
		myThread.start();// 多次调用start()方法会抛出java.lang.IllegalThreadStateException异常
//		Thread.sleep(1);
		System.out.println("结束");
	}
}
