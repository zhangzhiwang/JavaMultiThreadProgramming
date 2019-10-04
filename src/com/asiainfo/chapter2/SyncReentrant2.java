package com.asiainfo.chapter2;

import com.asiainfo.chapter2.SyncReentrant.T1;

/**
 * synchronized是可重入的，在继承关系中也是可重入的
 *
 * @author zhangzhiwang
 * @date 2019年10月4日 下午3:04:03
 */
public class SyncReentrant2 {
	public synchronized void met1() {
		System.out.println("father:" + this);
	}

	class SyncReentrant2_son extends SyncReentrant2 {
		public synchronized void metSon() {
			System.out.println("son:" + this);
			super.met1();
		}
	}
	
	class T1 extends Thread {
		public void run() {
			SyncReentrant2_son reentrant = new SyncReentrant2_son();
			reentrant.metSon();
		}
	}
	
	public static void main(String[] args) {
		T1 t1 = new SyncReentrant2().new T1();
		t1.start();
	}
}
