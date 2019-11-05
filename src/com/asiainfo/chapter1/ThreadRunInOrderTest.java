package com.asiainfo.chapter1;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 测试多个线程要按顺序执行业务
 *
 * @author zhangzhiwang
 * @date Nov 5, 2019 10:39:56 AM
 */
public class ThreadRunInOrderTest {
	private static ReentrantLock lock = new ReentrantLock(true);

	public static void met1() throws InterruptedException {
		lock.lock();
		System.out.println(Thread.currentThread().getName() + "运行");
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
