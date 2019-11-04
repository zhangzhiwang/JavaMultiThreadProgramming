package com.asiainfo.chapter1;

import java.util.concurrent.locks.ReentrantLock;

/**
 * isHeldByCurrentThread方法——当前线程是否持有该锁
 *
 * @author zhangzhiwang
 * @date Nov 4, 2019 5:22:15 PM
 */
public class IsHeldByCurrentThreadTest {
	private static ReentrantLock lock = new ReentrantLock();
	
	public static void main(String[] args) {
		System.out.println(lock.isHeldByCurrentThread());
		lock.lock();
		System.out.println(lock.isHeldByCurrentThread());
	}
}
