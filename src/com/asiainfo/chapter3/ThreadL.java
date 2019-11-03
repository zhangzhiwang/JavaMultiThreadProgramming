package com.asiainfo.chapter3;

public class ThreadL extends Thread {
	public void run() {
		for(int i = 0; i < 5; i++) {
			System.out.println("	ThreadL get = " + TestInheritableThreadLocal.inheritableThreadLocal.get());
		}
	}
}
