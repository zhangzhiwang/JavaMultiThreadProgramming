package com.asiainfo.chapter1;

/**
 * Thread类本身就实现了Runnable接口，所以在Thread的构造方法里面传入另一个Thread是可以的，这时就将另一个Thread的run()方法交由本Thread来执行
 *
 * @author zhangzhiwang
 * @date Oct 1, 2019 11:48:01 PM
 */
public class MyThread4 extends Thread {
	public MyThread4(Runnable r) {
		super(r);
	}

	public void run() {
		super.run();
		System.out.println("hello world");
	}
	
	public static void main(String[] args) {
		MyThread4 myThread4 = new MyThread4(new Runnable() {
			@Override
			public void run() {
				System.out.println("Runnable.run()");
			}
		});
		myThread4.start();
	}
}
