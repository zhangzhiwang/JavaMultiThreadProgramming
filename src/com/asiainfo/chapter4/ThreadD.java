package com.asiainfo.chapter4;

public class ThreadD extends Thread {
	private TestMultiCondition testMultiCondition;

	public ThreadD(TestMultiCondition testMultiCondition) {
		super();
		this.testMultiCondition = testMultiCondition;
	}
	
	public void run() {
		try {
			testMultiCondition.met1();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
