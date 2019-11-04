package com.asiainfo.chapter1;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * await(long,TimeUnit)方法——和wait(long)一样，具有自动唤醒的功能
 *
 * @author zhangzhiwang
 * @date Nov 4, 2019 6:10:22 PM
 */
public class AwaitTest {
	public static ReentrantLock lock = new ReentrantLock();
	public static Condition condition = lock.newCondition();

	public static void met1() throws InterruptedException {
		lock.lock();
		condition.await(3, TimeUnit.SECONDS);
		System.out.println("自主唤醒");
		lock.unlock();
	}

	public static void main(String[] args) {
		new Thread(new Runnable() {

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
		}).start();
	}
}
