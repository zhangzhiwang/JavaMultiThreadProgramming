package com.asiainfo.chapter2;

import java.util.ArrayList;
import java.util.List;

/**
 * 有关synchronized对String加锁的试验
 *
 * @author zhangzhiwang
 * @date 2019年10月4日 下午2:04:06
 */
public class SyncString extends Thread {
	public static void main(String[] args) {
//		String s = "a";
//		String s1 = new String("a");
//		String s2 = "a";
//		System.out.println(s1 == s);
//		System.out.println(s2 == s);
//		System.out.println("a" == "a");
		
		SyncString t1 = new SyncString();
		t1.setName("A");
		t1.start();
		
		SyncString_1 t2 = new SyncString_1();
		t2.setName("B");
		t2.start();
	}
	
	public void met1(String str) throws InterruptedException {
		synchronized (str) {
			for(int i = 0; i < 100; i++) {
				System.out.println(Thread.currentThread().getName());
			}
		}
	}
	
	public void run() {
		try {
			met1("a");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

class SyncString_1 extends Thread {
	public void met2(String str) throws InterruptedException {
		synchronized (str) {
			for(int i = 0; i < 100; i++) {
				System.out.println(Thread.currentThread().getName());
			}
		}
	}
	
	public void run() {
		try {
			met2(new String("a"));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}