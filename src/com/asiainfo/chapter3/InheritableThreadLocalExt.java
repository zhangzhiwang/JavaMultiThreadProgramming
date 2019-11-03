package com.asiainfo.chapter3;

public class InheritableThreadLocalExt extends InheritableThreadLocal<String> {
	@Override
	public String childValue(String parentValue) {
		return parentValue + " lalalalalalalala...";
	}
}
