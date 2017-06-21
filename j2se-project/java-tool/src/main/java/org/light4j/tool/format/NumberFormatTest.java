package org.light4j.tool.format;

import java.text.NumberFormat;
import java.util.Locale;

/**
 * 使用NumberFormat格式化数字
 * <p>
 * MessageFormat是抽象类Format的子类,Format抽象类还有两个子类:NumberFormat和DateFormat,
 * 它们分别用以实现数值m日期的格式化
 * 。NumberFormat和DateFormat可以使用format()方法将数值,日期转换成字符串,也可以使用parse
 * ()方法将字符串转换成数值,日期。
 * <p>
 * 
 * @author longjiazuo
 * @date 2017年4月4日 上午9:07:37
 */
public class NumberFormatTest {
	public static void main(String[] args) {
		// 需要被格式化的数字
		double db = 1234000.567;
		// 创建四个Locale,分别代表中国,日本,德国,美国
		Locale[] locales = { Locale.CHINA, Locale.JAPAN, Locale.GERMAN,
				Locale.US };
		NumberFormat[] nf = new NumberFormat[12];
		// 为上面四个Locale创建12个NumberFormat对象,每个Locale分别有通用数值格式器,百分数格式器,货币格式器
		for (int i = 0; i < locales.length; i++) {
			nf[i * 3] = NumberFormat.getNumberInstance(locales[i]);
			nf[i * 3 + 1] = NumberFormat.getPercentInstance(locales[i]);
			nf[i * 3 + 2] = NumberFormat.getCurrencyInstance(locales[i]);
		}
		for (int i = 0; i < locales.length; i++) {
			switch (i) {
			case 0:
				System.out.println("---------中国的格式----------");
				break;
			case 1:
				System.out.println("---------日本的格式----------");
				break;
			case 2:
				System.out.println("---------德国的格式----------");
				break;
			case 3:
				System.out.println("---------美国的格式----------");
				break;
			}
			System.out.println("通用数值格式：" + nf[i * 3].format(db));
			System.out.println("百分比数值格式：" + nf[i * 3 + 1].format(db));
			System.out.println("货币数值格式：" + nf[i * 3 + 2].format(db));
		}
	}
}
