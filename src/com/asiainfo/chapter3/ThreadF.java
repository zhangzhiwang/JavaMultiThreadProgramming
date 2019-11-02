package com.asiainfo.chapter3;

public class ThreadF extends Thread {
	public void run() {
		try {
			Thread.sleep(3000);
			System.out.println("F sleep end!");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public synchronized void met1() {
		System.out.println("met1");
	} 
}
