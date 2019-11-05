package com.asiainfo.chapter5;

import java.util.Calendar;
import java.util.Timer;

/**
 * 定时器Timer——Timer使用来在指定时间调度任务的，一个任务就是一个TimerTask（实际为TimerTask的子类）
 *
 * @author zhangzhiwang
 * @date Nov 5, 2019 12:24:42 PM
 */
public class TimerTest {
	public static void main(String[] args) throws InterruptedException {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.SECOND, -10);
		
		Timer timer = new Timer();
		MyTask myTask = new MyTask();
//		MyTask2 myTask2 = new MyTask2();
		// 定时器Timer调度任务TimerTask
//		timer.schedule(myTask, calendar.getTime());
		timer.schedule(myTask, calendar.getTime(), 3000);
//		timer.scheduleAtFixedRate(myTask, calendar.getTime(), 3000);
//		timer.schedule(myTask2, 3000, 1000);
//		timer.schedule(myTask2, 4000);// 注意：这里的schedule是调度任务的意思，不代表让任务运行，任务什么时间开始运行还取决于队列里排在本任务前面的任务是否执行完，只有前面的任务执行完本任务才开始运行
		
//		Thread.sleep(10000);
//		timer.cancel();// 停止被该定时器调度的所有任务
	}
}
