package org.light4j.concurrency.chapter7;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * AtomicInteger测试
 * 
 * @author longjiazuo
 * 
 */
public class AtomicIntegerTest {
	static AtomicInteger ai = new AtomicInteger();

	public static void main(String[] args) {
		System.out.println(ai.getAndIncrement());
		System.out.println(ai.get());
	}
}