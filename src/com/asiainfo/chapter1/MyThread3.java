package com.asiainfo.chapter1;

/**
 * 执行start()的顺序不代表线程执行的顺序，即不是谁先启动的start()就先运行谁的run()方法
 *
 * @author zhangzhiwang
 * @date Oct 1, 2019 11:48:01 PM
 */
public class MyThread3 extends Thread {
	private int i;

	public MyThread3(int i) {
		super();
		this.i = i;
	}

	public static void main(String[] args) {
		for (int i = 0; i < 20; i++) {
			MyThread3 myThread3 = new MyThread3(i);
			myThread3.start();
		}
	}

	public void run() {
		System.out.println(i);
	}
}
