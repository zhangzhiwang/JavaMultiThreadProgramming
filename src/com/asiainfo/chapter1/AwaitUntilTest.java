package com.asiainfo.chapter1;

import java.util.Calendar;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class AwaitUntilTest {
	private static ReentrantLock lock = new ReentrantLock();
	private static Condition condition = lock.newCondition();

	public static void met1() throws InterruptedException {
		lock.lock();
		System.out.println(Thread.currentThread().getName() + "开始等待...");
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.SECOND, 10);
		condition.awaitUntil(calendar.getTime());
		System.out.println(Thread.currentThread().getName() + "等待结束！");
		lock.unlock();
	}
	
	public static void met2() throws InterruptedException {
		lock.lock();
		Thread.sleep(5000);
		condition.signal();
		System.out.println(Thread.currentThread().getName() + "唤醒");
		lock.unlock();
	}

	public static void main(String[] args) throws InterruptedException {
		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					met1();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}).start();
		
		Thread.sleep(10);
		met2();
	}
}
