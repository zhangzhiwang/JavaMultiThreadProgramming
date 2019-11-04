package com.asiainfo.chapter4;

public class Provider extends Thread {
	/**
	 * 实现一生产和一消费交替进行
	 */
//	public void run() {
//		TestMultiProviderConsumer.lock.lock();
//		while(TestMultiProviderConsumer.hasSth) {
//			try {
//				TestMultiProviderConsumer.condition.await();
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//		
//		TestMultiProviderConsumer.hasSth = true;
//		System.out.println(Thread.currentThread().getName() + "生产了一个产品");
//		TestMultiProviderConsumer.condition.signalAll();
//		TestMultiProviderConsumer.lock.unlock();
//	}

	/**
	 * 实现多生产和多消费同时进行
	 */
	public void run() {
		while (true) {
			TestMultiProviderConsumer.lock.lock();
			while (TestMultiProviderConsumer.list.size() == 10) {
				try {
					TestMultiProviderConsumer.condition.await();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			TestMultiProviderConsumer.list.add(1);
			System.out.println(Thread.currentThread().getName() + "生产了一个产品，目前总数为：" + TestMultiProviderConsumer.list.size());
			TestMultiProviderConsumer.condition.signalAll();
			TestMultiProviderConsumer.lock.unlock();
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
