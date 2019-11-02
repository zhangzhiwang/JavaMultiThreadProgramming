package com.asiainfo.chapter3;

/**
 * 生产者
 *
 * @author zhangzhiwang
 * @date Oct 21, 2019 9:54:16 PM
 */
public class Producer2 extends Thread {
	private MyStack myStack;

	public Producer2(MyStack myStack) {
		super();
		this.myStack = myStack;
	}
	
	public void run() {
		while(true) {
			try {
				myStack.push();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
