package com.asiainfo.chapter3;

/**
 * 生产者消费者模式测试
 *
 * @author zhangzhiwang
 * @date Oct 21, 2019 10:01:36 PM
 */
public class TestProviderConsumer2 {
	public static void main(String[] args) {
		MyStack myStack = new MyStack();

		// 一个生产者一个消费者
//		Producer2 producer = new Producer2(myStack);
//		Consumer2 consumer = new Consumer2(myStack);

		// 一个生产者多个消费者：notify出现假死
//		Producer2 producer = new Producer2(myStack);
//		producer.setName("producer");
//		Consumer2 consumer1 = new Consumer2(myStack);
//		consumer1.setName("consumer1");
//		Consumer2 consumer2 = new Consumer2(myStack);
//		consumer2.setName("consumer2");

		// 多个生产者一个消费者：notify出现假死
//		Producer2 producer1 = new Producer2(myStack);
//		producer1.setName("producer1");
//		Producer2 producer2 = new Producer2(myStack);
//		producer2.setName("producer2");
//		Consumer2 consumer1 = new Consumer2(myStack);
//		consumer1.setName("consumer1");
		
		// 多个生产者多个消费者：notify出现假死
		Producer2 producer1 = new Producer2(myStack);
		producer1.setName("producer1");
		Producer2 producer2 = new Producer2(myStack);
		producer2.setName("producer2");
		Consumer2 consumer1 = new Consumer2(myStack);
		consumer1.setName("consumer1");
		Consumer2 consumer2 = new Consumer2(myStack);
		consumer2.setName("consumer2");

		producer1.start();
		producer2.start();
		consumer1.start();
		consumer2.start();
	}
}
