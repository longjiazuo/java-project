package org.light4j.j2se.study.innerClass.hidden;

public class TestExample {

	public static void main(String args[]) {
		Example a = new Example();
		Interface a1 = a.getIn();
		a1.test();
	}
}