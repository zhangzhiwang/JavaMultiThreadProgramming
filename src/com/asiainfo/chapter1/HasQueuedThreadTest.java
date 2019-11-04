package com.asiainfo.chapter1;

import java.util.concurrent.locks.ReentrantLock;

/**
 * hasQueuedThread(Thread)方法——某线程是否在该锁的等待队列里面，即某线程是否在等待获取该锁
 *
 * @author zhangzhiwang
 * @date Nov 4, 2019 4:48:42 PM
 */
public class HasQueuedThreadTest {
	private static ReentrantLock lock = new ReentrantLock();

	public void met1() throws InterruptedException {
		lock.lock();
		Thread.sleep(5);
		lock.unlock();
	}

	public static void main(String[] args) throws InterruptedException {
		final HasQueuedThreadTest hasQueuedThreadTest = new HasQueuedThreadTest();
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					hasQueuedThreadTest.met1();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		t1.setName("t1");
		t1.start();
		
		Thread.sleep(10);
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					hasQueuedThreadTest.met1();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		t2.setName("t2");
		t2.start();
		
		Thread.sleep(10);
		System.out.println(lock.hasQueuedThread(t1));
		System.out.println(lock.hasQueuedThread(t2));
		System.out.println(lock.hasQueuedThreads());
	}
}
