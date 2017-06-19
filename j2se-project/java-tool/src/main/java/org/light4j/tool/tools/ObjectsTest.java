package org.light4j.tool.tools;

import java.util.Objects;

/**
 * <p>
 * java7新增了一个Objects工具类,它提供了一些工具方法来操作对象,这些工具方法大多是"空指针"安全的。比如,
 * 你不能明确地判断一个印有变量是否是null,如果贸然地调用该变量的toString()方法,则可能引发NullPointerException异常;
 * 但是如果使用Obects类提供的toString(Object o)方法,就不会引发空指针异常,当o为null时,程序将返回一会"null"字符串。
 * <p>
 * <p>
 * java为工具类的命名习惯是添加一个字母s,比如操作数组的工具类是Arrays,操作集合的工具类是Collections
 * <p>
 * 
 * @author longjiazuo
 * @date 2017年4月2日 下午10:57:22
 */
public class ObjectsTest {
	// 定义一个obj变量,它的默认值是null
	static ObjectsTest obj;

	public static void main(String[] args) {
		// 输出一个bull对象的hashCode值,输出0
		System.out.println(Objects.hashCode(obj));
		// 输出一个null对象的toString,输出null
		System.out.println(Objects.toString(obj));
		// 要求obj不能为null，如果obj为null则引发异常
		System.out.println(Objects.requireNonNull(obj, "obj参数不能是null"));//
	}
}
