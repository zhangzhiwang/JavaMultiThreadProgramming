package com.asiainfo.chapter4;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 测试多生产者和多消费者交替进行，即生产一个消费一个
 *
 * @author zhangzhiwang
 * @date Nov 4, 2019 8:17:42 AM
 */
public class TestMultiProviderConsumer {
	public static boolean hasSth = false;
	public static Lock lock = new ReentrantLock();
	public static Condition condition = lock.newCondition();
	public static List<Integer> list = new ArrayList<Integer>();// 需求：最多放20个元素
	
	public static void main(String[] args) {
		for(int i = 0; i < 5; i++) {
			Provider provider = new Provider();
			provider.setName("provider_" + "");
			provider.start();
			
			Consumer consumer = new Consumer();
			consumer.setName("consumer_" + "");
			consumer.start();
		}
	}
}
