package org.light4j.concurrency.chapter7;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * AtomicBoolean测试
 * 
 * @author longjiazuo
 * 
 */
public class AtomicBooleanTest {
	static int a;
	static AtomicBoolean ab = new AtomicBoolean(true);

	public static void main(String[] args) {
		System.out.println(ab.get());
	}
}
