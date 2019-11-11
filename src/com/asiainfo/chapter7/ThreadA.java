package com.asiainfo.chapter7;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadA extends Thread {
	private ThreadStateTest threadStateTest;
	private ReentrantLock lock = new ReentrantLock();
	private Condition condition = lock.newCondition();
	
	
	public ThreadA() {
		super();
	}

	public ThreadA(ThreadStateTest threadStateTest) {
		super();
		this.threadStateTest = threadStateTest;
	}

//	public void run() {
//		System.out.println(Thread.currentThread().getName() + "的状态为：" + Thread.currentThread().getState());
//	}
	
	public void run() {
		try {
			met1();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void met1() throws InterruptedException {
//		synchronized (threadStateTest) {
			System.out.println(Thread.currentThread().getName() + "------>met1");
			Thread.sleep(100000);
//			threadStateTest.wait(100000);
//		}
	}
	
	public void met2() throws InterruptedException {
		lock.lock();
		condition.await(100, TimeUnit.SECONDS);
		lock.lock();
	}
}
