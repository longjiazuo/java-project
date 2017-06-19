package org.light4j.tool.date;

import java.util.Calendar;

/**
 * <p>
 * set方法延迟修改:
 * <p>
 * <p>
 * set(f,value)方法将日历字段f更改为value,此外,它还设置了一个内部成员变量,以指示日历字段f已经被更改。
 * 尽管日历字段f立即更改的,但该Calendar所代表的时间却不会立即修改
 * ,直到下次调用get(),getTime(),getTimeInMillis(),add()或roll()时才会重新计算日历的时间
 * 。这称为set方法的延迟修改。采用延迟修改的的优势是多次调用set()不会触发多次不必要的计算(需要计算出一个代表实际时间的long整形数)。
 * <p>
 * <p>
 * 下面程序中创建了代表2008-8-31的Calendar对象,当把这个对象的MONTH字段加1后应该得到2003-10-1(因为9月没有31日),
 * 如果程序在①处代码处输出当前Calendar里的日期,也会看到输出2003-10-1,③处代码将输出2003-10-5
 * <p>
 * <p>
 * 如果将程序①处代码注释起来,因为Calendar的set()方法具有延迟修改的特性,即调用set()方法后Calendar实际上并未计算真实的日期,
 * 它只是使用内部成员变量记录MONTH字段被修改为8
 * ,接着设置DATE字段值为5,程序内部再次记录DATE字段为5,也就是9月5日,因此看到③处输出2003-9-5
 * <p>
 * 
 * @author longjiazuo
 * @date 2017年4月3日 下午10:04:14
 */
public class LazyTest {
	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance();
		cal.set(2013, 7, 31);
		// 将月份设为9,但是9月31日不存在,如果立即修改,系统将会把cal自动调整到10月1日
		cal.set(Calendar.MONTH, 8);
		// 下面将输入10月1日
		System.out.println(cal.getTime());// ①
		// 设置DATE字段为5
		cal.set(Calendar.DATE, 5);// ②
		System.out.println(cal.getTime());// ③
	}
}