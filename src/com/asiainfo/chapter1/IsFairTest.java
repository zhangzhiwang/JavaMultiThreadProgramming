package com.asiainfo.chapter1;

import java.util.concurrent.locks.ReentrantLock;

/**
 * isFair方法——判断是否为公平锁
 *
 * @author zhangzhiwang
 * @date Nov 4, 2019 5:18:21 PM
 */
public class IsFairTest {
	public static void main(String[] args) {
		ReentrantLock lock = new ReentrantLock();// 默认为非公平锁
		System.out.println(lock.isFair());
		ReentrantLock lock2 = new ReentrantLock(true);
		System.out.println(lock2.isFair());
		ReentrantLock lock3 = new ReentrantLock(false);
		System.out.println(lock3.isFair());
	}
}
