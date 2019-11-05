package com.asiainfo.chapter1;

import java.util.concurrent.locks.ReentrantLock;

/**
 * ReentranLock效率测试
 *
 * @author zhangzhiwang
 * @date Nov 5, 2019 10:51:02 AM
 */
public class ReentranLockTest {
	private static ReentrantLock lock = new ReentrantLock();// ReentrantLock可以实现同步的效果，但它是严格的同步，即所有操作都进行同步哪怕只有读操作
	public static String s = "abc";

	public static void met1() throws InterruptedException {
		lock.lock();
		System.out.println(Thread.currentThread().getName() + "开始读取数据:");
		System.out.println(Thread.currentThread().getName() + "读到的数据是：" + s);
//		Thread.sleep(1000);
		lock.unlock();
	}

	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					try {
						met1();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}).start();
		}
	}
}
