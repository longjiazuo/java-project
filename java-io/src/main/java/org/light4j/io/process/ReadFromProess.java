package org.light4j.io.process;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * <p>
 * 从别的进程读取数据
 * </p>
 * 
 * @author longjiazuo
 * 
 */
public class ReadFromProess {
	public static void main(String[] args) throws IOException {
		// 启动子进程
		Process process = Runtime.getRuntime().exec("javac");
		try (
		// 以process进程的错误流获取输入流
		InputStream is = process.getErrorStream();
				// 流的转换：字节流转字符流
				// 设置编码，不然读取数据出现乱码，Windows平台下简体中文默认使用GBK编码，而Linux平台下是UTF-8编码
				InputStreamReader isr = new InputStreamReader(is, "GBK");
				// 流的包装
				BufferedReader br = new BufferedReader(isr);) {
			String buffer = null;
			// 循环读取数据， 每次读取一行
			while ((buffer = br.readLine()) != null) {
				System.out.println(buffer);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
