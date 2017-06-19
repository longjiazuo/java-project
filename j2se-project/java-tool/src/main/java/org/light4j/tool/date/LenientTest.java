package org.light4j.tool.date;

import java.util.Calendar;

/**
 * <p>
 * 设置Calendar的容错性:当调用Calendar对象的set方法来改变指定时间字段上的值时,有可能传入一个不合法的参数,
 * 下面程序设置Calendar的容错性
 * <p>
 * <p>
 * Calendar有两种解释日历字段的模式:lenient模式和non-lenient模式,当Calendar处于lenient模式时,
 * 每个时间字段可接受超出它允许范围的值;当Calendar处于non-lenient模式时,如果为某个时间字段设置的值超过了它允许的取值范围,程序将会抛出异常。
 * <p>
 * 
 * @author longjiazuo
 * @date 2017年4月3日 下午6:51:43
 */
public class LenientTest {
	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance();
		// 结果是YEAR字段加1,MONTH字段为1(2月)
		cal.set(2003, 7, 31);// 2003-8-31
		System.out.println(cal.getTime());
		// 关闭容错性
		cal.setLenient(false);
		// 导致运行时异常
		cal.set(Calendar.MONTH, 13);
		System.out.println(cal.getTime());
	}
}