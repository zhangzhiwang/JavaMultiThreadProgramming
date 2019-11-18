package com.asiainfo.chapter7;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ThreadF extends Thread {
	public void run() {
		System.out.println("ThreadF start...");
		for (int i = 0; i < 1000; i++) {
			double random = Math.random();
			Math.log10(random);
		}
//		boolean interrupted = Thread.interrupted();
		boolean interrupted = this.isInterrupted();
		System.out.println("1:" + interrupted);

//		interrupted = Thread.interrupted();
		interrupted = this.isInterrupted();
		System.out.println("2:" + interrupted);
		System.out.println("ThreadF end!");
	}
}
