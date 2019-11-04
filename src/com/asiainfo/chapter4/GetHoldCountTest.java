package com.asiainfo.chapter4;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * getHoldCount方法，记录持有锁的次数（每lock一次次数加1，每unlock一次次数减1，用于计算锁重入的次数）
 *
 * @author zhangzhiwang
 * @date Nov 4, 2019 1:18:03 PM
 */
public class GetHoldCountTest {
	public static ReentrantLock lock = new ReentrantLock();

	public void met1() {
		System.out.println(lock.getHoldCount());
		lock.lock();
		lock.lock();
		lock.lock();
		lock.lock();
		lock.lock();
		lock.lock();
		lock.lock();
		lock.lock();
		System.out.println(lock.getHoldCount());
		lock.unlock();
		System.out.println(lock.getHoldCount());
		lock.lock();
		System.out.println(lock.getHoldCount());
		met2();
		System.out.println(lock.getHoldCount());
	}

	public void met2() {
		System.out.println("	" + lock.getHoldCount());
		lock.lock();
		System.out.println("	" + lock.getHoldCount());
		met3();
		System.out.println("	" + lock.getHoldCount());
		lock.unlock();
	}

	public void met3() {
		lock.lock();
		System.out.println("		" + lock.getHoldCount());
		lock.unlock();
	}

	public static void main(String[] args) {
		final GetHoldCountTest getHoldCountTest = new GetHoldCountTest();
		Thread thread = new Thread(new Runnable() {
			@Override
			public void run() {
				getHoldCountTest.met1();
			}
		});
		thread.start();
	}
}
