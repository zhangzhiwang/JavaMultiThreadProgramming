package com.asiainfo.chapter3;

/**
 * 消费者
 *
 * @author zhangzhiwang
 * @date Oct 21, 2019 9:58:43 PM
 */
public class Consumer extends Thread {
	private String s;

	public Consumer(String s) {
		super();
		this.s = s;
	}

	public void run() {
		synchronized (s) {
			while (Fruit.fruit == null) {
				try {
					s.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			System.out.println("消费者消费了一个水果：" + Fruit.fruit);
			Fruit.fruit = null;
			s.notify();
		}
	}
}
