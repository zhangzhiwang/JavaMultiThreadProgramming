package com.asiainfo.chapter4;

import java.util.concurrent.locks.ReentrantLock;

/**
 * getQueueLength方法——获取等待锁的线程数
 *
 * @author zhangzhiwang
 * @date Nov 4, 2019 1:28:40 PM
 */
public class GetQueueLengthTest {
	public static ReentrantLock lock = new ReentrantLock();

	public void met1() throws InterruptedException {
		lock.lock();
		System.out.println(Thread.currentThread().getName() + "持有锁！");
		Thread.sleep(Integer.MAX_VALUE);
		lock.unlock();
	}

	public static void main(String[] args) throws InterruptedException {
		final GetQueueLengthTest getQueueLengthTest = new GetQueueLengthTest();
		for (int i = 0; i < 10; i++) {
			Thread t = new Thread(new Runnable() {
				@Override
				public void run() {
					try {
						getQueueLengthTest.met1();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			});
			t.start();
		}
		
		Thread.sleep(1000);
		System.out.println("等待锁的线程数：" + lock.getQueueLength());
	}
}
