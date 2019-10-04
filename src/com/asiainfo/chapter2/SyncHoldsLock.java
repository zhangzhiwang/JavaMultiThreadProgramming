package com.asiainfo.chapter2;

/**
 * holdsLock()
 *
 * @author zhangzhiwang
 * @date 2019年10月4日 下午4:07:28
 */
public class SyncHoldsLock {
	public static void main(String[] args) {
		System.out.println(Thread.holdsLock(SyncHoldsLock.class));
		synchronized (SyncHoldsLock.class) {
			System.out.println(Thread.holdsLock(SyncHoldsLock.class));
		}
		System.out.println(Thread.holdsLock(SyncHoldsLock.class));
	}
}
