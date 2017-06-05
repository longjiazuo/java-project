package org.light4j.innerClass.noStaticInnerClass;

public class StaticTest {
	// 定义一个非静态内部类,是一个空类
	private class In {
	}

	// 外部类的静态方法
	public static void main(String[] args) {
		// 下面的代码将引起编译错误,因为静态成员(main方法)无法访问非静态成员(In类)
		// new In();
	}
}
