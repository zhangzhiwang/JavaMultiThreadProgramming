package com.asiainfo;

/**
 * 当前线程堆栈跟踪信息
 *
 * @author zhangzhiwang
 * @date Oct 1, 2019 11:48:01 PM
 */
public class MyThread10 {// 注意：这里MyThread10不是线程类，就是一个普通的类
	public static void main(String[] args) {
		MyThread10 myThread10 = new MyThread10();
		myThread10.a();
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
//	public void e() {
//		StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
//		System.out.println("stackTrace.length=" + stackTrace.length);
//		if(stackTrace != null && stackTrace.length > 0) {
//			for(StackTraceElement element : stackTrace) {
//				System.out.println("className=" + element.getClassName() + ",methodName=" + element.getMethodName() + ",fileName=" + element.getFileName() + ",lineNumber=" + element.getLineNumber());
//			}
//		}
//	}
	
	public void e() {
		Thread.dumpStack();
	}
	
}
