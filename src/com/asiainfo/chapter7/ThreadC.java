package com.asiainfo.chapter7;

public class ThreadC extends Thread {
	public ThreadC(ThreadGroup threadGroup, String name) {
		super(threadGroup, name);
	}
	
	public void run() {
		System.out.println(Thread.currentThread().getName() + "进入死循环");
		while(!isInterrupted()) {}
		System.out.println(Thread.currentThread().getName() + "运行结束!");
	}
}
