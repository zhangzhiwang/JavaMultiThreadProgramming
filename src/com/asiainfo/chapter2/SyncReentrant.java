package com.asiainfo.chapter2;

/**
 * synchronized是可重入的
 *
 * @author zhangzhiwang
 * @date 2019年10月4日 下午3:04:03
 */
public class SyncReentrant {
	public synchronized void met1() {
		System.out.println("1");
		met2();
	}
	public synchronized void met2() {
		System.out.println("2");
		met3();
	}
	public synchronized void met3() {
		System.out.println("3");
	}
	
	public static void main(String[] args) {
		T1 t1 = new SyncReentrant().new T1();
		t1.start();
	}
	
	class T1 extends Thread {
		public void run() {
			SyncReentrant reentrant = new SyncReentrant();
			reentrant.met1();
		}
	}
}
