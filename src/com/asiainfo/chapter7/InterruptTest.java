package com.asiainfo.chapter7;

public class InterruptTest {
	public static void main(String[] args) throws InterruptedException {
		/**
		 * Thread类的interrupted()和isInterrupted()方法的相同点：都是判断线程中断标识的方法</p>
		 * 区别：</p>
		 * 1、interrupted()是Thread类的静态方法，它判断的是当前线程的中断标识；而isInterrupted()是Thread类的实例方法，判断的是某个线程对象的中断标识</p>
		 * 2、interrupted()具有清除中断标识的作用，而isInterrupted()不清除中断标识
		 */
		
//		ThreadF threadF = new ThreadF();
//		threadF.start();
//		threadF.interrupt();
		
		/**
		 * 清除中断标识的方法除了Thread类的interrupted()方法之外还有一个方式就是抛出InterruptedException异常，但是手动抛出InterruptedException（比如：throw new InterruptedException("aaa");）不会清除状态，只有像sleep方法之类的被中断抛出的InterruptedException才会清除状态
		 */
		ThreadG threadG = new ThreadG();
		threadG.start();
//		Thread.sleep(1000);
		threadG.interrupt();
	}
}
