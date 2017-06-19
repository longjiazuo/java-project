package org.light4j.tool.date;

import java.util.Date;

/**
 * Date()生成一个代表当前日期时间的Date对象。该构造器在底层调用System.currentTimeMillis() 获得long整数作为日期参数
 * 
 * @author longjiazuo
 * @date 2017年4月3日 下午5:07:31
 */
public class DateTest {
	public static void main(String[] args) {
		// 获取当前时间
		Date d1 = new Date();
		// 获取当前之间之后100ms的时间
		Date d2 = new Date(System.currentTimeMillis() + 100);
		System.out.println(d2);
		System.out.println(d1.compareTo(d2));
		System.out.println(d1.before(d2));
	}
}
