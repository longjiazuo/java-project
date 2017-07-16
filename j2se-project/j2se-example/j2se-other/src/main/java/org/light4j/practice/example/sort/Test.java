package org.light4j.practice.example.sort;

import java.io.FileNotFoundException;
import java.io.PrintStream;

public class Test {
	public static void say() {
		System.out.println("Hello World");
	}

	abstract class Parent {
		private int a;
		private int b;

		public Parent() {
			this.a = 1;
			this.b = 2;
			System.out.println("parent初始化");
		}
	}

	public interface A {
		public void say();
	}

	static class B implements A {
		@SuppressWarnings("resource")
		public static void main(String[] args) throws FileNotFoundException {
			B b = new B();
			b.say();
			new PrintStream(""){
				@Override
				public void print(boolean b) {
					super.print(b);
				}
			};
			System.out.println("Hello Java");
			System.out.println("Hello World");
		}

		@Override
		public void say() {

		}
	}
}
