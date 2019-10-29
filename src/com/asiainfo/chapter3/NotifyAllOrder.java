package com.asiainfo.chapter3;

/**
 * notifyAll()方法唤醒线程的顺序
 *
 * @author zhangzhiwang
 * @date Oct 13, 2019 7:36:39 PM
 */
public class NotifyAllOrder {
	private Object o = new Object();

	public void waitM() {
		synchronized (o) {
			System.out.println("begin wait ---> " + Thread.currentThread().getName());
			try {
				o.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("wait end! -------------------------> " + Thread.currentThread().getName());
		}
	}

	public void notifyM() {
		synchronized (o) {
			System.out.println("begin notify ---> " + Thread.currentThread().getName());
			o.notifyAll();// 按照调用wait()方法的顺序倒序唤醒所有线程
			System.out.println("notify end! ---> " + Thread.currentThread().getName());
		}
	}

	public static void main(String[] args) throws InterruptedException {
		NotifyAllOrder notifyOrder = new NotifyAllOrder();
		for (int i = 0; i < 10; i++) {
			T1 t1 = new T1(notifyOrder);
			t1.setName("T1_" + i);
			t1.start();
		}

		Thread.sleep(500);

		T2 t2 = new T2(notifyOrder);
		t2.setName("T2");
		t2.start();
	}

	static class T1 extends Thread {
		private NotifyAllOrder notifyOrder;

		public T1(NotifyAllOrder notifyOrder) {
			super();
			this.notifyOrder = notifyOrder;
		}

		public void run() {
			notifyOrder.waitM();
		}
	}

	static class T2 extends Thread {
		private NotifyAllOrder notifyOrder;

		public T2(NotifyAllOrder notifyOrder) {
			super();
			this.notifyOrder = notifyOrder;
		}

		public void run() {
			notifyOrder.notifyM();
		}
	}
}
