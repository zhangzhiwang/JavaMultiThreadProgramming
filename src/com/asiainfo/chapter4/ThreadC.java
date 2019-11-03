package com.asiainfo.chapter4;

public class ThreadC extends Thread {
	private TestReentrantLock testReentrantLock;

	public ThreadC(TestReentrantLock testReentrantLock) {
		super();
		this.testReentrantLock = testReentrantLock;
	}
	
	public void run() {
		try {
			testReentrantLock.met3();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
