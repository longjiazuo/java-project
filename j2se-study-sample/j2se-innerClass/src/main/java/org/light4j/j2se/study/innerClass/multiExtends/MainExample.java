package org.light4j.j2se.study.innerClass.multiExtends;

public class MainExample {
	private class test1 extends Example1 {
		public String name() {
			return super.name();
		}
	}

	private class test2 extends Example2 {
		public String address() {
			return super.address();
		}
	}

	public String name() {
		return new test1().name();
	}

	public String age() {
		return new test2().address();
	}

	public static void main(String args[]) {
		MainExample mi = new MainExample();
		System.out.println("姓名:" + mi.name());
		System.out.println("地址:" + mi.age());
	}
}