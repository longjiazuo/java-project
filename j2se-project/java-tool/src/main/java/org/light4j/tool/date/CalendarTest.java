package org.light4j.tool.date;

import java.util.Calendar;

/**
 * <p>
 * 因为Date类在设计上面存在一些缺陷,所以Java提供了Calendar类来更好的处理日期和时间,Calendar是一个抽象类,它用于表示日历。
 * <p>
 * <p>
 * 需要指出的是Calendar.MONTH字段代表月份,月份的起始值不是1,而是0,所以要设置8月时,要用7而不是8
 * <p>
 * 
 * @author longjiazuo
 * @date 2017年4月4日 上午7:11:47
 */
public class CalendarTest {
	public static void main(String[] args) {
		Calendar c = Calendar.getInstance();
		// 取出年
		System.out.println(c.get(Calendar.YEAR));
		// 取出月份
		System.out.println(c.get(Calendar.MONTH));
		// 取出日
		System.out.println(c.get(Calendar.DATE));
		// 分别设置年,月,日,小时,分钟,秒
		c.set(2017, 3, 3, 17, 35, 34);// 2017-04-03 17:35:34
		System.out.println(c.getTime());
		// 将Calendar的年往前推1年
		c.add(Calendar.YEAR, -1);
		System.out.println(c.getTime());// 2016-04-03 17:35:34
		// 将Calendar的月往前推8个月(roll的规则与add处理规则相同：当被修改的字段超过它允许的范围时,上一级字段不会增大)
		c.roll(Calendar.MONTH, -8);// 2016-08-03 17:35:34
		System.out.println(c.getTime());
	}
}