package com.asiainfo.chapter7;

/**
 * 获取某个线程组下的所有子孙组
 *
 * @author zhangzhiwang
 * @date Nov 6, 2019 2:22:04 PM
 */
public class ThreadGroupTest4 {
	public static void main(String[] args) throws InterruptedException {
		ThreadGroup mainGroup = Thread.currentThread().getThreadGroup();
		System.out.println("当前线程组是：" + mainGroup.getName());
		
		ThreadGroup sonGroup = new ThreadGroup(mainGroup, "sonGroup");
		ThreadGroup grandsonGroup = new ThreadGroup(sonGroup, "grandsonGroup");
		
		System.out.println("现在mainGroup下面共有子孙组的个数：" + mainGroup.activeGroupCount());
		
		ThreadGroup[] tg1 = new ThreadGroup[mainGroup.activeGroupCount()];
		mainGroup.enumerate(tg1, false);// 如果传false则只获取当前线程组下面的一级子线程组，传true则递归取出下面的所有子孙线程组
		for(ThreadGroup tg : tg1) {
			if(tg == null) {
				continue;
			}
			System.err.println("--------" + tg.getName());
		}
	}
}
