package org.light4j.innerClass.noStaticInnerClass;

public class DiscernVeriable {
	private String prop = "外部类的实例变量";

	private class InClass {
		private String prop = "内部类的实例变量";

		public void info() {
			String prop = "局部变量";
			// 通过 外部类.this.varName 访问外部类实例
			System.out.println("外部类的Field值:" + DiscernVeriable.this.prop);
			// 通过 this.varName 访问内部类实例的Field
			System.out.println("内部类的Field值:" + this.prop);
			// 直接访问局部变量
			System.out.println("局部变量的值:" + prop);
		}
	}

	public void test() {
		InClass in = new InClass();
		in.info();
	}

	public static void main(String[] args) {
		new DiscernVeriable().test();
	}
}
