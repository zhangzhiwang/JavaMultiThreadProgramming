package com.asiainfo.chapter4;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 使用多个condition
 *
 * @author zhangzhiwang
 * @date Nov 4, 2019 8:02:29 AM
 */
public class TestMultiCondition {
	private static Lock lock = new ReentrantLock();
	private static Condition condition1 = lock.newCondition(); 
	private static Condition condition2 = lock.newCondition(); 
	
	public void met1() throws InterruptedException {
		lock.lock();
		System.out.println("met1 begin:" + Thread.currentThread().getName());
		condition1.await();
		System.out.println("met1 end:" + Thread.currentThread().getName());
		lock.unlock();
	}
	
	public void met2() throws InterruptedException {
		lock.lock();
		System.out.println("met2 begin:" + Thread.currentThread().getName());
		condition2.await();
		System.out.println("met2 end:" + Thread.currentThread().getName());
		lock.unlock();
	}
	
	public void signalAll_1() {
		lock.lock();
		condition1.signal();
		lock.unlock();
	}
	
	public static void main(String[] args) throws InterruptedException {
		TestMultiCondition testMultiCondition = new TestMultiCondition();
		ThreadD d1 = new ThreadD(testMultiCondition);
		d1.setName("d1");
		d1.start();
		ThreadD d2 = new ThreadD(testMultiCondition);
		d2.setName("d2");
		d2.start();
		
		ThreadE e1 = new ThreadE(testMultiCondition);
		e1.setName("e1");
		e1.start();
		ThreadE e2 = new ThreadE(testMultiCondition);
		e2.setName("e2");
		e2.start();
		
		Thread.sleep(3000);
		testMultiCondition.signalAll_1();
	}
}
