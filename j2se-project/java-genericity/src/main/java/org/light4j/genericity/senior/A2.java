package org.light4j.genericity.senior;


public class A2 extends Apple {
	// 重写父类的方法
	public Object getInfo() {
		// super.getInfo()方法返回值是Object类型，所以加toString()才返回String类型
		return super.getInfo().toString();
	}
}