package org.light4j.genericity.introduction;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Java 7泛型的"菱形"语法
 * 
 * @author longjiazuo
 * 
 */
public class DiamondTest {
	public static void main(String[] args) {
		// Java自动推断出ArrayList的<>里应该是String
		List<String> books = new ArrayList<>();
		books.add("org.light4j");
		books.add("com.light4j");
		books.add("com.longjiazuo");
		// 遍历时集合元素就是String
		for (String book : books) {
			System.out.println(book);
		}
		// Java自动推断出HashMap的<>里应该是String , List<String>
		Map<String, List<String>> schoolsInfo = new HashMap<>();
		// Java自动推断出ArrayList的<>里应该是String
		List<String> schools = new ArrayList<>();
		schools.add("斜月三星洞");
		schools.add("西天取经路");
		schoolsInfo.put("孙悟空", schools);
		// 遍历Map时，Map的key是String类型
		for (String key : schoolsInfo.keySet()) {
			// value是List<String>类型
			List<String> list = schoolsInfo.get(key);
			System.out.println(key + "-->" + list);
		}
	}
}