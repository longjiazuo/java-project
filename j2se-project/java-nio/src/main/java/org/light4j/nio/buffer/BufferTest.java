package org.light4j.nio.buffer;

import java.nio.CharBuffer;

/**
 * Buffer使用测试
 * 
 * @author longjiazuo
 * 
 */
public class BufferTest {
	public static void main(String[] args) {
		// 初始化容量为8的CharBuffer对象
		CharBuffer charBuffer = CharBuffer.allocate(8);
		System.out.println("初始化时候的capacity:" + charBuffer.capacity());
		System.out.println("初始化时候的limit:" + charBuffer.limit());
		System.out.println("初始化时候的position:" + charBuffer.position());

		System.out.println("======================");
		// 添加3个元素
		charBuffer.put('a');
		charBuffer.put('b');
		charBuffer.put('c');
		System.out.println("添加3个元素后的capacity:" + charBuffer.capacity());
		System.out.println("添加3个元素后的limit:" + charBuffer.limit());
		System.out.println("添加3个元素后的position:" + charBuffer.position());

		System.out.println("======================");
		// 执行flip()方法
		charBuffer.flip();
		System.out.println("执行flip()方法后的capacity:" + charBuffer.capacity());
		System.out.println("执行flip()方法后的limit:" + charBuffer.limit());
		System.out.println("执行flip()方法后的position:" + charBuffer.position());

		System.out.println("======================");
		// 取出第一个元素
		System.out.println("取出第一个元素的值是:" + charBuffer.get());
		System.out.println("取出第一个元素后的capacity:" + charBuffer.capacity());
		System.out.println("取出第一个元素后的limit:" + charBuffer.limit());
		System.out.println("取出第一个元素后的position:" + charBuffer.position());
		// 执行clear()方法
		charBuffer.clear();
		System.out.println("执行clear()方法后的第一个元素的值是:" + charBuffer.get(0));
		System.out.println("执行clear()方法后的capacity:" + charBuffer.capacity());
		System.out.println("执行clear()方法后的limit:" + charBuffer.limit());
		System.out.println("执行clear()方法后的position:" + charBuffer.position());
	}
}