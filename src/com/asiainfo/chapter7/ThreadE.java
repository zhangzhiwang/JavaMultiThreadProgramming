package com.asiainfo.chapter7;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ThreadE extends Thread {
	public void run() {
		System.out.println("ThreadE start...");
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("ThreadE end!");
	}
}
