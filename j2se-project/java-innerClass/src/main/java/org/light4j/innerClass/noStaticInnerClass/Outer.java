package org.light4j.innerClass.noStaticInnerClass;

public class Outer {
	private int outProp = 9;

	class Inner {
		private int inProp = 5;

		public void acessOuterProp() {
			// 非静态内部类可以直接访问外部类的成员
			System.out.println("外部类的outProp值:" + outProp);
		}
	}

	public void acessInnerProp() {
		// 外部类不能直接访问非静态内部类的实例Field
		// 下面代码出现编译错误
		// System.out.println("内部类的innerProp值:" + inProp);
		// 如需访问内部类的实例Field,则必须显示创建内部类对象
		System.out.println("内部类的innerProp值:" + new Inner().inProp);
	}

	public static void main(String[] args) {
		// 执行下面代码,只创建了外部类对象,还未创建内部类对象
		Outer out = new Outer();
		out.acessInnerProp();
	}
}
