package com.asiainfo.chapter7;

public class JoinTest {
	public static void main(String[] args) throws Exception {
		ThreadE t = new ThreadE();
		t.start();
		t.join(3000);
		System.out.println("	main end!");
	}
}
