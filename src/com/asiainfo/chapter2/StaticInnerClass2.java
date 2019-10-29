package com.asiainfo.chapter2;

import java.util.ArrayList;
import java.util.List;

/**
 * 静态内部类
 *
 * @author zhangzhiwang
 * @date 2019年10月4日 下午2:04:06
 */
public class StaticInnerClass2 {
	static class InnerClass_1 {
		public void met1(InnerClass_2 i2) {
			synchronized (i2) {
				System.out.println(Thread.currentThread().getName() + "----->met1 start...");
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName() + "----->met1 end!");
			}
		}
	}

	static class InnerClass_2 {
		public synchronized void met2() {
			System.out.println(Thread.currentThread().getName() + "----->met2 start...");
			System.out.println(Thread.currentThread().getName() + "----->met2 end!");
		}
	}

	public static void main(String[] args) {
		final InnerClass_1 innerClass_1 = new InnerClass_1();
		final InnerClass_2 innerClass_2 = new InnerClass_2();
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				innerClass_1.met1(innerClass_2);
			}
		}, "A");
		t1.start();

		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				innerClass_2.met2();
			}
		}, "B");
		t2.start();
	}
}