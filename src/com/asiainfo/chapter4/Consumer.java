package com.asiainfo.chapter4;

public class Consumer extends Thread {
	/**
	 * 实现一生产和一消费交替进行
	 */
//	public void run() {
//		TestMultiProviderConsumer.lock.lock();
//		while(!TestMultiProviderConsumer.hasSth) {
//			try {
//				TestMultiProviderConsumer.condition.await();
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//		
//		TestMultiProviderConsumer.hasSth = false;
//		System.out.println("	" + Thread.currentThread().getName() + "消费了一个产品");
//		TestMultiProviderConsumer.condition.signalAll();
//		TestMultiProviderConsumer.lock.unlock();
//	}

	/**
	 * 实现多生产和多消费同时进行
	 */
	public void run() {
		while (true) {
			TestMultiProviderConsumer.lock.lock();
			while (TestMultiProviderConsumer.list.size() == 0) {
				try {
					TestMultiProviderConsumer.condition.await();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			TestMultiProviderConsumer.list.remove(0);
			System.out.println("	" + Thread.currentThread().getName() + "消费了一个产品，目前总数为：" + TestMultiProviderConsumer.list.size());
			TestMultiProviderConsumer.condition.signalAll();
			TestMultiProviderConsumer.lock.unlock();
		}
	}
}
