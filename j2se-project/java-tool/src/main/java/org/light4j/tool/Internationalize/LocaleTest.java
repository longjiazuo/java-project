package org.light4j.tool.Internationalize;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * <p>
 * 完成国际化:
 * <p>
 * <p>
 * 对于包含非西欧字符的资源文件,Java提供了一个工具类来处理该文件:native2ascii,这个工具可以在%JAVA_HOME%/bin路径下面找到
 * ,使用该工具的语法格式如下:native2ascii 源资源文件 目的资源文件
 * <p>
 * <p>
 * Java程序国际化的关键类是ResourceBundle和Locale,ResourceBundle是根据不同的Locale加载语言资源文件,
 * 再根据指定的key取得已加载语言资源文件中的字符串
 * <p>
 * 
 * @author longjiazuo
 * @date 2017年4月4日 上午8:23:40
 */
public class LocaleTest {
	public static void main(String[] args) {
		// 获得系统默认的国家/语言环境
		Locale myLocale = Locale.getDefault();
		// 根据指定的国家/语言环境加载资源文件
		// ResourceBoundle为加载及访问资源文件提供便捷的操作，下面的语句从相对于类路径的目录中加载一个名为mess的本地化资源文件
		ResourceBundle bundle = ResourceBundle.getBundle(LocaleTest.class
				.getPackage().getName() + "/mess", myLocale);
		// 打印从资源文件中取得的信息
		System.out.println(bundle.getString("hello"));
	}
}