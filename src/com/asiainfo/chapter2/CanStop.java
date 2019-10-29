package com.asiainfo.chapter2;

import java.util.ArrayList;
import java.util.List;

/**
 * 使用多线程解决CannotStop.java的问题
 *
 * @author zhangzhiwang
 * @date 2019年10月4日 下午2:04:06
 */
public class CanStop extends Thread {
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
	
	public void run() {
		try {
			met1();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws InterruptedException {
		CanStop cannotStop = new CanStop();
		Thread t = new Thread(cannotStop);
		t.start();
		
		Thread.sleep(3000);
		cannotStop.setFlag(false);
	}
}