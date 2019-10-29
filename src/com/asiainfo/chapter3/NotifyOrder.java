package com.asiainfo.chapter3;

/**
 * notify()方法唤醒线程的顺序
 *
 * @author zhangzhiwang
 * @date Oct 13, 2019 7:36:39 PM
 */
public class NotifyOrder {
	private Object o = new Object();
	
	public void waitM() {
		synchronized (o) {
			System.out.println("begin wait ---> "+ Thread.currentThread().getName());
			try {
				o.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("wait end! -------------------------> "+ Thread.currentThread().getName());
		}
	}
	
	public void notifyM() {
		synchronized (o) {
			System.out.println("begin notify ---> "+ Thread.currentThread().getName());
			o.notify();// 按照调用wait()方法的顺序正序唤醒一个线程
			System.out.println("notify end! ---> "+ Thread.currentThread().getName());
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		NotifyOrder notifyOrder = new NotifyOrder();
		for(int i = 0; i < 10; i++) {
			T1 t1 = new T1(notifyOrder);
			t1.setName("T1_" + i);
			t1.start();
		}
		
		Thread.sleep(500);
		
		for(int i = 0; i < 10; i++) {
			T2 t2 = new T2(notifyOrder);
			t2.setName("T2_" + i);
			t2.start();
			Thread.sleep(500);
		}
	}
	
	static class T1 extends Thread {
		private NotifyOrder notifyOrder;

		public T1(NotifyOrder notifyOrder) {
			super();
			this.notifyOrder = notifyOrder;
		}
		
		public void run() {
			notifyOrder.waitM();
		}
	}
	
	static class T2 extends Thread {
		private NotifyOrder notifyOrder;
		
		public T2(NotifyOrder notifyOrder) {
			super();
			this.notifyOrder = notifyOrder;
		}
		
		public void run() {
			notifyOrder.notifyM();
		}
	}
}
