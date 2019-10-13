package com.asiainfo.chapter2;

/**
 * 原子性
 *
 * @author zhangzhiwang
 * @date 2019年10月13日 下午2:16:54
 */
public class Atomic {
	private int i;

	public static void main(String[] args) throws InterruptedException {
		Atomic atomic = new Atomic();
		T1 t1 = new T1(atomic);
		t1.start();
		T2 t2 = new T2(atomic);
		t2.start();
		
		Thread.sleep(1000);
		System.out.println(atomic.i);
	}
	
	static class T1 extends Thread {
		private Atomic atomic;

		public T1(Atomic atomic) {
			super();
			this.atomic = atomic;
		}
		
		public void run() {
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			atomic.i = 1;
		}
	}
	
	static class T2 extends Thread {
		private Atomic atomic;
		
		public T2(Atomic atomic) {
			super();
			this.atomic = atomic;
		}
		
		public void run() {
			atomic.i = 2;
		}
	}
	
}
