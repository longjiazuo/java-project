package org.light4j.genericity.wildcard;

public class Apple<T extends Number> {
	T col;

	public static void main(String[] args) {
		Apple<Integer> ai = new Apple<>();
		Apple<Double> ad = new Apple<>();
		// 下面代码将引起编译异常，下面代码试图把String类型传给T形参
		// 但String不是Number的子类型，所以引发编译错误
		// Apple<String> as = new Apple<>(); // ①
	}
}
