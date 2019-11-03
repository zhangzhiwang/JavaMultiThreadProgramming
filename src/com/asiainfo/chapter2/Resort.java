package com.asiainfo.chapter2;

import com.asiainfo.chapter3.ThreadM;

/**
 * 代码重排序
 *
 * @author zhangzhiwang
 * @date 2019年11月3日 下午1:19:16
 */
public class Resort {
	private static int x = 0;
	private static int y = 0;
	private static int a = 0;
	private static int b = 0;
	private static int c = 0;
	private static int d = 0;
	private static int e = 0;
	private static int f = 0;
	private static int count;

	public static void main(String[] args) throws InterruptedException {
		for (;;) {
			x = 0;
			y = 0;
			a = 0;
			b = 0;
			c = 0;
			d = 0;
			e = 0;
			f = 0;
			count++;
			
			Thread t1 = new Thread(new Runnable() {
				@Override
				public void run() {
					a = 1;
					c = 101;
					d = 102;
					x = b;
				}
			});
			
			Thread t2 = new Thread(new Runnable() {
				@Override
				public void run() {
					b = 1;
					e = 101;
					f = 102;
					y = a;
				}
			});
			
			t1.start();
			t2.start();
			t1.join();
			t2.join();
			
			String s = "第" + count + "次，x = " + x + ",y = " + y;
			if(x == 0 && y == 0) {
				System.err.println("err:" + s);
				break;
			} else {
//				System.out.println(s);
			}
		}
	}
}
