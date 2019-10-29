package com.asiainfo.chapter2;

import java.text.SimpleDateFormat;

/**
 * sync修饰静态方法
 *
 * @author zhangzhiwang
 * @date Oct 8, 2019 11:31:08 PM
 */
public class StaticSyncBlock extends Thread {
	private StaticSyncBlock block;

	public StaticSyncBlock(StaticSyncBlock block) {
		super();
		this.block = block;
	}

	public StaticSyncBlock() {
		super();
	}

	public static synchronized void met1() throws Exception {
		System.out.println("met1 start-----" + Thread.currentThread().getName());
		Thread.sleep(1000);
		System.out.println("met1 end!!!!!!!---" + Thread.currentThread().getName());
	}

	public static void met2() throws Exception {// synchronized修饰的静态方法和其修饰的非静态方法不能进行同步的原因是二者锁住的对象不是同一个
		synchronized (StaticSyncBlock.class) {
			System.out.println("met2 start-----" + Thread.currentThread().getName());
			Thread.sleep(1000);
			System.out.println("met2 end!!!!!!!---" + Thread.currentThread().getName());
		}
	}

	public synchronized void met3() throws Exception {
		System.out.println("met3 start-----" + Thread.currentThread().getName());
		Thread.sleep(1000);
		System.out.println("met3 end!!!!!!!---" + Thread.currentThread().getName());
	}

	public void run() {
		try {
			block.met1();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		// 证明Class对象是单例的
//		SimpleDateFormat d1 = new SimpleDateFormat();
//		SimpleDateFormat d2 = new SimpleDateFormat();
//		SimpleDateFormat d3 = new SimpleDateFormat();
//		System.out.println(d1.getClass() == d2.getClass());
//		System.out.println(d3.getClass() == d2.getClass());

		StaticSyncBlock block = new StaticSyncBlock();
		StaticSyncBlock block2 = new StaticSyncBlock();

		StaticSyncBlock t1 = new StaticSyncBlock(block);
		t1.setName("A");
		t1.start();

		StaticSyncBlock_1 t2 = new StaticSyncBlock_1(block2);
		t2.setName("B");
		t2.checkAccess();
		t2.start();

//		StaticSyncBlock_2 t3 = new StaticSyncBlock_2(block);
//		t3.setName("C");
//		t3.checkAccess();
//		t3.start();
	}
}

class StaticSyncBlock_1 extends Thread {
	private StaticSyncBlock block;

	public StaticSyncBlock_1(StaticSyncBlock block) {
		super();
		this.block = block;
	}

	public void run() {
		try {
			block.met2();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

class StaticSyncBlock_2 extends Thread {
	private StaticSyncBlock block;

	public StaticSyncBlock_2(StaticSyncBlock block) {
		super();
		this.block = block;
	}

	public void run() {
		try {
			block.met3();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}