package com.asiainfo.chapter2;

/**
 * synchronized同步代码块
 *
 * @author zhangzhiwang
 * @date 2019年10月4日 下午2:04:06
 */
public class SyncBlock extends Thread {
	public void met1() throws InterruptedException {
		synchronized(this) {// 如果将同步代码块将方法全包围跟在方法声明处写synchronized关键字没什么区别，因为同步代码块的作用就是减小锁的粒度
			System.out.println(Thread.currentThread().getName() + " begin:");
			Thread.sleep(3000);
			System.out.println(Thread.currentThread().getName() + " end!");
		}
	}
	
	public void run() {
		try {
			met1();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		SyncBlock block = new SyncBlock();
		Thread t1 = new Thread(block);
		t1.setName("A");
		t1.start();
		
		Thread t2 = new Thread(block);
		t2.setName("B");
		t2.start();
	}
}
