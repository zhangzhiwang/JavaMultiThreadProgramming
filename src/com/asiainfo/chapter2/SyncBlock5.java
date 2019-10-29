package com.asiainfo.chapter2;

import java.util.ArrayList;
import java.util.List;

/**
 * synchronized锁定局部变量
 *
 * @author zhangzhiwang
 * @date 2019年10月4日 下午2:04:06
 */
public class SyncBlock5 extends Thread {
	private Tmp tmp;

	public SyncBlock5(Tmp tmp) {
		super();
		this.tmp = tmp;
	}

	public void run() {
		met1(tmp);
	}

	public void met1(Tmp t) {
		synchronized (t) {// 虽然synchronized锁定的是局部变量t，但是t是一个引用，它指向的是堆中的对象，所以synchronized实际上锁定的是堆中t指向的对象
			if (t.getSize() < 1) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				t.add();
			}
		}
	}

	public static void main(String[] args) throws InterruptedException {
		Tmp tmp = new Tmp();
		SyncBlock5 syncBlock5 = new SyncBlock5(tmp);
		syncBlock5.start();

//		Thread.sleep(3000);
		SyncBlock5_1 syncBlock5_1 = new SyncBlock5_1(tmp);
		syncBlock5_1.start();

		Thread.sleep(3000);
		System.out.println(tmp.getSize());
	}
}

class Tmp {// 需求：list只能添加一个元素，所以list的最大size是1
	private List<Integer> list = new ArrayList<Integer>();

	public void add() {
		list.add(1);
	}

	public int getSize() {
		return list.size();
	}
}

class SyncBlock5_1 extends Thread {
	private Tmp tmp;

	public SyncBlock5_1(Tmp tmp) {
		super();
		this.tmp = tmp;
	}

	public void run() {
		met1(tmp);
	}

	public void met1(Tmp t) {
		synchronized (t) {
			if (t.getSize() < 1) {
				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				t.add();
			}
		}
	}
}
