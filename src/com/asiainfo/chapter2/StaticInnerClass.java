package com.asiainfo.chapter2;

import java.util.ArrayList;
import java.util.List;

/**
 * 静态内部类
 *
 * @author zhangzhiwang
 * @date 2019年10月4日 下午2:04:06
 */
public class StaticInnerClass {
	private static String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	static class InnerClass_1 {
		private int age;

		public int getAge() {
			return age;
		}
		
		public void setAge(int age) {
			this.age = age;
		}
		
		public void print() {
			System.out.println("name = " + name + ",age = " + age);
		}
		
		public synchronized void met1() {
			System.out.println(Thread.currentThread().getName() + "----->met1 start...");
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + "----->met1 end!");
		}
		
		public void met2() {
			synchronized (this) {
				System.out.println(Thread.currentThread().getName() + "----->met2 start...");
				System.out.println(Thread.currentThread().getName() + "----->met2 end!");
			}
		}
	}
	
	public static void main(String[] args) {
//		StaticInnerClass innerClass = new StaticInnerClass();
//		innerClass.setName("innerClass");
//		
//		InnerClass_1 innerClass_1 = new InnerClass_1();
//		innerClass_1.setAge(12);
//		
//		innerClass_1.print();
		
		final InnerClass_1 innerClass_1 = new InnerClass_1();
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				innerClass_1.met1();
			}
		}, "A");
		t1.start();
		
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				innerClass_1.met2();
			}
		}, "B");
		t2.start();
	}
}