package com.asiainfo.chapter2;

/**
 * 当线程抛出异常时会释放锁
 *
 * @author zhangzhiwang
 * @date 2019年10月4日 下午2:04:06
 */
public class SyncException extends Thread {
	public synchronized void met1() {
		for (int i = 0; i < 500; i++) {
			if(i == 100) {
				throw new RuntimeException("出异常了");
			}
			System.out.println(Thread.currentThread().getName() + "------>" + i);
		}
	}

	public void run() {
		met1();
	}

	public static void main(String[] args) throws InterruptedException {
		SyncException syncException = new SyncException();
		Thread t1 = new Thread(syncException);
		t1.setName("A");
		t1.start();
		Thread.sleep(10);

		Thread t2 = new Thread(syncException);
		t2.setName("B");
		t2.start();
	}
}
