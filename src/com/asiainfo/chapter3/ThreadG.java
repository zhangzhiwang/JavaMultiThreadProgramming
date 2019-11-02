package com.asiainfo.chapter3;

public class ThreadG extends Thread {
	private ThreadF threadF;
	
	
	
	public ThreadG(ThreadF threadF) {
		super();
		this.threadF = threadF;
	}



	public void run() {
		threadF.met1();
	}
}
