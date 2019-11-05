package com.asiainfo.chapter5;

import java.util.TimerTask;

public class MyTask2 extends TimerTask {
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + ",task2任务开始运行");
	}
}
