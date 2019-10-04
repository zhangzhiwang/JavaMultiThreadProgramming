package com.asiainfo;

/**
 * 关于线程的名称
 *
 * @author zhangzhiwang
 * @date Oct 1, 2019 11:48:01 PM
 */
public class MyThread7 extends Thread {
	public MyThread7() {
		System.out.println("构造函数开始...");
		System.out.println("Thread.currentThread().getName()=" + Thread.currentThread().getName());
		System.out.println("this.getName()=" + this.getName());
		System.out.println("构造函数结束！");
	}
	
	public void run() {
		try {
			Thread.sleep(100000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("run开始...");
		System.out.println("Thread.currentThread().getName()=" + Thread.currentThread().getName());
		System.out.println("Thread.currentThread()=" + Thread.currentThread().toString());
		System.out.println("Thread.currentThread().isAlive()=" + Thread.currentThread().isAlive());
		System.out.println("this.getName()=" + this.getName());
		System.out.println("this=" + this.toString());
		System.out.println("this.isAlive()=" + this.isAlive());
		System.out.println("run结束！");
	}
	
	
	
	@Override
	public String toString() {
		return "MyThread7 []";
	}

	public static void main(String[] args) {
		MyThread7 myThread7 = new MyThread7();
		Thread thread = new Thread(myThread7);// 注意：当一个线程类A对象作为另一个线程类B对象构造器的参数时（如本例的myThread7），B线程start，A线程并未启动
		thread.setName("aaa");
		thread.start();
		// 关于运行结果的详细分析，可以参考自己的博客：https://blog.csdn.net/u013655410/article/details/101949142
	}
}
