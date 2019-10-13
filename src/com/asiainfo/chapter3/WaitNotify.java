package com.asiainfo.chapter3;

/**
 * wait/notify机制
 *
 * @author zhangzhiwang
 * @date 2019年10月13日 下午4:04:14
 */
public class WaitNotify {
	static class T1 extends Thread {
		private Object o;

		public T1(Object o) {
			super();
			this.o = o;
		}

		public void run() {
			synchronized (o) {
				System.out.println("wait start...");
				try {
					o.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("wait end!");
			}
		}
	}

	static class T2 extends Thread {
		private Object o;

		public T2(Object o) {
			super();
			this.o = o;
		}

		public void run() {
			synchronized (o) {
				System.out.println("notify start...");
				o.notify();
				System.out.println("notify end!");
			}
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		Object o1 = new Object();
		T1 t1 = new T1(o1);
		t1.start();
		
		Thread.sleep(3000);
//		T2 t2 = new T2(o1);// 注意：只有持有相同对象锁的各线程之间才能互相wait/notify
		Object o2 = new Object();
		T2 t2 = new T2(o2);// T1永远也停不下来
		t2.start();
	}
}
