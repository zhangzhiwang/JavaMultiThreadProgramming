package com.asiainfo.chapter1;

/**
 * suspend方法挂起线程。该方法被弃用，原因是suspend挂起线程后不释放锁直至其他线程调用该线程对象的resume方法，再挂起期间其他线程如果需要获取该对象锁将一直处于阻塞状态，这就导致锁独占的问题。</p>
 * 另外，resume方法在suspend方法之前调用任然会出现锁独占的问题。还有一点就是用suspend挂起线程后线程的状态仍然是RUNNABLE。
 *
 * @author zhangzhiwang
 * @date Nov 11, 2019 2:57:33 PM
 */
public class SuspendTest {
	public static Object obj = new Object();
	
	public static void met1() {
		synchronized (obj) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + "--->met1");
			Thread.currentThread().suspend();
		}
	}
	
	public static void met2() {
		synchronized (obj) {
			System.out.println(Thread.currentThread().getName() + "--->met2");
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		MyThread20 myThread20 = new MyThread20();
		myThread20.setName("t1");
		myThread20.start();
		myThread20.resume();
		System.out.println("myThread20已经resume了");
		
		Thread.sleep(10);
		MyThread21 myThread21 = new MyThread21();
		myThread21.setName("t2");
		myThread21.start();
		
		Thread.sleep(5000);
		System.out.println(myThread20.getState());
	}
}
