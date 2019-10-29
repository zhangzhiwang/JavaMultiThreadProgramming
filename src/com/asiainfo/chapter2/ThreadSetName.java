package com.asiainfo.chapter2;

import java.util.ArrayList;
import java.util.List;

/**
 * 给线程设置名称既可以在start前也可以在start后
 *
 * @author zhangzhiwang
 * @date 2019年10月4日 下午2:04:06
 */
public class ThreadSetName extends Thread {
	public void run() {
		for(;;) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName());
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		ThreadSetName t = new ThreadSetName();
		t.setName("A");
		t.start();
		
		Thread.sleep(5000);
		t.setName("B");
	}
}