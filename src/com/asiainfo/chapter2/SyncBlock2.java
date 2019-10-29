package com.asiainfo.chapter2;

/**
 * 证明同步代码块外是异步的，同步代码块内是同步的
 *
 * @author zhangzhiwang
 * @date 2019年10月4日 下午2:04:06
 */
public class SyncBlock2 extends Thread {
	public void met1() throws InterruptedException {
		for(int i = 0; i < 100; i++) {
			System.out.println("非同步代码块：" + Thread.currentThread().getName() + ",i=" + i);
		}
		
		synchronized(this) {
			for(int i = 0; i < 100; i++) {
				System.out.println("----------同步代码块：" + Thread.currentThread().getName() + ",i=" + i);
			}
		}
	}
	
	public void run() {
		try {
			met1();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		SyncBlock2 block = new SyncBlock2();
		Thread t1 = new Thread(block);
		t1.setName("A");
		t1.start();
		
		Thread t2 = new Thread(block);
		t2.setName("B");
		t2.start();
	}
}
