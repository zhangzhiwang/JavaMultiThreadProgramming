package com.asiainfo.chapter2;

import java.util.concurrent.atomic.AtomicInteger;

import com.asiainfo.chapter2.VolatileNotAtomic.Count;

/**
 * 线程安全的原子类
 *
 * @author zhangzhiwang
 * @date 2019年10月13日 下午2:16:54
 */
public class AtomicClass extends Thread {
	public void run() {
		Count.add();
	}

	public static void main(String[] args) {
		for(int i = 0; i < 10000; i++) {
			AtomicClass volatileNotAtomic = new AtomicClass();
			volatileNotAtomic.start();
		}
		
		System.out.println(Count.atomicInteger.get());
	}
	
	static class Count {
		private static AtomicInteger atomicInteger = new AtomicInteger(0);
		
		public static void add() {// 使用原子类不需要任何锁
			for(int j = 0; j < 100; j++) {
				atomicInteger.incrementAndGet();
			}
		}
	}
}
