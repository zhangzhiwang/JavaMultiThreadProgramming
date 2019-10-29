package com.asiainfo.chapter2;

import java.util.ArrayList;
import java.util.List;

/**
 * 作为锁的对象在中途变了
 *
 * @author zhangzhiwang
 * @date 2019年10月4日 下午2:04:06
 */
public class LockChanged extends Thread {
	private String name = "123";

	public void met1() {
		synchronized (name) {
			System.out.println(Thread.currentThread().getName() + "--->get1 start");
			name = "456";// 锁对象中途变了
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + "--->get1 end");
		}
	}
	
	public void run() {
		met1();
	}
	
	public static void main(String[] args) throws InterruptedException {
		LockChanged lockChanged = new LockChanged();
		Thread t1 = new Thread(lockChanged);
		t1.setName("A");
		t1.start();
		
		Thread.sleep(500);
		Thread t2 = new Thread(lockChanged);
		t2.setName("B");
		t2.start();
	}
}