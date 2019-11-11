package com.asiainfo.chapter7;

/**
 * enumerate方法
 *
 * @author zhangzhiwang
 * @date Nov 6, 2019 5:33:26 PM
 */
public class EnumerateTest {
	public static void main(String[] args) {
		Thread[] ts = new Thread[Thread.currentThread().activeCount()];
		Thread.enumerate(ts);
//		Thread.currentThread().enumerate(ts);
		for(Thread t : ts) {
			if(t != null) {
				System.out.println(t.getName());
			}
		}
		
//		ThreadGroup mainGroup = Thread.currentThread().getThreadGroup();
//		ThreadGroup sonGroup = new ThreadGroup(mainGroup, "sonGroup");
//		ThreadGroup[] tgs = new ThreadGroup[mainGroup.activeGroupCount()];
//		mainGroup.enumerate(tgs);
//		for(ThreadGroup tg : tgs) {
//			if(tg != null) {
//				System.out.println(tg.getName());
//			}
//		}
	}
}
