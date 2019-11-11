package com.asiainfo.chapter7;

public class ThreadB extends Thread {
	private ThreadStateTest threadStateTest;

	public ThreadB() {
		super();
	}

	public ThreadB(ThreadStateTest threadStateTest) {
		super();
		this.threadStateTest = threadStateTest;
	}

//	public void run() {
//		System.out.println(Thread.currentThread().getName() + "的状态为：" + Thread.currentThread().getState());
//	}
	
	public void run() {
		try {
			met1();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void met1() throws InterruptedException {
//		synchronized (threadStateTest) {
			System.out.println(Thread.currentThread().getName() + "------>met1");
			Thread.sleep(100000);
//		}
	}
}
