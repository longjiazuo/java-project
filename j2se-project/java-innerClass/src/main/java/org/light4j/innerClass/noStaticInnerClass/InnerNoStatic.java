package org.light4j.innerClass.noStaticInnerClass;

public class InnerNoStatic {
	private class InnerClass {
		/**
		 * 下面三个静态声明都将引发如下编译错误： 非静态内部类不能有静态声明(静态初始化块,静态Field,静态方法)
		 */
		// static {
		// System.out.println("===============");
		// }
		//
		// private static int inProp;
		//
		// private static void test() {
		// }
	}
}
