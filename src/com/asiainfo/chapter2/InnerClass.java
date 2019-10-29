package com.asiainfo.chapter2;

import java.util.ArrayList;
import java.util.List;

/**
 * 内部类
 *
 * @author zhangzhiwang
 * @date 2019年10月4日 下午2:04:06
 */
public class InnerClass {
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	class InnerClass_1 {
		private int age;

		public int getAge() {
			return age;
		}

		public void setAge(int age) {
			this.age = age;
		}
		
		public void print() {
			System.out.println("name = " + name + ",age = " + age);
		}
	}
	
	public static void main(String[] args) {
		InnerClass innerClass = new InnerClass();
		innerClass.setName("innerClass");
		
		InnerClass_1 innerClass_1 = innerClass.new InnerClass_1();
		innerClass_1.setAge(12);
		
		innerClass_1.print();
	}
}