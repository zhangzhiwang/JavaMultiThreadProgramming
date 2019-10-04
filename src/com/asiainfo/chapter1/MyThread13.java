package com.asiainfo.chapter1;

import java.util.Map;

/**
 * 对interrupt()方法的理解
 *
 * @author zhangzhiwang
 * @date Oct 1, 2019 11:48:01 PM
 */
public class MyThread13 extends Thread {
	public void run() {
		for(int i = 0; i < 5000000; i++) {
			if(this.isInterrupted()) {
//				System.out.println("你建议我停止，但我不接受你的建议！继续运行！");
				System.out.println("你建议我停止，我接受你的建议！退出运行！");
				return;
			}
			System.out.println(i);
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		MyThread13 myThread13 = new MyThread13();
		myThread13.start();
		Thread.sleep(1000);
		myThread13.interrupt();
	}
}
