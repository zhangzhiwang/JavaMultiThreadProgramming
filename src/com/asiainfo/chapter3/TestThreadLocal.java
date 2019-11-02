package com.asiainfo.chapter3;

public class TestThreadLocal {
	public static void main(String[] args) {
//		ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>();
//		if (threadLocal.get() == null) {
//			System.out.println("从未在ThreadLocal里面放过值");
//			threadLocal.set(1);
//		}
//		System.out.println(threadLocal.get());
		
//		new ThreadH().start();
//		new ThreadI().start();
//		new ThreadJ().start();
		
		ThreadLocalExt threadLocalExt = new ThreadLocalExt();
//		if(threadLocalExt.get() == null) {
//			System.out.println("a");
//		} else {
//			System.out.println("b");
//		}
		System.out.println(threadLocalExt.get());
	}
}
