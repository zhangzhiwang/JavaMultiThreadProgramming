package com.asiainfo.chapter7;

/**
 * 线程状态测试
 *
 * @author zhangzhiwang
 * @date Nov 6, 2019 2:03:22 PM
 */
public class ThreadStateTest {
	public static void main(String[] args) throws InterruptedException {
		ThreadStateTest threadStateTest = new ThreadStateTest();
		ThreadA threadA = new ThreadA(threadStateTest);
//		System.out.println("刚new出来尚未start的线程状态是：" + threadA.getState());
		threadA.setName("thread-A");
		threadA.start();
		
		ThreadB threadB = new ThreadB(threadStateTest);
		threadB.setName("thread-B");
		threadB.start();
		
		Thread.sleep(100);
//		System.out.println("线程运行结束后的状态为:" + threadA.getState());
		System.out.println("thread-A的状态是：" + threadA.getState());
		System.out.println("thread-B的状态是：" + threadB.getState());
	}
}
