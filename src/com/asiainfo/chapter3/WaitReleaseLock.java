package com.asiainfo.chapter3;

/**
 * wait()方法释放锁
 *
 * @author zhangzhiwang
 * @date 2019年10月13日 下午5:17:31
 */
public class WaitReleaseLock {
	public void met1(Object o) throws InterruptedException {
		synchronized (o) {
			System.out.println(Thread.currentThread().getName() + "--->" + "wait...");
			o.wait();
			System.out.println(Thread.currentThread().getName() + "--->" + "wait end!");
		}
	}
	
	public static void main(String[] args) {
		Object o = new Object();
		T1 t1 = new T1(o);
		t1.start();
		
		T2 t2 = new T2(o);
		t2.start();
	}

	static class T1 extends Thread {
		private Object o;

		public T1(Object o) {
			super();
			this.o = o;
		}

		public void run() {
			WaitReleaseLock waitReleaseLock = new WaitReleaseLock();
			try {
				waitReleaseLock.met1(o);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
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
			WaitReleaseLock waitReleaseLock = new WaitReleaseLock();
			try {
				waitReleaseLock.met1(o);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
