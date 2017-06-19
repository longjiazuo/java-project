package org.light4j.tool.interactive;

import java.util.Scanner;

public class ScannerLongTest {
	public static void main(String[] args) {
		// System.in代表标准输入,就是键盘输入
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		// 判断是否还有下一个long整数
		while (sc.hasNextLong()) {
			// 输出输入项
			System.out.println("键盘输入的内容是：" + sc.nextLong());
		}
	}
}
