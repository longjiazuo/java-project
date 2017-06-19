package org.light4j.tool.interactive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Scanner可以非常方便的获取键盘输入,它是Java5新增的工具类,在Java5之前, 程序通常通过BufferedReader类来读取键盘输入。
 * 与Scanner不同的是,BufferedReader不能读取基本类型输入项,它总是读取String对象。
 * 
 * @author longjiazuo
 * @date 2017年4月2日 下午7:36:12
 */
public class KeyboardTest {
	public static void main(String[] args) throws IOException {
		// 以System.in字节流为基础,创建一个BufferedReader对象
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = null;
		// 逐行读取键盘输入
		while ((line = br.readLine()) != null) {
			System.out.println("用户键盘输入是：" + line);
		}
	}
}
