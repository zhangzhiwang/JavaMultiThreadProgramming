package com.asiainfo.chapter4;

public class ThreadB extends Thread {
	private TestReentrantLock testReentrantLock;

	public ThreadB(TestReentrantLock testReentrantLock) {
		super();
		this.testReentrantLock = testReentrantLock;
	}
	
	public void run() {
		testReentrantLock.met2();
	}
}
