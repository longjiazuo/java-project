package org.light4j.concurrency.chapter7;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/**
 * AtomicIntegerFieldUpdater测试
 * 
 * @author longjiazuo
 * 
 */
public class AtomicIntegerFieldUpdaterTest {

	private static AtomicIntegerFieldUpdater<User> a = AtomicIntegerFieldUpdater
			.newUpdater(User.class, "old");

	public static void main(String[] args) {
		// 设置conan的年龄是10岁
		User user = new User("conan", 10);
		// 增加一岁，输出增加前的年龄
		System.out.println(a.getAndIncrement(user));
		// 输出现在的年龄
		System.out.println(a.get(user));
	}

	public static class User {
		public User(String name, int old) {
			this.name = name;
			this.old = old;
		}

		private String name;
		// 必须是volatile类型
		public volatile int old;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public int getOld() {
			return old;
		}

		public void setOld(int old) {
			this.old = old;
		}
	}
}