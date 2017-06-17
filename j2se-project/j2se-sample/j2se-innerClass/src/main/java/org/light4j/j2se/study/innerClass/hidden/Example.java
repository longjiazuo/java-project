package org.light4j.j2se.study.innerClass.hidden;

public class Example {

	private class InsideClass implements Interface {
		public void test() {
			System.out.println("这是一个测试");
		}
	}

	public Interface getIn() {
		return new InsideClass();
	}
}
