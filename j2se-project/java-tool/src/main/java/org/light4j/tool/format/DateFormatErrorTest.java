package org.light4j.tool.format;

import java.text.DateFormat;
import java.text.ParseException;

/**
 * <p>
 * DateFormate的parse()方法可以把一个字符串解析成Date对象,但是它要求被解析的字符串必须符合日期字符串的要求,
 * 否则可能抛出ParseException异常
 * <p>
 * 
 * @author longjiazuo
 * @date 2017年4月4日 上午10:52:34
 */
public class DateFormatErrorTest {
	public static void main(String[] args) throws ParseException {
		String str1 = "2007-12-12";
		String str2 = "2007年12月10日";
		// 下面输出Wed Dec 12 00:00:00 CST 2007
		System.out.println(DateFormat.getDateInstance().parse(str1));
		// 下面输出Mon Dec 10 00:00:00 CST 2007
		System.out.println(DateFormat.getDateInstance(DateFormat.LONG).parse(
				str2));
		// 下面抛出ParseException异常:因为"2007年12月10日"是一个LONG样式的日期字符串v,必须用LONG样式的DateFormat实例解析,否则将抛出异常。
		System.out.println(DateFormat.getDateInstance().parse(str2));
	}
}
