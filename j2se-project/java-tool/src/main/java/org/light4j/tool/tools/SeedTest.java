package org.light4j.tool.tools;

import java.util.Random;

/**
 * <p>
 * Random使用一个48位的种子,如果这两个类的两个实例是用同一个种子创建的,对它们以同样的顺序调用方法,则它们会产生相同的数字序列。也就是说,
 * Random产生的数字并不是真正随机的,而是一种伪随机。
 * <p>
 * 
 * @author longjiazuo
 * @date 2017年4月3日 下午2:05:09
 */
public class SeedTest {
	public static void main(String[] args) {
		Random r1 = new Random(50);
		System.out.println("第一个种子为50的Random对象");
		System.out.println(r1.nextBoolean());
		System.out.println(r1.nextInt());
		System.out.println(r1.nextDouble());
		System.out.println(r1.nextGaussian());
		System.out.println("-----------------------------");
		Random r2 = new Random(50);
		System.out.println("第二个种子为50的Random对象");
		System.out.println(r2.nextBoolean());
		System.out.println(r2.nextInt());
		System.out.println(r2.nextDouble());
		System.out.println(r2.nextGaussian());
		System.out.println("-----------------------------");
		Random r3 = new Random();
		System.out.println("种子为100的Random对象");
		System.out.println(r3.nextBoolean());
		System.out.println(r3.nextInt());
		System.out.println(r3.nextDouble());
		System.out.println(r3.nextGaussian());

	}
}
