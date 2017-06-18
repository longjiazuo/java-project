package org.light4j.genericity.introduction;

import java.util.ArrayList;
import java.util.List;

/**
 * 手动实现编译时检查类型
 * 
 * @author longjiazuo
 * 
 */
public class CheckType {
	public static void main(String[] args) {
		// 创建一个只想保存字符串的List集合
		StrList strList = new StrList();
		strList.add("org.light4j");
		strList.add("com.light4j");
		strList.add("com.longjiazuo");
		// 下面语句不能把Integer对象"丢进"集合中,将引起编译错误
		// strList.add(5);
		System.out.println(strList);
		for (int i = 0; i < strList.size(); i++) {
			// 因为StrList里元素的类型就是String类型，
			// 所以无须强制类型转换
			String str = strList.get(i);
		}
	}
}

// 自定义一个StrList集合类，使用组合的方式来复用ArrayList类
class StrList {
	private List strList = new ArrayList();

	// 定义StrList的add方法
	public boolean add(String ele) {
		return strList.add(ele);
	}

	// 重写get方法，将get方法的返回值类型改为String类型
	public String get(int index) {
		return (String) strList.get(index);
	}

	public int size() {
		return strList.size();
	}
}