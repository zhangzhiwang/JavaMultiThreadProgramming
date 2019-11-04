package com.asiainfo.chapter1;

import java.util.concurrent.locks.ReentrantLock;

public class LockInterruptiblyTest {
	private static ReentrantLock lock = new ReentrantLock();

	public static void met1() throws InterruptedException {
//		lock.lock();
		lock.lockInterruptibly();
		System.out.println(Thread.currentThread().getName() + "进入met1方法");
		Thread.sleep(Integer.MAX_VALUE);
		lock.unlock();
	}

	public static void main(String[] args) throws InterruptedException {
		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					met1();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		t1.start();

		Thread.sleep(10);
		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					met1();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		t2.start();
		
		Thread.sleep(3000);
		t2.interrupt();
		Thread.sleep(10);
		System.out.println(t2.isAlive());
	}
}
