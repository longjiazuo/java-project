package org.light4j.innerClass.useInnerClass;

class StaticOut {
	// 定义一个静态内部类,不使用访问控制符,即同一个包中的其他类可访问内部类
	static class StaticIn {
		public StaticIn() {
			System.out.println("静态内部类的构造器");
		}
	}
}

public class CreateStaticInnerInstance {
	public static void main(String[] args) {
		StaticOut.StaticIn in = new StaticOut.StaticIn();
		/**
		 * 上面代码可以改成如下两行代码
		 */
		// 使用 OuterClass.InnerClass 的形式定义内部类对象
		// StaticOut.StaticIn in;
		// 通过 new 来调用内部类构造器创建静态内部类实例
		// in = new StaticOut().StaticIn();
	}

}
