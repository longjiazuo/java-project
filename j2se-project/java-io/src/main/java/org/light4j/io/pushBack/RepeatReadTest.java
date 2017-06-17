package org.light4j.io.pushBack;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PushbackReader;

/**
 * 模拟重复读取数据
 * 
 * @author longjiazuo
 *
 */
public class RepeatReadTest {
	public static void main(String[] args) {
		
		try 
		(
				// 创建字符输入流，读取pushback.txt的数据
				FileReader fr = new FileReader("testFile\\repeatRead.txt");
				// 创建字符推回输入流，
				PushbackReader pr = new PushbackReader(fr,12);
		) 
		{
			// 新建字符数组，大小为5个字节
			char[] cbuff = new char[6];
			int hasRead = 0;

			// 循环读取数据
			while ((hasRead = pr.read(cbuff)) > 0) {
				// 当前读取的内容，把其转换为字符串表示
				String content = new String(cbuff, 0, hasRead);
				//打印输出的字符串
				System.out.println(content);
				
				//把内容推回到推回缓冲区
				pr.unread(content.toCharArray());//①
				
				//继续读取数据，此处实际上是从缓冲区里面读取的
				if((hasRead = pr.read(cbuff)) > 0){
					//输出
					System.out.println(new String(cbuff, 0,hasRead));
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
}