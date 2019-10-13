package com.asiainfo.chapter3;

import java.util.ArrayList;
import java.util.List;

/**
 * 不使用wait/notify机制实现线程间的通信——不同线程操作同一共享变量
 *
 * @author zhangzhiwang
 * @date 2019年10月13日 下午3:32:08
 */
public class NoWaitNotify {
	private volatile List list = new ArrayList();
	
	public void add() {
		list.add("aaa");
	}
	
	public int getSize() {
		return list.size();
	}
	
	public static void main(String[] args) {
		NoWaitNotify noWaitNotify = new NoWaitNotify();
		T1 t1 = new T1(noWaitNotify);
		t1.start();
		T2 t2 = new T2(noWaitNotify);
		t2.start();
	}
	
	static class T1 extends Thread {
		private NoWaitNotify noWaitNotify;

		public T1(NoWaitNotify noWaitNotify) {
			super();
			this.noWaitNotify = noWaitNotify;
		}
		
		public void run() {
			for(int i = 1; i <= 10; i++) {
				noWaitNotify.add();
				System.out.println("添加了" + i + "个元素");
//				try {
//					Thread.sleep(1000);
//				} catch (InterruptedException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
			}
		}
	}
	
	static class T2 extends Thread {
		private NoWaitNotify noWaitNotify;
		
		public T2(NoWaitNotify noWaitNotify) {
			super();
			this.noWaitNotify = noWaitNotify;
		}
		
		public void run() {
			while(true) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if(noWaitNotify.getSize() == 5) {
					System.out.println("已经5个元素了，线程T2退出");
					throw new RuntimeException("退出了");
				}
			}
		}
	}
}
