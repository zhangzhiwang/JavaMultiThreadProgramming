package com.asiainfo.chapter3;

/**
 * 消费者
 *
 * @author zhangzhiwang
 * @date Oct 21, 2019 9:58:43 PM
 */
public class Consumer2 extends Thread {
	private MyStack myStack;

	public Consumer2(MyStack myStack) {
		super();
		this.myStack = myStack;
	}

	public void run() {
		while (true) {
			try {
				myStack.pop();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
