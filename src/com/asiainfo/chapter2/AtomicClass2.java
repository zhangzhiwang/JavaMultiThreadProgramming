package com.asiainfo.chapter2;

import java.util.concurrent.atomic.AtomicInteger;

import com.asiainfo.chapter2.VolatileNotAtomic.Count;

/**
 * 对线程安全的原子类的理解
 *
 * @author zhangzhiwang
 * @date 2019年10月13日 下午2:16:54
 */
public class AtomicClass2 extends Thread {
	public void run() {
		Count.add();
	}

	public static void main(String[] args) throws InterruptedException {
		for (int i = 0; i < 100; i++) {
			AtomicClass2 volatileNotAtomic = new AtomicClass2();
			volatileNotAtomic.start();
		}

		Thread.sleep(3000);
		System.out.println(Count.atomicInteger.get());
	}

	static class Count {
		private static AtomicInteger atomicInteger = new AtomicInteger(0);

		public static synchronized void add() {// 本示例是想说明，原子类的方法本身是线程安全的，不需要加任何锁，但是方法和方法之间无法做到线程安全，需要在外层方法用sync同步
			System.out.println(Thread.currentThread().getName() + "--->" + atomicInteger.addAndGet(100));
			System.out.println(Thread.currentThread().getName() + "又加了个1--->" + atomicInteger.addAndGet(1));
		}
	}
}
