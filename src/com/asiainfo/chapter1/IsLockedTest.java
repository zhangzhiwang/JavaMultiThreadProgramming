package com.asiainfo.chapter1;

import java.util.concurrent.locks.ReentrantLock;

/**
 * isLocked方法——该锁是否已经被锁住（尚未释放）
 *
 * @author zhangzhiwang
 * @date Nov 4, 2019 5:26:12 PM
 */
public class IsLockedTest {
private static ReentrantLock lock = new ReentrantLock();
	
	public static void main(String[] args) {
		System.out.println(lock.isLocked());
		lock.lock();
		System.out.println(lock.isLocked());
	}
}
