package org.light4j.tool.Internationalize;

import java.text.MessageFormat;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * MessageFormat处理包含占位符的字符串
 * 
 * @author longjiazuo
 * @date 2017年4月4日 上午8:45:11
 */
public class MessageFormatTest {
	public static void main(String[] args) {
		// 定义一个Locale变量
		Locale currentLocale = null;
		// 如果运行程序指定了两个参数
		if (args.length == 2) {
			// 使用运行程序的两个参数构造Locale实例
			currentLocale = new Locale(args[0], args[1]);
		} else {
			// 否则直接使用系统默认的Locale
			currentLocale = Locale.getDefault();
		}
		// 根据Locale加载语言资源
		ResourceBundle bundle = ResourceBundle.getBundle(
				MessageFormatTest.class.getPackage().getName() + "/myMess",
				currentLocale);
		// 取得已加载的语言资源文件中msg对应消息
		String msg = bundle.getString("msg");
		// 使用MessageFormat为带占位符的字符串传入参数
		System.out.println(MessageFormat.format(msg, "longjiazuo", new Date()));
	}
}