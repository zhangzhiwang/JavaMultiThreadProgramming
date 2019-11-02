package com.asiainfo.chapter3;

/**
 * 对System.out.println()方法的理解，见课本p271笔记
 *
 * @author zhangzhiwang
 * @date Nov 2, 2019 9:05:56 PM
 */
public class TestSystemOut {
	public static void main(String[] args) {
		// System.out是单例的
		System.out.println(System.out);
		System.out.println(System.out);
		System.out.println(System.out);
	}
}
