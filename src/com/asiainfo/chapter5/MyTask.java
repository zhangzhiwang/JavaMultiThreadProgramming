package com.asiainfo.chapter5;

import java.util.TimerTask;

public class MyTask extends TimerTask {
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + ",task1任务开始运行");
//		try {
//			Thread.sleep(10000);
//			this.cancel();// 将本任务从任务队列移除
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}
}
