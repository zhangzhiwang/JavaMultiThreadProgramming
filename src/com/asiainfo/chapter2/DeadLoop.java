package com.asiainfo.chapter2;

import java.util.ArrayList;
import java.util.List;

/**
 * 死循环
 *
 * @author zhangzhiwang
 * @date 2019年10月4日 下午2:04:06
 */
public class DeadLoop extends Thread {
	private volatile boolean flag = true;

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	
	public void run() {
		System.out.println("run start...");
		while(flag) {}
		System.out.println("run stop!");
	}
	
	public static void main(String[] args) throws InterruptedException {
		DeadLoop deadLoop = new DeadLoop();
		deadLoop.start();
		
		Thread.sleep(1000);
		deadLoop.setFlag(false);
		System.out.println("flag = " + deadLoop.flag);
	}
}