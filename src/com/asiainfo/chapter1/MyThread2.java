package com.asiainfo.chapter1;

/**
 * 自定义线程类
 *
 * @author zhangzhiwang
 * @date Oct 1, 2019 11:48:01 PM
 */
public class MyThread2 extends Thread {
	public static void main(String[] args) {
		for(int i = 0; i < 5; i++) {
			new MyThread2().start();
		}
	}
	
	public void run() {
		try {
			Thread.sleep(Integer.MAX_VALUE);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
