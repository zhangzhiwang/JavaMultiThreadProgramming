package com.asiainfo.chapter4;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 测试ReentrantLock
 *
 * @author zhangzhiwang
 * @date 2019年11月3日 下午3:08:04
 */
public class TestReentrantLock {
	public Lock lock = new ReentrantLock();
	public Condition condition = lock.newCondition();
	
	public void met1() {
		lock.lock();
		for(int i = 0 ; i < 5; i++) {
			System.out.println(Thread.currentThread().getName() + " run met1---->" + i);
		}
		
//		lock.unlock();
	}
	
	public void met2() {
		lock.lock();
		for(int i = 0 ; i < 5; i++) {
			System.out.println("	" + Thread.currentThread().getName() + " run met2---->" + i);
		}
		
		lock.unlock();
	}
	
	public void met3() throws InterruptedException {
		lock.lock();
		System.out.println("A");
		condition.await(5, TimeUnit.SECONDS);// 和wait()方法一样，必须在同步块内使用，所以await()方法必须在lock()和unlock()方法之间使用，而且await()方法也释放锁
		System.out.println("await end!");
		lock.unlock();
	}
	
	public void met4() throws InterruptedException {
		lock.lock();
		System.out.println("B");
		condition.signalAll();// 相当于notify/notifyAll
		lock.unlock();
	}
	
	public static void main(String[] args) throws InterruptedException {
		TestReentrantLock testReentrantLock = new TestReentrantLock();
		
//		for(int i = 0; i < 3; i++) {
//			new ThreadA(testReentrantLock).start();
//			new ThreadB(testReentrantLock).start();
//			new ThreadC(testReentrantLock).start();
//		}
		
		new ThreadC(testReentrantLock).start();
		
		Thread.sleep(2000);
		
		testReentrantLock.met4();
	}
}
