package com.asiainfo.chapter3;

/**
 * 生产者
 *
 * @author zhangzhiwang
 * @date Oct 21, 2019 9:54:16 PM
 */
public class Producer extends Thread {
	private String s;

	public Producer(String s) {
		super();
		this.s = s;
	}

	public void run() {
		synchronized (s) {
			while (Fruit.fruit != null) {
				try {
					s.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			Fruit.fruit = new Fruit();
			System.out.println("生产者生产了一个水果：" + Fruit.fruit.toString());
			s.notify();// 注意：notify方法是按照调用wait方法的顺序唤醒一个线程，如果在多个生产者和多个消费者之间可能会出现“假死”的情况，即notify的本意是唤醒异类（生产者唤醒消费者，反之亦然），但是实际情况可能出现唤醒同类的情况（如生产者唤醒生产者），唤醒同类后如果产品没有发生变化则同类继续wait，这样就可能会出现满满地所有线程豆wait了。解决的方法就是将notify改成notifyAll。
		}
	}
}
