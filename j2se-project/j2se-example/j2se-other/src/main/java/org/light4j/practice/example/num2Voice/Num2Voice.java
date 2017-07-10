package org.light4j.practice.example.num2Voice;

import java.util.HashMap;
import java.util.Map;

/**
 * 数字转读音
 * 
 * @author longjiazuo
 * 
 */
public class Num2Voice {
	public static final Map<Integer, String> voiceMap = new HashMap<>();

	public static final Map<String, String> numMap = new HashMap<>();
	static {
		voiceMap.put(2, "十");
		voiceMap.put(3, "百");
		voiceMap.put(4, "千");
		voiceMap.put(5, "万");
		voiceMap.put(6, "十");
		voiceMap.put(7, "百");
		voiceMap.put(8, "千");
		voiceMap.put(9, "亿");
		voiceMap.put(10, "十");
		voiceMap.put(11, "百");
		voiceMap.put(12, "千");

		numMap.put("0", "");
		numMap.put("1", "一");
		numMap.put("2", "二");
		numMap.put("3", "三");
		numMap.put("4", "四");
		numMap.put("5", "五");
		numMap.put("6", "六");
		numMap.put("7", "七");
		numMap.put("8", "八");
		numMap.put("9", "九");
		numMap.put("-", "负");
	}

	public static void main(String[] args) {
		System.out.println(Integer.MAX_VALUE);
		System.out.println(num2Voice(Integer.MAX_VALUE));
	}

	public static String num2Voice(int num) {
		String value = "";
		String strs = String.valueOf(num);
		int n = strs.length();
		for (int i = 0; i < strs.length(); i++) {
			if (i == strs.length() - 1 || "-".equals(strs.charAt(i) + "")) {
				value += numMap.get(strs.charAt(i) + "");
			} else {
				value += numMap.get(strs.charAt(i) + "") + voiceMap.get(n);
			}
			n--;
		}
		if (strs.length() == 2 && num > 0) {
			value = value.substring(1);
		}
		return value;
	}
}