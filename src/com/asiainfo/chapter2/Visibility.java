package com.asiainfo.chapter2;

/**
 * 可见性
 *
 * @author zhangzhiwang
 * @date 2019年10月13日 下午1:32:10
 */
public class Visibility extends Thread {
	private boolean flag = true;

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	
	
	public void run() {
		System.out.println("run start...");
		Integer i = new Integer(1);
		while(flag) {
//			System.out.println("in while ----> " + Thread.currentThread().getName());
//			try {
//				Thread.sleep(1000);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			System.out.println();// 如果flag变量不加volatile关键字，并且本while循环体是空的，那么会出现线程无法停下来的现象。解决方法一个是给flag变量加上关键字volatile，一个是在while循环体里面加上synchronized关键字，比如加一行System.out.println()，因为println()方法使用synchronized修饰的
			synchronized (i) {
				
			}
		}
		System.out.println("run end!");
	}
	
	public static void main(String[] args) throws InterruptedException {
		Visibility visibility = new Visibility();
		visibility.start();
		
		Thread.sleep(1000);
		visibility.setFlag(false);
	}
	
}
