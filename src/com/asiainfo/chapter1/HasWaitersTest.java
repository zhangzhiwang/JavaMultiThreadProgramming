package com.asiainfo.chapter1;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * hasWaiters(Condition)方法——有没有该因调用该Condition的await方法而处于等待状态的线程
 *
 * @author zhangzhiwang
 * @date Nov 4, 2019 5:03:23 PM
 */
public class HasWaitersTest {
	public static ReentrantLock lock = new ReentrantLock();
	public static Condition condition = lock.newCondition();
	
	public void met1() throws InterruptedException {
		lock.lock();
		condition.await();
		lock.unlock();
	}
	
	public void met2() {
		lock.lock();
		System.out.println("有没有处于等待的线程？" + lock.hasWaiters(condition) + "，具体数量有：" + lock.getWaitQueueLength(condition));
		condition.signalAll();
		lock.unlock();
	}
	
	public static void main(String[] args) throws InterruptedException {
		final HasWaitersTest hasWaitersTest = new HasWaitersTest();
		
		for(int i = 0; i < 10; i++) {
			Thread t = new Thread(new Runnable() {

				@Override
				public void run() {
					// TODO Auto-generated method stub
					try {
						hasWaitersTest.met1();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}});
			t.start();
		}
		
		Thread.sleep(100);
		hasWaitersTest.met2();
	}
}
