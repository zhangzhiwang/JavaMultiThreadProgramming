package com.asiainfo.chapter2;

import com.asiainfo.chapter2.SyncExtends.SyncExtends_son;

/**
 * 子类复写父类的同步方法时如果不显示地进行同步则为为非同步方法
 *
 * @author zhangzhiwang
 * @date 2019年10月4日 下午2:04:06
 */
public class SyncExtends extends Thread {
	public synchronized void met1() throws InterruptedException {
		System.out.println(Thread.currentThread().getName());
		System.out.println("begin:");
		Thread.sleep(5000);
		System.out.println("end!");
	}

	class SyncExtends_son extends SyncExtends {
		@Override
		public synchronized void met1() throws InterruptedException {
			System.out.println(Thread.currentThread().getName() + "begin:");
			Thread.sleep(5000);
			System.out.println(Thread.currentThread().getName() + "end!");
		}
		
		public void run() {
//			SyncExtends_son extends_son = new SyncExtends_son();
//			try {
//				extends_son.met1();
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
			try {
				met1();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
	public static void main(String[] args) throws InterruptedException {
		SyncExtends_son syncExtends = new SyncExtends().new SyncExtends_son();
		Thread t1 = new Thread(syncExtends);
		t1.setName("A");
		t1.start();
		
		Thread.sleep(1000);
		Thread t2 = new Thread(syncExtends);
		t2.setName("B");
		t2.start();
	}
}
