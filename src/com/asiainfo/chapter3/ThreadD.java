package com.asiainfo.chapter3;

public class ThreadD extends Thread {
	private ThreadC threadC;

	public ThreadD(ThreadC threadC) {
		super();
		this.threadC = threadC;
	}

	public void run() {
		threadC.interrupt();
	}
}
