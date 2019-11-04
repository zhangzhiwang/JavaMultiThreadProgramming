package com.asiainfo.chapter4;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 公平锁
 *
 * @author zhangzhiwang
 * @date Nov 4, 2019 1:03:55 PM
 */
public class FairLock {
	public static Lock lock = new ReentrantLock(false);// 默认是非公平锁
	public static Condition condition = lock.newCondition();
	
	public void met1() throws InterruptedException {
		lock.lock();
		System.out.println("met1 " + Thread.currentThread().getName());
//		Thread.sleep(1000);
		lock.unlock();
	}
	
	public static void main(String[] args) {
		FairLock fairLock = new FairLock();
		
		for(int i = 0; i < 10; i++) {
			ThreadF threadF = new ThreadF(fairLock);
			threadF.setName("FFF_" + i);
			threadF.start();
		}
	}
}
