package org.light4j.io.string;

import java.io.StringWriter;

/**
 * StringWriter流的使用
 * 
 * <p>
 * StringWriter的内部是以StringBuffer作为输出结点，同时可以指定长度
 * </p>
 * 
 * @author longjiazuo
 * 
 */
public class StringWriterTest {
	public static void main(String[] args) {
		StringWriter sw = new StringWriter();
		// StringWriter sw = new StringWriter(40);
		sw.write("忆高考\r\n");
		sw.write("年年忆今朝，忙忙赶国考；\r\n");
		sw.write("不成真秀才，只图自逍遥。\r\n");
		System.out.println(sw.toString());
	}
}
