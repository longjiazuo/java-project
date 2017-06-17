package org.light4j.innerClass.useInnerClass;

/**
 * 当创建一个子类时,子类构造器总会调用父类的构造器,
 * 因此在创建非静态内部类的子类时,必须保证让子类构造器可以调用非静态内部类的构造器,
 * 调用非静态内部类的构造器时,必须存在一个外部类对象。
 *
 */
public class SubClass extends Out.In {
	
	// 显示定义SubClass的构造器
	public SubClass(Out out) {
		// 通过传入的Out对象显示调用In的构造器
		out.super("hello");
	}
	
	public void test(){
		System.out.println("Hello World");
	}
	
	public static void main(String[] args) {
		SubClass sc = new SubClass(new Out());
		sc.test();
	}
}
