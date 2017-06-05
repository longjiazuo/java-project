package org.light4j.io.string;

import java.io.IOException;
import java.io.StringReader;

/**
 * StringReader流的使用
 * <p>
 * 使用StringReader读取字符串的内容
 * </p>
 * 
 * @author longjiazuo
 * 
 */
public class StringReaderTest {
	public static void main(String[] args) {
		String str = "忆高考\r\n年年忆今朝，忙忙赶国考；\r\n不成真秀才，只图自逍遥。\r\n";

		try 
		(	// 创建StringReader
			StringReader sr = new StringReader(str);
	    ) 
	    {
			int hasRead = 0;
			char[] buff = new char[256];
			//读取字符串str的内容
			while ((hasRead = sr.read(buff)) > 0) {
				System.out.println(new String(buff,0,hasRead));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}