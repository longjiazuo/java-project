package org.light4j.Enum.Interface;

public enum Gender implements GenderDesc {

	// 此处的枚举值必须调用对应构造器来创建
	MALE("男")
	// 花括号部分实际上是一个类体部分
	{
		public void info() {
			System.out.println("这个枚举值代表男性");
		}
	},
	FEMALE("女") {
		public void info() {
			System.out.println("这个枚举值代表女性");
		}
	};
	private final String name;

	// 枚举类的构造器只能使用private修饰
	private Gender(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	// 增加下面的info方法，实现GenderDesc接口必须实现的方法
	public void info() {
		System.out.println("这是一个用于用于定义性别Field的枚举类");
	}

}
