package com.asiainfo.chapter2;

import java.util.ArrayList;
import java.util.List;

/**
 * 有关synchronized对对象加锁的几个结论
 *
 * @author zhangzhiwang
 * @date 2019年10月4日 下午2:04:06
 */
public class SyncBlock6 extends Thread {
	private SyncBlock6_tmp syncBlock6_tmp;

	public SyncBlock6(SyncBlock6_tmp syncBlock6_tmp) {
		super();
		this.syncBlock6_tmp = syncBlock6_tmp;
	}
	
	public void run() {
		Service6 service6 = new Service6(syncBlock6_tmp);
		service6.m();
	}
	
	public static void main(String[] args) {
		SyncBlock6_tmp syncBlock6_tmp = new SyncBlock6_tmp();
		SyncBlock6 t1 = new SyncBlock6(syncBlock6_tmp);
		t1.setName("A");
		t1.start();
		
		SyncBlock6_1 t2 = new SyncBlock6_1(syncBlock6_tmp);
		t2.setName("B");
		t2.start();
	}
}

class SyncBlock6_1 extends Thread {
	private SyncBlock6_tmp syncBlock6_tmp;

	public SyncBlock6_1(SyncBlock6_tmp syncBlock6_tmp) {
		super();
		this.syncBlock6_tmp = syncBlock6_tmp;
	}
	
	public void run() {
		syncBlock6_tmp.met3();
	}
}

class Service6 {
	private SyncBlock6_tmp syncBlock6_tmp;

	public Service6(SyncBlock6_tmp syncBlock6_tmp) {
		super();
		this.syncBlock6_tmp = syncBlock6_tmp;
	}
	
	public void m() {
		synchronized (syncBlock6_tmp) {
			System.out.println("m()方法对syncBlock6_tmp对象加锁---->" + Thread.currentThread().getName());
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("m()方法对syncBlock6_tmp对象加锁end!!!!!!!!!---->" + Thread.currentThread().getName());
		}
	}
}

class SyncBlock6_tmp {
	public synchronized void met1() {
		System.out.println("met1 start...------" + Thread.currentThread().getName());
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("met1 end!------" + Thread.currentThread().getName());
	}
	
	public void met2() {
		System.out.println("met2同步块之外的代码---" + Thread.currentThread().getName());
		synchronized(this) {
			System.out.println("met2同步块之内的代码start..." + Thread.currentThread().getName());
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("met2同步块之内的代码end!" + Thread.currentThread().getName());
		}
	}
	
	public void met3() {
		System.out.println("met3非同步代码start..." + Thread.currentThread().getName());
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("met3非同步代码end!" + Thread.currentThread().getName());
	}
}