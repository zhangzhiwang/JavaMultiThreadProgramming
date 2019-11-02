package com.asiainfo.chapter3;

/**
 * 测试join方式释放锁
 *
 * @author zhangzhiwang
 * @date 2019年11月2日 下午5:14:50
 */
public class TestJoinReleaseLock extends Thread {
	private ThreadF threadF;

	public TestJoinReleaseLock(ThreadF threadF) {
		super();
		this.threadF = threadF;
	}
	
	public void run() {
		synchronized (threadF) {
			try {
				threadF.start();
//				Thread.sleep(10000);// sleep(long)不释放锁
				threadF.join();// join()/join(long)释放锁
				System.out.println("TestJoinReleaseLock sleep end!");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) throws InterruptedException {
		ThreadF threadF = new ThreadF();
		TestJoinReleaseLock testJoinReleaseLock = new TestJoinReleaseLock(threadF);
		testJoinReleaseLock.start();
		
		Thread.sleep(1000);
		
		ThreadG threadG = new ThreadG(threadF);
		threadG.start();
	}
}
