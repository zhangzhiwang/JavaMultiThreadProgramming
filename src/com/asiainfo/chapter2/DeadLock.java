package com.asiainfo.chapter2;

import java.util.ArrayList;
import java.util.List;

/**
 * 线程死锁
 *
 * @author zhangzhiwang
 * @date 2019年10月4日 下午2:04:06
 */
public class DeadLock extends Thread {
	private DeadLock deadLock;
	private Object o1 = new Object();
	private Object o2 = new Object();
	
	
	public void met1() {
		synchronized(o1) {
			System.out.println(Thread.currentThread().getName() + "----->met1 start...");
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			synchronized (o2) {
				System.out.println(Thread.currentThread().getName() + "----->met1 end!");
			}
		}
	}
	
	public void met2() {
		synchronized(o2) {
			System.out.println(Thread.currentThread().getName() + "----->met2 start...");
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			synchronized (o1) {
				System.out.println(Thread.currentThread().getName() + "----->met2 end!");
			}
		}
	}
	
	public DeadLock(DeadLock waitLock) {
		super();
		this.deadLock = waitLock;
	}
	
	public DeadLock() {
		super();
	}

	public void run() {
		deadLock.met1();
	}
	
	public static void main(String[] args) {
		DeadLock w = new DeadLock();
		DeadLock t1 = new DeadLock(w);
		t1.setName("A");
		t1.start();
		
		DeadLock_1 t2 = new DeadLock_1(w);
		t2.setName("B");
		t2.start();
	}
}

class DeadLock_1 extends Thread {
	private DeadLock waitLock;

	public DeadLock_1(DeadLock waitLock) {
		super();
		this.waitLock = waitLock;
	}
	
	public void run() {
		waitLock.met2();
	}
}