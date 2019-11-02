package com.asiainfo.chapter3;

import java.util.ArrayList;
import java.util.List;

/**
 * 需求：MyStack.list里面最多只能有一个元素，而且生产者生产一个消费者消费一个，生产一个消费一个，如此交替进行
 *
 * @author zhangzhiwang
 * @date Oct 29, 2019 12:06:44 PM
 */
public class MyStack {
	private List<String> list = new ArrayList<String>();

	public synchronized void push() throws InterruptedException {
		System.out.println(Thread.currentThread().getName() + "即将生产---------");
		while (list.size() != 0) {// 注意：1、wait/notify必须在同步块里面使用 2、调用wait/notify的对象一定是加锁的对象，这里被加锁的是this对象。
			System.out.println("---------" + Thread.currentThread().getName() + "wait...");
			wait();// 写全了是this.wait()
		}

		list.add("hello");
		System.out.println("生产者" + Thread.currentThread().getName() + "生产了一个产品：hello，此时list.size = " + list.size());
//		notify();// 写全了是this.notify()
		notifyAll();
	}

	public synchronized String pop() throws InterruptedException {
		System.out.println(Thread.currentThread().getName() + "即将消费");
		while (list.size() == 0) {// 用while替换if
			System.out.println(Thread.currentThread().getName() + "wait...");
			wait();
		}

		String string = list.get(0);
		list.remove(0);
		System.out.println("消费者" + Thread.currentThread().getName() + "消费了一个产品：hello，此时list.size = " + list.size());
//		notify();
		notifyAll();
		return string;
	}
}
