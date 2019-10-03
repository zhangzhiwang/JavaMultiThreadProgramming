package com.asiainfo;

/**
 * 通过实现Runnable接口还创建自定义线程
 *
 * @author zhangzhiwang
 * @date Oct 2, 2019 4:20:03 PM
 */
public class MyRunnable implements Runnable {
	public void run() {
		System.out.println("hello");
	}
	
	public static void main(String[] args) {
		MyRunnable myRunnable = new MyRunnable();
		Thread thread = new Thread(myRunnable);
		thread.start();
		System.out.println("end");
	}
}
