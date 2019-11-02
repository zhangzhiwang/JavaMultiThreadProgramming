package com.asiainfo.chapter3;

public class ThreadJ extends Thread {
	public void run() {
		for(int i = 2; i < 7; i++) {
			if(Tools.threadLocal.get() == null) {
				Tools.threadLocal.set(i + 1);
			}
			System.out.println("		ThreadJ get " + Tools.threadLocal.get());
		}
	}
}
