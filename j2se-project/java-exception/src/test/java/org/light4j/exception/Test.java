package org.light4j.exception;

public class Test {
	public static void main(String[] args) {
		test();
	}

	public static void test() {
		StackTraceElement[] elements = Thread.currentThread().getStackTrace();
		for (StackTraceElement element : elements) {
			System.out.println(element.getClassName());
			System.out.println(element.getFileName());
			System.out.println(element.getLineNumber());
			System.out.println(element.getMethodName());
			System.out.println(element);
			System.out.println("======================");
		}
	}
}