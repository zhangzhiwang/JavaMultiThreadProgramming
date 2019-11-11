package com.asiainfo.chapter7;

/**
 * Thead.activeCount()
 *
 * @author zhangzhiwang
 * @date Nov 6, 2019 5:18:03 PM
 */
public class ActiveCountTest {
	public static void main(String[] args) {
		ThreadGroup threadGroup = new ThreadGroup(Thread.currentThread().getThreadGroup(), "sonGroup");
		Thread t1 = new Thread(threadGroup, new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					Thread.sleep(10000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}});
		t1.start();
		System.out.println(Thread.activeCount());// 打开activeCount方法，里面调用的就是Thread.currentThread().getThreadGroup()
		System.out.println(Thread.currentThread().getThreadGroup().activeCount());
	}
}
