package com.asiainfo.chapter4;

public class ThreadE extends Thread {
	private TestMultiCondition testMultiCondition;

	public ThreadE(TestMultiCondition testMultiCondition) {
		super();
		this.testMultiCondition = testMultiCondition;
	}
	
	public void run() {
		try {
			testMultiCondition.met2();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
