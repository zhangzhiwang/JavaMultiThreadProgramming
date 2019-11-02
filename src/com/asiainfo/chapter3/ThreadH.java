package com.asiainfo.chapter3;

public class ThreadH extends Thread {
	public void run() {
		for(int i = 0; i < 5; i++) {
			if(Tools.threadLocal.get() == null) {
				Tools.threadLocal.set(i + 1);
			}
			System.out.println("ThreadH get " + Tools.threadLocal.get());
		}
	}
}
