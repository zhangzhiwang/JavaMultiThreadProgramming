package com.asiainfo.chapter1;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * tryLock方法——尝试获得锁，如果获得了锁就进入临界区执行代码，如果没进入就继续运行同步区之外的代码而非进行阻塞获得锁</p>
 * tryLock(timeout, unit)——最多等待timeout这么长时间来获取锁，如果还获取不到就继续运行同步区之外的代码
 *
 * @author zhangzhiwang
 * @date Nov 4, 2019 5:55:46 PM
 */
public class TryLockTest {
	private static ReentrantLock lock = new ReentrantLock();

	public static void met1() throws InterruptedException {
		if (lock.tryLock(5, TimeUnit.SECONDS)) {
			System.out.println(Thread.currentThread().getName() + "获得了该锁");
			Thread.sleep(3000);
			lock.unlock();
		} else {
			System.out.println(Thread.currentThread().getName() + "继续运行同步块之外的代码");
		}
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

		Thread.sleep(100);
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
	}
}
