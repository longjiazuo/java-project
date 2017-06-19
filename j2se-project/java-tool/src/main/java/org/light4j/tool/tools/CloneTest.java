package org.light4j.tool.tools;

/**
 * <p>
 * Java提供了一个protected修士的clone()方法,该方法用于帮助其他对象来实现"自我克隆",所以"自我克隆"就是得到一个当前对象的副本,
 * 而且二者之间完全隔离。由于Object类提供的clone()方法使用了protected修饰,因此该方法只能被子类重写或者调用
 * <p>
 * <p>
 * 自定义类实现"克隆"的步骤如下:
 * <p>
 * (1). 自定义类实现Cloneable接口。这是一个标记性的接口,实现该接口的对象可以实现"自我克隆",接口里没有定义任何方法
 * <p>
 * <p>
 * (2). 自定义类实现自己的clone()方法。
 * <p>
 * <p>
 * (3). 实现clone()方法时通过super.clone()调用Object实现的clone()方法来得到该对象的副本,并返回该副本。
 * <p>
 * 
 * @author longjiazuo
 * @date 2017年4月2日 下午10:33:39
 */

class Address {
	String detail;

	public Address(String detail) {
		this.detail = detail;
	}
}

// 实现Cloneable接口
class User implements Cloneable {
	int age;
	Address address;

	public User(int age) {
		this.age = age;
		this.address = new Address("广州天河");
	}

	// 通过调用superlone()来实现clone()方法
	@Override
	protected User clone() throws CloneNotSupportedException {
		return (User) super.clone();
	}
}

public class CloneTest {
	public static void main(String[] args) throws CloneNotSupportedException {
		User u1 = new User(29);
		// clone得到u1对象的副本
		User u2 = u1.clone();
		// 判断u1,u2是否相同
		System.out.println(u1 == u2);
		// 判断u1,u2的address是否相同
		System.out.println(u1.address == u2.address);
	}
}
