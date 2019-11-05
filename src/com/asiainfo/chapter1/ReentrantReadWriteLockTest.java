package com.asiainfo.chapter1;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * ReentrantReadWriteLock测试
 *
 * @author zhangzhiwang
 * @date Nov 5, 2019 11:06:34 AM
 */
public class ReentrantReadWriteLockTest {
	private static ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
	public static String s = "abc";

	public static void read() throws InterruptedException {
		lock.readLock().lock();// 读读不互斥
		System.out.println("	" + Thread.currentThread().getName() + "获取了读锁");
//		Thread.sleep(500);
		System.out.println("	" + Thread.currentThread().getName() + "读到的数据是：" + s);
		lock.readLock().unlock();
	}

	public static void write() throws InterruptedException {
		lock.writeLock().lock();// 只要有写的都互斥：读写、写读、写写
		System.out.println(Thread.currentThread().getName() + "获取了写锁");
//		Thread.sleep(500);
		System.out.println(Thread.currentThread().getName() + "write的数据是：---------");
		lock.writeLock().unlock();
	}

	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			Thread t1 = new Thread(new Runnable() {
				@Override
				public void run() {
					try {
						read();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			});
			t1.setName("读线程_" + i);
			t1.start();

			Thread t2 = new Thread(new Runnable() {
				@Override
				public void run() {
					try {
						write();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			});
			t2.setName("写线程_" + i);
			t2.start();
		}
	}
}
