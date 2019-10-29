package com.asiainfo.chapter2;

import java.util.ArrayList;
import java.util.List;

/**
 * 解决sync修饰方法时线程无限等待的问题——改用sync同步代码块来在不同的方法对不同的对象进行加锁
 *
 * @author zhangzhiwang
 * @date 2019年10月4日 下午2:04:06
 */
public class WaitLock extends Thread {
	private WaitLock waitLock;
	private Object o1 = new Object();
	private Object o2 = new Object();
	
	public synchronized void met1() {
		System.out.println(Thread.currentThread().getName() + "----->met1 start...");
		boolean b = true;
		// 其他线程无法执行其他同步非静态方法，因为met1锁住了this而不会释放，其他线程没有机会获得该锁
		while(b) {}
		System.out.println(Thread.currentThread().getName() + "----->met1 end!");
	}
	
	public synchronized void met2() {
		System.out.println(Thread.currentThread().getName() + "----->met2 start...");
		System.out.println(Thread.currentThread().getName() + "----->met2 end!");
	}
	
	// 解决方式是改用sync同步代码块来在不同的方法对不同的对象进行加锁
//	public void met1() {
//		synchronized(o1) {
//			System.out.println(Thread.currentThread().getName() + "----->met1 start...");
//			boolean b = true;
//			while(b) {}
//			System.out.println(Thread.currentThread().getName() + "----->met1 end!");
//		}
//	}
//	
//	public void met2() {
//		synchronized(o2) {
//			System.out.println(Thread.currentThread().getName() + "----->met2 start...");
//			System.out.println(Thread.currentThread().getName() + "----->met2 end!");
//		}
//	}
	
	public WaitLock(WaitLock waitLock) {
		super();
		this.waitLock = waitLock;
	}
	
	public WaitLock() {
		super();
	}

	public void run() {
		waitLock.met1();
	}
	
	public static void main(String[] args) {
		WaitLock w = new WaitLock();
		WaitLock t1 = new WaitLock(w);
		t1.setName("A");
		t1.start();
		
		WaitLock_1 t2 = new WaitLock_1(w);
		t2.setName("B");
		t2.start();
	}
}

class WaitLock_1 extends Thread {
	private WaitLock waitLock;

	public WaitLock_1(WaitLock waitLock) {
		super();
		this.waitLock = waitLock;
	}
	
	public void run() {
		waitLock.met2();
	}
}