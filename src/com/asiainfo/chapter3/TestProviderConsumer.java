package com.asiainfo.chapter3;

/**
 * 生产者消费者模式测试
 *
 * @author zhangzhiwang
 * @date Oct 21, 2019 10:01:36 PM
 */
public class TestProviderConsumer {
	public static void main(String[] args) {
		String s = "123";
		
		Producer puProducer = new Producer(s);
		puProducer.start();
		
		Consumer consumer = new Consumer(s);
		consumer.start();
	}
	
	 public  void met1( String s) {
		 int i=0;
	 }
}
