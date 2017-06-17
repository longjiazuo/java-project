package org.light4j.nio.charset;

import java.nio.charset.Charset;
import java.util.SortedMap;

/**
 * 获取JDK支持的所有字符集编码
 * 
 * @author longjiazuo
 * 
 */
public class CharsetTest {
	public static void main(String[] args) {
		SortedMap<String, Charset> charsets = Charset.availableCharsets();
		for (String charset : charsets.keySet()) {
			// 输出字符集别名和对应的Charset对象
			System.out.println(charset + "------->" + charsets.get(charset));
		}
	}
}
