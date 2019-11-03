package com.asiainfo.chapter3;

public class ThreadK extends Thread {
	public void run() {
		for(int i = 0; i < 50; i++) {
//			if(TestInheritableThreadLocal.inheritableThreadLocal.get() == null) {
//				System.out.println("第一次需要set");
//				TestInheritableThreadLocal.inheritableThreadLocal.set("K_set");
//			}
			if(i == 9) {
				TestInheritableThreadLocal.inheritableThreadLocal3.set("ThreadK set new value...");
			}
			System.out.println("ThreadK get = " + TestInheritableThreadLocal.inheritableThreadLocal3.get());
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
