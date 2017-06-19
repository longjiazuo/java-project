package org.light4j.tool.interactive;

import java.io.File;
import java.util.Scanner;

/**
 * Scanner是Java5新增的工具类
 * 
 * @author longjiazuo
 * @date 2017年4月2日 下午7:04:45
 */
public class ScannerFileTest {
	public static void main(String[] args) throws Exception {
		// 将一个File对象作为Scanner的构造器参数,Scanner读取文件内容
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(new File("E:\\ScannerFileTest.java"));
		System.out.println("ScannerFileTest.java文件内容如下：");
		// 判断是否还有下一行
		while (sc.hasNextLine()) {
			// 输出文件中的下一行
			System.out.println(sc.nextLine());
		}
	}
}