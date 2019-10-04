package com.asiainfo;

import java.util.Map;

/**
 * 获取一个进程的所有线程堆栈跟踪信息
 *
 * @author zhangzhiwang
 * @date Oct 1, 2019 11:48:01 PM
 */
public class MyThread11 {// 注意：这里的MyThread11不是线程类
	public static void main(String[] args) throws InterruptedException {
//		MyThread11 myThread11 = new MyThread11();
//		myThread11.a();
		Thread currentThread = Thread.currentThread();
		System.out.println(currentThread.getName() + "," + currentThread.getId());
	}
	
	public void a() {
		b();
	}
	public void b() {
		c();
	}
	public void c() {
		d();
	}
	public void d() {
		e();
	}
	
	@SuppressWarnings("static-access")
	public void e() {
		Map<Thread, StackTraceElement[]> allStackTraces = Thread.currentThread().getAllStackTraces();
		System.out.println("该进程一共有" + allStackTraces.size() + "个线程。");
		for(Thread thread : allStackTraces.keySet()) {
			System.out.println("------每个线程的基本信息---------");
			System.out.println("线程名：" + thread.getName());
			System.out.println("线程活跃状态：" + thread.isAlive());
			System.out.println("是否为守护线程：" + thread.isDaemon());
			System.out.println("该线程的堆栈跟踪信息为：");
			StackTraceElement[] stackTraceElements = allStackTraces.get(thread);
			if(stackTraceElements == null || stackTraceElements.length == 0) {
				System.out.println("该线程没有堆栈跟踪信息");
			} else {
				for(StackTraceElement element : stackTraceElements) {
					System.out.println("className=" + element.getClassName() + ",methodName=" + element.getMethodName() + ",fileName=" + element.getFileName() + ",lineNumber=" + element.getLineNumber());
				}
			}
		}
	}
}
