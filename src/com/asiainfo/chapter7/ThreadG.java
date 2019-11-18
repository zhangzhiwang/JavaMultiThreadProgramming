package com.asiainfo.chapter7;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ThreadG extends Thread {
	public void run() {
		for (int i = 0; i < 3; i++) {
			try {
				for (int j = 0; j < 1000; j++) {
					double random = Math.random();
					Math.log10(random);
				}
				boolean interrupted = this.isInterrupted();
				System.out.println(interrupted);
//				Thread.sleep(1000);
//				throw new InterruptedException("aaa");
				throw new RuntimeException("aaa");
			} catch (Exception e) {
				System.out.println("被打断：" + e.getMessage());
			}
		}
	}
}
