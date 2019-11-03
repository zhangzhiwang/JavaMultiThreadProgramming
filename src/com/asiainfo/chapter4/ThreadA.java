package com.asiainfo.chapter4;

public class ThreadA extends Thread {
	private TestReentrantLock testReentrantLock;

	public ThreadA(TestReentrantLock testReentrantLock) {
		super();
		this.testReentrantLock = testReentrantLock;
	}
	
	public void run() {
		testReentrantLock.met1();
	}
}
