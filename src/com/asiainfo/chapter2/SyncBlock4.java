package com.asiainfo.chapter2;

/**
 * synchronized关键字修饰方法和synchronized(this)都是锁定调用该方法的对象
 *
 * @author zhangzhiwang
 * @date 2019年10月4日 下午2:04:06
 */
public class SyncBlock4 extends Thread {
	String s = new String();
	
	public synchronized void met1() throws InterruptedException {
		System.out.println("met1---同步代码块：" + Thread.currentThread().getName());
	}
	
	public void met2() throws InterruptedException {
//		synchronized (s) {// 和met1()方法锁的不是一个对象
		synchronized (this) {
			for (int i = 0; i < 10000; i++) {
				System.out.println("同步代码块：" + Thread.currentThread().getName() + ",i=" + i);
			}
		}
	}

	public void run() {
		try {
			met1();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws InterruptedException {
//		final SyncBlock4 block = new SyncBlock4();
//		Thread t2 = new Thread(block) {
//			public void run() {
//				try {
//					block.met2();// 会等待A线程执行完释放锁之后再执行，因为synchronized修饰方法和synchronized (this)都是锁定调用该方法的当前对象
//				} catch (InterruptedException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}
//		};
//		t2.setName("B");
//		t2.start();
//		
////		Thread.sleep(1000);
//		Thread t1 = new Thread(block);
//		t1.setName("A");
//		t1.start();
		
		Object o1 =  new Object();
		Object o2 = o1;
		Object o3 = o1;
		System.out.println(o2 == o3);
	}
}
