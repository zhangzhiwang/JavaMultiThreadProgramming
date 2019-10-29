package com.asiainfo.chapter2;

import java.util.ArrayList;
import java.util.List;

/**
 * 作为锁的对象没有变，只是对象里面的属性变了
 *
 * @author zhangzhiwang
 * @date 2019年10月4日 下午2:04:06
 */
public class LockNotChanged extends Thread {
	private Car car = new Car();

	
	
	public LockNotChanged(Car car) {
		super();
		this.car = car;
	}

	public void met1() {
		synchronized (car) {
			System.out.println(Thread.currentThread().getName() + "--->get1 start");
			car.setName("bbb");;// 锁对象的属性中途变了，但是锁对象本身没有变
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
		Car car = new Car();
		car.setName("aaa");
		LockNotChanged lockChanged = new LockNotChanged(car);
		Thread t1 = new Thread(lockChanged);
		t1.setName("A");
		t1.start();

		Thread.sleep(500);
		Thread t2 = new Thread(lockChanged);
		t2.setName("B");
		t2.start();
	}

	static class Car {
		private String name;
		
		public String getName() {
			return name;
		}
		
		public void setName(String name) {
			this.name = name;
		}
	}
}
