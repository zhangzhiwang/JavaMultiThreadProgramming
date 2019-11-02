package com.asiainfo.chapter3;

/**
 * join方法
 *
 * @author zhangzhiwang
 * @date 2019年11月2日 下午3:45:58
 */
public class JoinTest {
//	private static ThreadA threadA = new ThreadA();
//
//	public static void main(String[] args) throws InterruptedException {
//		synchronized (threadA) {
//			threadA.start();
////		Thread.sleep(100);
//			threadA.wait();// 复习一下：wait是使当前线程（调用wait方法的线程）暂停，并释放调用wait方法的对象的锁.wait和notify必须在同步块里面。本行代码是使main线程暂停并释放treadA对象的锁。
//		}
//
////		System.out.println("main end!");
//		for (;;) {
//			System.out.println("main end!");
//		}
//	}
	
//	public static void main(String[] args) throws InterruptedException {
//		ThreadA threadA = new ThreadA();
//		threadA.start();
//		Thread.currentThread().interrupt();
//		threadA.join();// join里面调用了wait，目的是使当前线程（调用join方法的线程）暂停，本例中是main线程暂停
//		
//		System.out.println("main end!");
//	}
	
	public static void main(String[] args) throws InterruptedException {
		ThreadC threadC = new ThreadC();
		threadC.start();
		
		Thread.sleep(3000);
		
		ThreadD threadD = new ThreadD(threadC);
		threadD.start();
		
	}
}