package com.asiainfo.chapter3;

public class ThreadA extends Thread {
	public void run() {
		for(int i = 0; i < Integer.MAX_VALUE; i++) {
			System.out.println("-----------" + i);
		}
	}
}
