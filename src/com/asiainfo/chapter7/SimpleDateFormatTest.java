package com.asiainfo.chapter7;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * SimpleDateFormat的非线程安全问题
 *
 * @author zhangzhiwang
 * @date Nov 6, 2019 5:53:54 PM
 */
public class SimpleDateFormatTest {
	public static void main(String[] args) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//		String s1 = "2000-01-01";
//		// 将字符串类型转换成日期类型
//		Date date = sdf.parse(s1);
//		// 将日期类型再转化为字符串类型
//		String s2 = sdf.format(date);
//		System.out.println(s1.equals(s2));// 在多线程环境下可能出现问题

		String[] ss = new String[] { "1999-09-09", "2001-11-12", "2002-03-19", "2004-01-31", "2003-12-12" };

		for (int i = 0; i < 5; i++) {
			new ThreadD(new SimpleDateFormat("yyyy-MM-dd"), ss[i]).start();
		}
	}
}
