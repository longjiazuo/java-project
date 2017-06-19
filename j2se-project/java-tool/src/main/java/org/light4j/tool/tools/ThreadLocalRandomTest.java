package org.light4j.tool.tools;

import java.util.concurrent.ThreadLocalRandom;

/**
 * 在多线程环境下使用ThreadRandom的方式与使用Random基本类似
 * 
 * @author longjiazuo
 * @date 2017年4月3日 下午2:14:12
 */
public class ThreadLocalRandomTest {
	public static void main(String[] args) {
		ThreadLocalRandom rand = ThreadLocalRandom.current();
		// 生成一个4~20之间的伪随机整数
		int val1 = rand.nextInt(4, 20);
		System.out.println(val1);
		// 生成一个4~20之间的伪随机浮点数
		double val2 = rand.nextDouble(2.0, 10.0);
		System.out.println(val2);

	}
}
