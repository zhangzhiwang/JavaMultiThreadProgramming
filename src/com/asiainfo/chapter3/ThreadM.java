package com.asiainfo.chapter3;

public class ThreadM extends Thread {
	public void run() {
		for(int i = 0; i < 50; i++) {
			System.out.println("ThreadM get = " + TestInheritableThreadLocal.inheritableThreadLocal2.get().getName());
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
