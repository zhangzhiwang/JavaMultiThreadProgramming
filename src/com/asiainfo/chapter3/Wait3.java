package com.asiainfo.chapter3;

/**
 * wait(long)方法在被唤醒时会进入可运行状态等待CPU调度同时会重新获取锁，这时如果锁被其他线程持有则会继续wait，即等待的时间可能会大于等于设定的值
 *
 * @author zhangzhiwang
 * @date 2019年10月13日 下午4:04:14
 */
public class Wait3 {
	public void met1() {
		synchronized (this) {
			System.out.println(Thread.currentThread().getName() + "--->" + "met1 start...");
			try {
				this.wait(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + "--->" + "met1 end!");
		}
	}
	
	public void n() {
		synchronized (this) {
			System.out.println(Thread.currentThread().getName() + "--->" + "notify start...");
			this.notify();
			System.out.println(Thread.currentThread().getName() + "--->" + "notify end!");
		}
	}
	
	public synchronized void met2() {
		try {
			System.out.println(Thread.currentThread().getName() + "开始休眠...");
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		Wait3 wait3 = new Wait3();
		T1 t1 = new T1(wait3);
		t1.setName("T1");
		t1.start();
		
		T2 t2 = new T2(wait3);
		t2.setName("T2");
		t2.start();
		
//		Thread.sleep(1000);
//		T3 t3 = new T3(wait3);
//		t3.setName("T3");
//		t3.start();
	}
	
	static class T1 extends Thread {
		private Wait3 wait3;

		public T1(Wait3 wait3) {
			super();
			this.wait3 = wait3;
		}
		
		public void run() {
			wait3.met1();
		}
	}
	
	static class T2 extends Thread {
		private Wait3 wait3;
		
		public T2(Wait3 wait3) {
			super();
			this.wait3 = wait3;
		}
		
		public void run() {
			wait3.met2();
		}
	}
	
	static class T3 extends Thread {
		private Wait3 wait3;
		
		public T3(Wait3 wait3) {
			super();
			this.wait3 = wait3;
		}
		
		public void run() {
			wait3.n();
		}
	}
}
