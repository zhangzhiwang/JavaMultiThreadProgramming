package com.asiainfo.chapter4;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * getWaitQueueLength方法——统计同一个Condition调用await的线程数
 *
 * @author zhangzhiwang
 * @date Nov 4, 2019 1:34:04 PM
 */
public class GetWaitQueueLengthTest {
	public static ReentrantLock lock = new ReentrantLock();
	public static Condition condition = lock.newCondition();
	
	public void met1() throws InterruptedException {
		lock.lock();
		System.out.println(Thread.currentThread().getName() + "在等待！");
		condition.await();
		lock.unlock();
	}
	
	public void met2() {
		lock.lock();
		System.out.println("同一个Condition调用await的线程数：" + lock.getWaitQueueLength(condition));
		lock.unlock();
	}
	
	public void met3() {
		lock.lock();
		condition.signal();
		lock.unlock();
	}
	
	public static void main(String[] args) throws InterruptedException {
		final GetWaitQueueLengthTest getWaitQueueLengthTest = new GetWaitQueueLengthTest();
		for (int i = 0; i < 10; i++) {
//			if(i == 9) {
//				getWaitQueueLengthTest.met3();
//			}
			Thread t = new Thread(new Runnable() {
				@Override
				public void run() {
					try {
						getWaitQueueLengthTest.met1();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			});
			t.start();
		}
		
		Thread.sleep(1000);
		getWaitQueueLengthTest.met2();
	}
}
