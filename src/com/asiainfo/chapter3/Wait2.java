package com.asiainfo.chapter3;

/**
 * wait(long)方法
 *
 * @author zhangzhiwang
 * @date 2019年10月13日 下午4:04:14
 */
public class Wait2 extends Thread {
	private Object o = new Object();

	public void run() {
		synchronized (o) {
			System.out.println("wait begin...");
			try {
				o.wait(10000);// wait(long)方法在指定的时间内如果没有其他线程唤醒它那么时间到了会重新进入可运行状态并且等待获取对象锁，获取对象锁后会接着wait(long)下面运行；如果指定的时间内有其它线程唤醒它那么该线程会立即进入可运行状态并尝试重新获取对象锁
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("wait end!");
		}
	}

	public static void main(String[] args) throws InterruptedException {
		Wait2 wait2 = new Wait2();
		wait2.start();
		
		Thread.sleep(100);
		new T1(wait2).start();
	}

	static class T1 extends Thread {
		private Wait2 wait2;

		public T1(Wait2 wait2) {
			super();
			this.wait2 = wait2;
		}

		public void run() {
			synchronized (wait2.o) {
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				wait2.o.notify();
			}
		}
	}
}
