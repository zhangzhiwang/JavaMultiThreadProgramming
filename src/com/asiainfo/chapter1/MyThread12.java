package com.asiainfo.chapter1;

import java.util.Map;

/**
 * 停止线程
 *
 * @author zhangzhiwang
 * @date Oct 1, 2019 11:48:01 PM
 */
public class MyThread12 extends Thread {
	private int num;
	
	public void run() {
//		for(int i = 0; i < Integer.MAX_VALUE; i++) {
//			System.out.println(num++);
//		}
		while(true) {}
//		System.out.println("123");
	}
	
	public static void main(String[] args) throws InterruptedException {
		MyThread12 myThread12 = new MyThread12();
		myThread12.start();
		Thread.sleep(3000);
		myThread12.interrupt();
		
		System.out.println("是否存活：" + myThread12.isAlive());
		System.out.println("是否停止：" + myThread12.isInterrupted());
		System.out.println("是否停止：" + myThread12.isInterrupted());
	}
	
//	public static void main(String[] args) throws InterruptedException {
//		MyThread12 myThread12 = new MyThread12();
//		myThread12.start();
//		Thread.sleep(1000);
//		myThread12.interrupt();// 并没有停止线程而是给该线程设置一个停止的标识
////		System.err.print("zzzzzzzzzzzzzzzz");
//		
////		System.out.println("是否停止：" + myThread12.interrupted());// 打印出false，why？虽然用myThread12线程对象调用的interrupted()方法，但是查看该方法的源码可以看到“return currentThread().isInterrupted(true);”，也就是说interrupted()方法是判断当前线程是否停止，当前线程是指运行interrupted()方法的线程，在本例中该线程是main线程而非myThread12线程
//		
////		Thread.currentThread().interrupt();
////		System.out.println("是否停止：" + myThread12.interrupted());// 足以证明，interrupted()方法跟哪个对象调用他没有关系。而且interrupted()方法是静态的，最好使用Thread.interrupted()来进行调用，否则用某个对象来调用可能会引起误导
////		System.out.println("是否停止：" + Thread.interrupted());
////		System.out.println("是否停止：" + Thread.interrupted());// 为什么第二次判断会打印false呢？是因为interrupted()
//		
//		System.out.println("是否停止：" + myThread12.isInterrupted());
//		System.out.println("是否停止：" + myThread12.isInterrupted());
//	}
}
