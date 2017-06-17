package org.light4j.innerClass.anonymousInnerClass;

interface Product {
	public double getPrice();

	public String getName();
}

public class AnonymousTest {
	public void test(Product p) {
		System.out.println("购买了一个" + p.getName() + ",花费了" + p.getPrice());
	}

	public static void main(String[] args) {
		AnonymousTest ta = new AnonymousTest();
		// 调用test方法时,需要传入一个Product参数
		// 此次传入其匿名实现类的实例
		ta.test(new Product() {

			@Override
			public double getPrice() {
				return 567.8;
			}

			@Override
			public String getName() {
				return "AGP显卡";
			}
		});
		// 按照非匿名内部类的方式调用
		// ta.test(new AnonymousProduct());
	}
}

// 对于上面创建的Product实现类的代码,可以拆分如下代码
class AnonymousProduct implements Product {

	@Override
	public double getPrice() {
		return 567.8;
	}

	@Override
	public String getName() {
		return "AGP显卡";
	}
}