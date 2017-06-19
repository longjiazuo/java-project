package org.light4j.tool.tools;

import java.util.Arrays;
import java.util.Random;

/**
 * <p>
 * Random类专门用于生成一个伪随机数,它有两个构造器:一个构造器使用默认的种子(以当前时间作为种子),
 * 另外一个构造器需要程序员显示传入一个long型整数的种子
 * <p>
 * 
 * @author longjiazuo
 * @date 2017年4月3日 下午12:13:26
 */
public class RandomTest {
	public static void main(String[] args) {
		Random rand = new Random();
		System.out.println(rand.nextBoolean());
		byte[] buffer = new byte[16];
		rand.nextBytes(buffer);
		System.out.println(Arrays.toString(buffer));
		// 生成0.0~1.0之间的伪随机数double数
		System.out.println(rand.nextDouble());
		// 生成0.0~1.0之间的伪随机数float数
		System.out.println(rand.nextFloat());
		// 生成平均值是0.0，标准差是1.0的伪高斯数
		System.out.println(rand.nextGaussian());
		// 生成一个处于int整数取值范围的伪随机整数
		System.out.println(rand.nextInt());
		// 生成0~26之间的伪随机数
		System.out.println(rand.nextInt(26));
		// 生成一个处于long整数取值范围的伪随机数
		System.out.println(rand.nextLong());
	}
}
