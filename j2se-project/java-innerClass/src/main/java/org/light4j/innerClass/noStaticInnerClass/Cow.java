package org.light4j.innerClass.noStaticInnerClass;

import lombok.Getter;
import lombok.Setter;

public class Cow {
	private double weight;

	// 定义非外部类的两个重载构造器
	public Cow() {

	}

	public Cow(double weight) {
		this.weight = weight;
	}

	// 定义非静态内部类
	private class CowLeg {
		// 定义静态内部类的两个成员变量
		@Getter
		@Setter
		private double lenght;
		@Getter
		@Setter
		private String color;

		// 定义非静态内部类的两个重载的构造器
		public CowLeg() {

		}

		public CowLeg(double lenght, String color) {
			this.lenght = lenght;
			this.color = color;
		}

		// 非静态内部类的实例方法
		public void info() {
			System.out.println("当前牛腿的颜色是:" + color + ",高:" + lenght);
			// 直接访问外部类的private修饰的Filed
			System.out.println("本牛腿所在奶牛重:" + weight);
		}
	}

	public void test() {
		CowLeg cl = new CowLeg(1.12, "黑白相间");
		cl.info();
	}

	public static void main(String[] args) {
		Cow cow = new Cow(378.9);
		cow.test();
	}
}
