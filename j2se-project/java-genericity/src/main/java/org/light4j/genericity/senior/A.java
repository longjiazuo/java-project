package org.light4j.genericity.senior;


//使用Apple类时为T形参传入String类型
public class A extends Apple<String> {
	public A(String str) {
		super(str);
	}

	public static void main(String[] args) {
		A a = new A("11");
		System.out.println(a.getInfo());
	}
}
