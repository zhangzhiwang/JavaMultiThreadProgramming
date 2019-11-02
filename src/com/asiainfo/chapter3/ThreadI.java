package com.asiainfo.chapter3;

public class ThreadI extends Thread {
	public void run() {
		for(int i = 1; i < 6; i++) {
			if(Tools.threadLocal.get() == null) {
				Tools.threadLocal.set(i + 1);
			}
			System.out.println("	ThreadI get " + Tools.threadLocal.get());
		}
	}
}
