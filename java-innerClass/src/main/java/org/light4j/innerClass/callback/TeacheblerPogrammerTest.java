package org.light4j.innerClass.callback;

public class TeacheblerPogrammerTest {
	public static void main(String[] args) {
		TeacheblerPogrammer tp = new TeacheblerPogrammer("李刚");
		// 直接调用TeachebleProgrammer类从Programmer类继承到的teach方法
		tp.work();
		// 表面上调用的是Closure的work方法
		// 实际上是回调Teacheblerogrammer的teach方法
		tp.getCallbackReference().work();
	}
}
