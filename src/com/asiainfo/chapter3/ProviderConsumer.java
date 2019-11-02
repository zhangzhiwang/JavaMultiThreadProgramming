package com.asiainfo.chapter3;

/**
 * 生产者和消费者交替运行（生产-消费-生产-消费-生产-消费……）
 *
 * @author zhangzhiwang
 * @date 2019年11月2日 下午3:21:32
 */
public class ProviderConsumer {
	private boolean isProvider = false;

	public synchronized void produce() throws InterruptedException {
		while (isProvider) {
			wait();
		}

		System.out.println("+++++++++++++++++");
		isProvider = true;
		notifyAll();
	}

	public synchronized void consume() throws InterruptedException {
		while (!isProvider) {
			wait();
		}

		System.out.println("--------");
		isProvider = false;
		notifyAll();
	}
}