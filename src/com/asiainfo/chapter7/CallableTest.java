package com.asiainfo.chapter7;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 创建线程的方式三——Callable接口创建线程
 *
 * @author zhangzhiwang
 * @date Nov 11, 2019 2:18:24 PM
 */
public class CallableTest implements Callable<String>{
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		// 实现Callable接口创建线程的步骤：
		// 1、创建Callable接口的实现类，并实现call()方法，然后创建该实现类的实例
		CallableTest callableTest = new CallableTest();
		
		// 2、创建Future接口的实现类FutureTask的对象，将Callable对象传入其中
		FutureTask<String> futureTask = new FutureTask<String>(callableTest);
		
		// 3、创建Thread对象，并将FutureTask作为Thread类的构造方法target参数传入其中，并启动线程
		Thread thread = new Thread(futureTask);
		thread.setName("T1");
		thread.start();
		
		// 4、调用FutureTask对象的get()方法来获得线程执行结束后的返回值
		String result = futureTask.get();
		System.out.println("result = " + result);
	}

	@Override
	public String call() throws Exception {// call方法相对Runnable的run方法有两点不同：一个是call方法有返回值而run方法没有，一个是call方法可以声明抛出异常而run方法不能
		System.out.println(Thread.currentThread().getName() + "运行call方法");
		Thread.sleep(10000);
		return "retValue";
	}
}
