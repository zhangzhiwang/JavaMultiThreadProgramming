package com.asiainfo.chapter2;

import java.util.ArrayList;
import java.util.List;

/**
 * 停不下来的程序
 *
 * @author zhangzhiwang
 * @date 2019年10月4日 下午2:04:06
 */
public class CannotStop {
	private boolean flag = true;

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	
	public void met1() throws InterruptedException {
		while(flag) {
			System.out.println(Thread.currentThread().getName());
			Thread.sleep(1000);
		}
	}

	public static void main(String[] args) throws InterruptedException {
		CannotStop cannotStop = new CannotStop();
		cannotStop.met1();// 为什么程序停不下来？因为这是一个单线程程序，met1是个死循环，下面的两行代码根本不会执行！可以用多线程来解决这个问题
		
		Thread.sleep(3000);
		cannotStop.setFlag(false);
	}
}