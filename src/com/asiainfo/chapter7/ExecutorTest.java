package com.asiainfo.chapter7;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 创建线程的方式四——使用线程池的方式创建
 *
 * @author zhangzhiwang
 * @date Nov 11, 2019 2:38:40 PM
 */
public class ExecutorTest {
	public static void main(String[] args) throws InterruptedException {
		ExecutorService executorService = Executors.newFixedThreadPool(5);
		for(int i = 0; i < 5; i++) {
			executorService.execute(new MyThread());
		}
		
		Thread.sleep(10000);
		executorService.shutdown();
	}
	
	static class MyThread extends Thread {
		public void run() {
			System.out.println(Thread.currentThread().getName() + "运行run方法");
		}
	}
}
