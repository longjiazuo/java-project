package org.light4j.j2se.study.innerClass.sameMethod;

public class MyIncrement {

	public void increment() {
		System.out.println("Other increment()");
	}

	static void f(MyIncrement f) {
		f.increment();
	}
}
