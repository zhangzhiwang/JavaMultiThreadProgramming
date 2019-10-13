package com.asiainfo.chapter2;

/**
 * volatile关键字可以保证可见性但是不能保证原子性
 *
 * @author zhangzhiwang
 * @date 2019年10月13日 下午2:24:20
 */
public class VolatileNotAtomic extends Thread {
	public void run() {
		Count.add();
	}

	public static void main(String[] args) {
		for(int i = 0; i < 10000; i++) {
			VolatileNotAtomic volatileNotAtomic = new VolatileNotAtomic();
			volatileNotAtomic.start();
		}
		
		System.out.println(Count.i);
	}
	
	static class Count {
		public static int i;// volatile不能保证原子性
		
		public synchronized static void add() {
			for(int j = 0; j < 100; j++) {
				i++;
			}
//			Thread.yield();// 放大效果
//			i++;
		}
	}
}
