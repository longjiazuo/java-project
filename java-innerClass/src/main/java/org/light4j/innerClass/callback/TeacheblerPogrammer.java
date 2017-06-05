package org.light4j.innerClass.callback;

public class TeacheblerPogrammer extends Programmer {
	public TeacheblerPogrammer() {

	}

	public TeacheblerPogrammer(String name) {
		super(name);
	}

	// 教学工作依然由TeacheblerPogrammer类定义
	public void teach() {
		System.out.println(getName() + "教师在讲台上讲解...");
	}

	private class Closure implements Teachable {

		/**
		 * 非静态内部类回调外部类实现work方法,非静态内部类引用的作用仅仅是向客户类提供一个回调外部类的途径
		 */
		@Override
		public void work() {
			teach();
		}
	}

	// 返回一个非静态内部类引用,允许外部类通过该非静态内部类引用来回调外部类的方法
	public Teachable getCallbackReference() {
		return new Closure();
	}
}