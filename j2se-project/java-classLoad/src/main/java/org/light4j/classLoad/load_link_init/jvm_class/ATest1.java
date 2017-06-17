package org.light4j.classLoad.load_link_init.jvm_class;

public class ATest1 {
	public static void main(String[] args) {
		// 创建A类的实例
		A a = new A();
		// 让a实例的类变量a的值自加
		a.a++;
		System.out.println(a.a);
	}
}