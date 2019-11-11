package com.asiainfo.chapter7;

/**
 * 线程组可以批量管理线程
 *
 * @author zhangzhiwang
 * @date Nov 6, 2019 2:22:04 PM
 */
public class ThreadGroupTest3 {
	public static void main(String[] args) throws InterruptedException {
		ThreadGroup threadGroup = new ThreadGroup("MyThreadGroup");
		for(int i = 0; i < 3; i++) {
			ThreadC threadC = new ThreadC(threadGroup, "aaaaaaaa_" + i);
			threadC.start();
		}
		
		Thread.sleep(10000);
		threadGroup.interrupt();
	}
}
