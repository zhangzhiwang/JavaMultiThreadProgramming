package com.asiainfo.chapter7;

/**
 * 线程组
 *
 * @author zhangzhiwang
 * @date Nov 6, 2019 2:22:04 PM
 */
public class ThreadGroupTest2 {
	public static void main(String[] args) throws InterruptedException {
		// 获取当前线程的线程组名字
		ThreadGroup fatherGroup = Thread.currentThread().getThreadGroup();
		System.out.println(fatherGroup.getName());

		System.out.println("1-当前线程组下活跃的子线程组数量为：" + Thread.currentThread().getThreadGroup().activeGroupCount());
		// 创建一个新线程组，让它成为当前线程组的自线程组
		ThreadGroup sonGroup = new ThreadGroup("sonGroup");// 打开ThreadGroup的构造方法可以看到：当不输入父线程组时，默认会将新建的线程组加入当前线程所属的线程组
		// 创建一个线程t1，并将该线程加入线程组sonGroup
		Thread t1 = new Thread(sonGroup, new Runnable() {
			@Override
			public void run() {
				System.out.println("线程必须在start后才能被线程组管理");
				try {
					Thread.sleep(10000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		t1.setName("t13");
		t1.start();// 在Thread的构造函数里面会调用init方法，init方法里面会把传入的线程组复制给类成员变量group，然后在start()方法里面将当前线程加入到线程组group里面，所以只有线程start后才会接受线程组的管理。
		
		
		System.out.println("2-当前线程组下活跃的子线程组数量为：" + Thread.currentThread().getThreadGroup().activeGroupCount());
		System.out.println("当前线程组下活跃的子线程组和线程总数量为：" + Thread.currentThread().getThreadGroup().activeCount());
		
		System.out.println("----------------");
		//获取父线程组
		System.out.println("线程t1所属的线程组是：" + t1.getThreadGroup().getName());
		System.out.println("线程t1所属线程组的父线程组是：" + t1.getThreadGroup().getParent().getName());
		System.out.println("线程t1所属线程组的父线程组的父线程组是：" + t1.getThreadGroup().getParent().getParent().getName());// system
		System.out.println("线程t1所属线程组的父线程组的父线程组的父线程组是：" + t1.getThreadGroup().getParent().getParent().getParent().getName());// 报空指针异常，所有线程（组）的根线程组是system，在往上就是null了
	}
}
