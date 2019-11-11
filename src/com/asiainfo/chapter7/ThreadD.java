package com.asiainfo.chapter7;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ThreadD extends Thread {
	private SimpleDateFormat sdf;
	private String dateStr;

	public ThreadD(SimpleDateFormat sdf, String dateStr) {
		super();
		this.sdf = sdf;
		this.dateStr = dateStr;
	}

	public void run() {
		try {
			// 将字符串类型转换成日期类型
			Date date = sdf.parse(dateStr);
			// 将日期类型再转化为字符串类型
			String s2 = sdf.format(date);
			boolean isEqual = dateStr.equals(s2);
			if(isEqual) {
				System.out.println("转来转去都一样");
			} else {
				System.out.println("出问题了：" + dateStr + "被转换成" + s2);
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
}
