package com.asiainfo.chapter3;

/**
 * join(long l)方法——时间到后当前线程会继续运行而无论被join的线程是否执行完
 *
 * @author zhangzhiwang
 * @date 2019年11月2日 下午5:09:36
 */
public class TestJoinLong {
	public static void main(String[] args) throws InterruptedException {
		ThreadE threadE = new ThreadE();
		threadE.start();
		threadE.join(3000);
//		Thread.sleep(3000);// join(long l)和sleep(long l)的区别就是前者释放锁，后者不释放锁。因为前者调用了wait，wait是释放锁的
		
		System.out.println("main end!");
	}
}
