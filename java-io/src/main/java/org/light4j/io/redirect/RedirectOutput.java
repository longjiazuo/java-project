package org.light4j.io.redirect;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

/**
 * 重定向输出测试类
 * 
 * @author longjiazuo
 * 
 */
public class RedirectOutput {
	public static void main(String[] args) {
		try
		(
			// 创建字节输出流，指定文件为output.txt
			FileOutputStream fos = new FileOutputStream("output.txt");
			//使用PrintStream包装结点流
			PrintStream ps = new PrintStream(fos);
		) 
		{
			//将输出流重定向到PrintStream
			System.setOut(ps);
			
			//输出字符
			System.out.println("忆高考\r\n");
			System.out.println("年年忆今朝，忙忙赶国考；\r\n");
			System.out.println("不成真秀才，只图自逍遥。\r\n");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
}