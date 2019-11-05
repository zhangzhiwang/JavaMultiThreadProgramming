package com.asiainfo.chapter1;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class AwaitNotifyTest {
	private static ReentrantLock lock = new ReentrantLock();
	private static Condition condition = lock.newCondition();

	public static void met1() throws InterruptedException {
		lock.lock();
		System.out.println(Thread.currentThread().getName() + "开始等待...");
//		condition.await();// await()和wait()一样，在等待的过程中都不能被打断，否则会抛异常，但是二者不能被打断的原理不一样，可以看下两者的源码。
		condition.awaitUninterruptibly();// 不受interrupt()的影响，充分说明了当其他线程调用该线程的interrupt()方法时只是建议该线程可以停止了，但是否接受该建议有该线程说的算
		System.out.println(Thread.currentThread().getName() + "等待结束！");
		lock.unlock();
	}

	public static void main(String[] args) throws InterruptedException {
		Thread t = new Thread(new Runnable() {
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
		t.start();

		Thread.sleep(3000);
		t.interrupt();
	}
}
