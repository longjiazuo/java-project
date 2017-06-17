package org.light4j.innerClass.anonymousInnerClass;

interface A {
	void test();
}

public class ATest {
	public static void main(String[] args) {
		int age = 0;
		A a = new A() {

			@Override
			public void test() {
				// 下面语句将提示错误,匿名内部类内访问局部变量必须使用final修饰
				// System.out.println(age);
			}
		};
	}
}
