package org.light4j.tool.date;

import java.util.Arrays;
import java.util.TimeZone;

/**
 * <p>
 * 在地理上,地球被划分为24个时区,中国北京属于东八区,而程序中对程序的默认实现是以格林威治时间为标准的,这样就产生了8小时的时间差。为了让程序更加通用,
 * 可以使用TimeZone设置程序中时间所属的时区
 * <p>
 * <p>
 * TimeZone是一个抽象类,不能调用其构造器来创建实例,但可以调用它的静态方法:getDefault()或getTimeZone()
 * 得到TimeZone实例。其中getDefault()方法用于获得运行机器上的默认时区,默认时区可以通过修改操作系统的相关配置来进行调整;
 * getTimeZone()则根据时区ID来获取对应的时区。
 * <p>
 * 
 * @author longjiazuo
 * @date 2017年4月4日 上午7:39:25
 */
public class TimeZoneTest {
	public static void main(String[] args) {
		// 取得Java所支持的所有时区ID
		String[] ids = TimeZone.getAvailableIDs();
		System.out.println(Arrays.toString(ids));
		TimeZone my = TimeZone.getDefault();
		// 获取系统默认时区的ID:Asia/Shanghai
		System.out.println(my.getID());
		// 获取系统默认时区的名称：中国标准时间
		System.out.println(my.getDisplayName());
		// 获取指定ID的时区名称：纽芬兰标准时间
		System.out.println(TimeZone.getTimeZone("CNT").getDisplayName());
	}
}
