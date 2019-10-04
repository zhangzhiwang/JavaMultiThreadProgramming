package com.asiainfo;

import java.util.Map;
import java.util.Random;

/**
 * yield()——让出CPU时间片给其他线程，不释放锁
 *
 * @author zhangzhiwang
 * @date Oct 1, 2019 11:48:01 PM
 */
public class MyThread15 extends Thread {
	private int num;
	
	public void run() {
		long begin = System.currentTimeMillis();
		for(int i = 0; i < 5000000; i++) {
			Thread.yield();
			num = num + (i + 1);
		}
		long end = System.currentTimeMillis();
		System.out.println(end - begin);
	}
	
	public static void main(String[] args) {
		MyThread15 myThread15 = new MyThread15();
		myThread15.start();
	}
}
