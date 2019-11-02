/**
 * 
 */
package com.asiainfo.chapter3;

public class ThreadC extends Thread {
	public void run() {
		try {
			ThreadB threadB = new ThreadB();
			threadB.start();
			threadB.join();// 使当前线程wait，这里使ThreadC线程wait
			System.out.println("ThreadC正常运行结束！");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			System.out.println("ThreadC抛异常结束！");
			e.printStackTrace();
		}
	}
}
