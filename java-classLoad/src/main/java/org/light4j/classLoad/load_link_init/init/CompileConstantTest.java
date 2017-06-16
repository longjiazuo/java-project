package org.light4j.classLoad.load_link_init.init;

class MyTest {
	static {
		System.out.println("静态初始化块...");
	}
	// 使用一个字符串直接量为static final的类变量赋值
	static final String compileConstant = "人生设计师";
	// 采用系统时间赋值
	// static final String compileConstant = System.currentTimeMillis() + "";
}

public class CompileConstantTest {
	public static void main(String[] args) {
		// 访问、输出MyTest中的compileConstant类变量
		System.out.println(MyTest.compileConstant); // ①
	}
}