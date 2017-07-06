package org.light4j.concurrency.chapter7;

import java.util.concurrent.atomic.AtomicIntegerArray;

/**
 * AtomicIntegerArray测试
 * 
 * @author longjiazuo
 * 
 */
public class AtomicIntegerArrayTest {
	static int[] arrry = new int[] { 1, 2 };
	static AtomicIntegerArray ai = new AtomicIntegerArray(arrry);
	public static void main(String[] args) {
		ai.getAndAdd(0, 10);
		System.out.println(ai.get(0));
		System.out.println(arrry[0]);
	}
}