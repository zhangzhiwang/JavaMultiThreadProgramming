package com.asiainfo.chapter2;

/**
 * synchronized关键字
 *
 * @author zhangzhiwang
 * @date 2019年10月4日 下午2:04:06
 */
public class Sync {
	public void test() {
		synchronized (this) {
			int age = 100;
		}
	}

	public static void main(String[] args) {
		Sync sync = new Sync();
		sync.test();
	}
}
