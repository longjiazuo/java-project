package org.light4j.genericity.method;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ErrorTest {
	// 声明一个泛型方法，该泛型方法中带一个T类型形参
	static <T> void test(Collection<T> from, Collection<T> to) {
		for (T ele : from) {
			to.add(ele);
		}
	}

	public static void main(String[] args) {
		List<Object> as = new ArrayList<>();
		List<String> ao = new ArrayList<>();
		// 下面代码将产生编译错误
		// test(as, ao);
	}
}