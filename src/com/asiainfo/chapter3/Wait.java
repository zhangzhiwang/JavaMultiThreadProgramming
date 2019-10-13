package com.asiainfo.chapter3;

/**
 * wait()方法
 *
 * @author zhangzhiwang
 * @date 2019年10月13日 下午4:04:14
 */
public class Wait {
	public static void main(String[] args) throws InterruptedException {
//		Object o = new Object();
//		o.wait();// 会抛出java.lang.IllegalMonitorStateException，不合法的监视器状态异常，既没有锁。所以，在调用wait()方法之前必须持有锁，也就是说wait()方法必须在同步方法或者同步块内部调用
		
		String s = new String();
		System.out.println("before sync");
		synchronized (s) {
			System.out.println("in sync 1st");
			Wait wait = new Wait();
//			wait.wait();// 在sync同步块内调用wait()方法仍然会抛java.lang.IllegalMonitorStateException。注意：在调用wait()方法前，线程必须持有调用wait()方法对象的锁。本例中，调用wait()方法的对象和线程锁住的对象不是同一个
			s.wait();// 这样就不会抛异常了。但是线程停止不了，因为当前线程已经暂停下来并释放了锁，没有其他线程来唤醒它。
		}
	}
}
