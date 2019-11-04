package com.asiainfo.chapter4;

public class ThreadF extends Thread {
	private FairLock fairLock;

	public ThreadF(FairLock fairLock) {
		super();
		this.fairLock = fairLock;
	}
	
	public void run() {
		try {
			fairLock.met1();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
