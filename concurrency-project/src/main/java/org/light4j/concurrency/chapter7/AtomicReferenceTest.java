package org.light4j.concurrency.chapter7;

import java.util.concurrent.atomic.AtomicReference;

/**
 * 3. 原子更新引用类型
 * <p>
 * AtomicReference测试
 * 
 * @author longjiazuo
 * 
 */
public class AtomicReferenceTest {
	public static AtomicReference<User> atomicUserRef = new AtomicReference<User>();

	public static void main(String[] args) {
		User user = new User("conan", 15);
		atomicUserRef.set(user);
		User updateUser = new User("Shinichi", 17);
		atomicUserRef.compareAndSet(user, updateUser);
		System.out.println(atomicUserRef.get().getName());
		System.out.println(atomicUserRef.get().getOld());
	}

	static class User {
		public User(String name, int old) {
			this.name = name;
			this.old = old;
		}

		private String name;
		private int old;

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