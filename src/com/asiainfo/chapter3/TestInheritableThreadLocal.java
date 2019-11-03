package com.asiainfo.chapter3;

/**
 * InheritableThreadLocal具有使子线程继承父线程值的特性
 *
 * @author zhangzhiwang
 * @date 2019年11月3日 上午10:37:33
 */
public class TestInheritableThreadLocal {
	public static InheritableThreadLocal<String> inheritableThreadLocal = new InheritableThreadLocal<String>();
	public static InheritableThreadLocal<User> inheritableThreadLocal2 = new InheritableThreadLocal<User>();
	public static InheritableThreadLocalExt inheritableThreadLocal3 = new InheritableThreadLocalExt();
	
//	public static void main(String[] args) throws InterruptedException {
////		for(int i = 0; i < 5; i++) {
//			if(inheritableThreadLocal.get() == null) {
//				System.out.println("第一次需要set");
//				inheritableThreadLocal.set("main_set");
//			}
//			System.out.println("main get = " + inheritableThreadLocal.get());
////		}
//		
//		ThreadK threadK = new ThreadK();// 当一个线程A中新建并启动了另一个线程B，那么A线程就是B线程的父线程。子线程并不会因父线程的运行结束而结束，进程的结束是等所有非守护线程都结束后才结束。
//		threadK.start();
//		
//		Thread.sleep(5000);
////		ThreadL threadL = new ThreadL();// 非父子关系的线程，InheritableThreadLocal和ThreadLocal的作用是一样的
////		threadL.start();
//		
//		inheritableThreadLocal.set("main_set----------------");
//		System.out.println("main update value:main_set----------------");
//	}
	
//	public static void main(String[] args) throws InterruptedException {
//		if(inheritableThreadLocal.get() == null) {
//			System.out.println("第一次需要set");
//			inheritableThreadLocal.set("main_set");
//		}
//		System.out.println("main get = " + inheritableThreadLocal.get());
//		
//		ThreadK threadK = new ThreadK();
//		threadK.start();
//		
//		Thread.sleep(2000);
//		for(;;) {
//			System.out.println("	main get again = " + inheritableThreadLocal.get());
//			Thread.sleep(900);
//		}
//	}
	
//	public static void main(String[] args) throws InterruptedException {
//		User user = new User();
//		user.setName("中国");
//		if(inheritableThreadLocal2.get() == null) {
//			System.out.println("第一次需要set");
//			inheritableThreadLocal2.set(user);
//		}
//		ThreadM threadM = new ThreadM();
//		threadM.start();
//		
//		Thread.sleep(5000);
//		user.setName("America");
//	}
	
	public static void main(String[] args) {
		if(inheritableThreadLocal3.get() == null) {
			System.out.println("第一次需要set");
			inheritableThreadLocal3.set("main_set");
		}
		System.out.println("main get = " + inheritableThreadLocal3.get());
		
		ThreadK threadK = new ThreadK();
		threadK.start();
	}
}
