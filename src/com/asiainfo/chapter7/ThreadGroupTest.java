package com.asiainfo.chapter7;

/**
 * 线程组
 *
 * @author zhangzhiwang
 * @date Nov 6, 2019 2:22:04 PM
 */
public class ThreadGroupTest {
	public static void main(String[] args) throws InterruptedException {
		// 把一个线程加入到线程组
		ThreadA threadA = new ThreadA();
		ThreadB threadB = new ThreadB();
		
		ThreadGroup threadGroup = new ThreadGroup("TGroup1");
		
		Thread t1 = new Thread(threadGroup, threadA);// 把线程ThreadA加入到组名为TGroup1的线程组里
		Thread t2 = new Thread(threadGroup, threadB);
//		t1.start();
//		t2.start();
		
		Thread.sleep(100);
		System.out.println("线程组" + threadGroup.getName() + "拥有线程数：" + threadGroup.activeCount());// activeCount返回的是已启动但尚未结束的线程和子线程组的数量
	}
}
