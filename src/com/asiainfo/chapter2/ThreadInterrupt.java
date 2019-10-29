package com.asiainfo.chapter2;

/**
 * 关于interrupted()和isInterrupted()方法
 *
 * @author zhangzhiwang
 * @date Oct 11, 2019 8:36:01 PM
 */
public class ThreadInterrupt {
	public static void main(String[] args) throws InterruptedException {
		MyThread myThread = new MyThread();
		myThread.start();
		
		Thread.sleep(2000);
		myThread.interrupt();
		
		System.out.println(myThread.isInterrupted());
		System.out.println(myThread.interrupted());
	}
	
	static class MyThread extends Thread {
		public void run() {
//			System.out.println("hello");
			while(true) {}
		}
	}
}
