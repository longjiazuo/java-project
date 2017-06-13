package org.light4j.exception.Throws;

import java.io.FileInputStream;
import java.io.IOException;

public class OverrideThrows {
	public void test() throws IOException {
		FileInputStream fis = new FileInputStream("a.txt");
	}
}

class Sub extends OverrideThrows {
	// 子类方法声明抛出了比父类方法更大的异常
	// 所以下面方法出错
	//public void test() throws Exception {
	//}
}