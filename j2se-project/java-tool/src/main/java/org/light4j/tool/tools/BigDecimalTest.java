package org.light4j.tool.tools;

import java.math.BigDecimal;

/**
 * <p>
 * 为了能够精确表示,计算浮点数,java提供了BigDecimal类,该类提供了大量的构造器用于创建BigDecimal对象,
 * 包括把所有的基本数值类型变量转换成一个BigDecimal对象,也包括利用数字字符串,数字字符数组来创建BigDecimal对象
 * <p>
 * <p>
 * 从下面的程序的运行结果可以看出,创建BigDecimal对象时,不要直接使用double浮点数作为参数来调用BigDecimal构造器,
 * 否则同样会发生精度丢失的问题。所以创建BugDecimal对象时,一定要使用String对象作为构造器参数,而不是直接使用double数字。
 * <p>
 * 
 * @author longjiazuo
 * @date 2017年4月3日 下午2:25:07
 */
public class BigDecimalTest {
	public static void main(String[] args) {
		BigDecimal f1 = new BigDecimal("0.05");
		/**
		 * <p>
		 * 如果必须使用double浮点数作为BigDecimal构造器的参数,
		 * 不要直接将该double浮点数作为构造器参数创建Bigdecimal对象,
		 *  而是应该通过BigDecimal.valueOf(double value)静态方法来创建BigDecimal对象
		 * <p>
		 */
		BigDecimal f2 = BigDecimal.valueOf(0.01);
		BigDecimal f3 = new BigDecimal(0.05);
		System.out.println("使用String作为BigDecimal构造器参数:");
		System.out.println("0.05 + 0.01=" + f1.add(f2));
		System.out.println("0.05 - 0.01=" + f1.subtract(f2));
		System.out.println("0.05 * 0.01=" + f1.multiply(f2));
		System.out.println("0.05 / 0.01=" + f1.divide(f2));
		System.out.println("使用double作为BigDecimal构造器参数:");
		System.out.println("0.05 + 0.01=" + f3.add(f2));
		System.out.println("0.05 - 0.01=" + f3.subtract(f2));
		System.out.println("0.05 * 0.01=" + f3.multiply(f2));
		System.out.println("0.05 / 0.01=" + f3.divide(f2));
	}
}
