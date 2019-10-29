package com.asiainfo.chapter3;

/**
 * 当wait()方法遇到interrupt()方法会抛出InterruptedException
 *
 * @author zhangzhiwang
 * @date Oct 13, 2019 7:28:11 PM
 */
public class WaitMeetInterrupt {
	public void met1(Object o) {
		synchronized (o) {
			System.out.println("begin...");
			try {
				o.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("当wait()方法遇到interrupt()方法会抛出InterruptedException");
			}
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		T1 t1 = new T1(new Object());
		t1.start();
		
		Thread.sleep(1000);
		t1.interrupt();
	}
	
	static class T1 extends Thread {
		private Object o;

		public T1(Object o) {
			super();
			this.o = o;
		}
		
		public void run() {
			WaitMeetInterrupt w = new WaitMeetInterrupt();
			w.met1(o);
		}
	}
}
