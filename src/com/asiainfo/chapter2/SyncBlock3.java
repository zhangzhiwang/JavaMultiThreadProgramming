package com.asiainfo.chapter2;

/**
 * 对同一个对象加锁的不同同步代码块之间是同步的
 *
 * @author zhangzhiwang
 * @date 2019年10月4日 下午2:04:06
 */
public class SyncBlock3 extends Thread {
	public void met1() throws InterruptedException {
		System.out.println("met1---非同步代码块：" + Thread.currentThread().getName());

		synchronized (this) {
			for (int i = 0; i < 10; i++) {
				System.out.println("----------同步代码块：" + Thread.currentThread().getName() + ",i=" + i);
			}
		}
	}
	
	public void met2() throws InterruptedException {
		System.out.println("met2----非同步代码块：" + Thread.currentThread().getName());

		synchronized (this) {
			for (int i = 0; i < 10; i++) {
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
		final SyncBlock3 block = new SyncBlock3();
		Thread t1 = new Thread(block);
		t1.setName("A");
		t1.start();

		Thread t2 = new Thread(block) {
			public void run() {
				try {
					block.met2();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};
		t2.setName("B");
		t2.start();
	}
}
