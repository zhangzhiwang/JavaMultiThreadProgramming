package com.asiainfo.chapter3;

public class ThreadLocalExt extends ThreadLocal<String> {
	@Override
	protected String initialValue() {// 初始的默认值也具有线程的隔离性，因为默认值也和当前线程做了绑定，看一下ThreadLocal类的get()方法的源码便知
		return "default value!";
	}
}
