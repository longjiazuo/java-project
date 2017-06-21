package org.light4j.tool.format;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 使用SimpleDateFormat格式化日期
 * <p>
 * 前面介绍的DateFormate的parse()方法可以把字符串解析成Date()对象,但实际上DateFormate的format()方法不够灵活,
 * 它要求被解析的字符串必须满足特定的格式!为了更好的格式化日期,解析日期字符串,Java提供了SimpleDateFormat类。
 * <p>
 * <p>
 * SimpleDateFormat是DateFormat的子类,正如它的名字所暗示的,它是"简单"的日期格式器。
 * SimpleDateFormat比DateFormat更简单,功能更强大。
 * <p>
 * <p>
 * SimpleDateFormat可以非常灵活的格式化Date,也可以用于解析各种格式的日期字符串。
 * 创建SimpleDateFormat对象时需要传入一个pattern字符串,这个pattern不是正则表达式,而是一个日期模板字符串。
 * <p>
 * <p>
 * SimpleDateFormat功能非常强大,SimpleDateFormat把日期格式化成怎样的字符串,以及能把怎样的字符串解析成Date,
 * 完全取决于创建该对象时指定的pattern参数,pattern是一个使用日期字段占位符的日期模板。
 * <p>
 * 
 * @author longjiazuo
 * @date 2017年4月4日 上午10:49:12
 */
public class SimpleDateFormatTest {
	public static void main(String[] args) throws ParseException {
		Date dt = new Date();
		// 创建一个SimpleDateFormat对象
		SimpleDateFormat sdf1 = new SimpleDateFormat("Gyyyy年中第D天");
		// 将d格式化日期,输出：公元2017年中第94天
		String dateStr = sdf1.format(dt);
		System.out.println(dateStr);
		// 一个非常特殊的日期字符串
		String str = "07###三月##21";
		SimpleDateFormat sdf2 = new SimpleDateFormat("y###MMM##d");
		// 将日期字符串解析成日期m输出:Wed Mar 21 00:00:00 CST 2007
		System.out.println(sdf2.parse(str));
	}
}