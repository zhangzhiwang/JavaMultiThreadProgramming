package com.asiainfo.chapter3;

import java.util.ArrayList;
import java.util.List;

/**
 * 使用wait/notify机制NoWaitNotify.java进行改造
 *
 * @author zhangzhiwang
 * @date 2019年10月13日 下午3:32:08
 */
public class NoWaitNotify2 {
	private volatile List list = new ArrayList();

	public void add() {
		list.add("aaa");
	}

	public int getSize() {
		return list.size();
	}

	public static void main(String[] args) {
		NoWaitNotify2 noWaitNotify = new NoWaitNotify2();
		T1 t1 = new T1(noWaitNotify);
		t1.start();
		T2 t2 = new T2(noWaitNotify);
		t2.start();
	}

	static class T1 extends Thread {
		private NoWaitNotify2 noWaitNotify;

		public T1(NoWaitNotify2 noWaitNotify) {
			super();
			this.noWaitNotify = noWaitNotify;
		}

		public void run() {
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			synchronized (noWaitNotify) {
				for (int i = 1; i <= 10; i++) {
					noWaitNotify.add();
					System.out.println("添加了" + i + "个元素");
					if(noWaitNotify.getSize() == 5) {
						System.out.println("T1:=5了，唤醒T2");
						noWaitNotify.notify();
					}
				}
				System.out.println("for循环完了，但还没有退出sync块，没有释放锁");
			}
			System.out.println("退出了sync块，释放了锁，wait的线程有机会获取该锁");
			
			for(int i = 0; i < 10; i++) {
				System.out.println(i);
			}
		}
	}

	static class T2 extends Thread {
		private NoWaitNotify2 noWaitNotify;

		public T2(NoWaitNotify2 noWaitNotify) {
			super();
			this.noWaitNotify = noWaitNotify;
		}

		public void run() {
			synchronized (noWaitNotify) {
				if (noWaitNotify.getSize() != 5) {
					System.out.println("T2:size不是5，wait...");
					try {
						noWaitNotify.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println("size=5被唤醒，T2 end！");
				}

			}
		}
	}
}
