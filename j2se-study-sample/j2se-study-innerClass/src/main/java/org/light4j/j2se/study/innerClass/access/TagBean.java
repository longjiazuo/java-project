package org.light4j.j2se.study.innerClass.access;

public class TagBean {

	private String name = "liutao";

	private class InTest {
		public InTest() {
			System.out.println(name);
		}
	}

	public void test() {
		new InTest();
	}

	public static void main(String args[]) {
		TagBean bb = new TagBean();
		bb.test();
	}
}
