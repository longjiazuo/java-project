package org.light4j.classLoad.load_link_init.init;

class Tester {
	static {
		System.out.println("Tester类的静态初始化块...");
	}
}

public class ClassLoaderTest {
	public static void main(String[] args) throws ClassNotFoundException {
		ClassLoader cl = ClassLoader.getSystemClassLoader();
		// 下面语句仅仅是加载Tester类
		cl.loadClass("org.light4j.classLoad.load_link_init.init.Tester");
		System.out.println("系统加载Tester类");
		// 下面语句才会初始化Tester类
		Class.forName("org.light4j.classLoad.load_link_init.init.Tester");
	}
}