package org.light4j.genericity.wildcard;

// 定义Shape的子类Circle
public class Circle extends Shape {
	// 实现画图方法，以打印字符串来模拟画图方法实现
	public void draw(Canvas c) {
		System.out.println("在画布" + c + "上画一个圆");
	}
}