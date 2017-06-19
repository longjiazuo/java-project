package org.light4j.tool.tools;

/**
 * <p>
 * float和double两个基本类型的浮点数容易引起精度丢失,尤其在进行算术运算时更容易发生这种情况
 * <p>
 * 
 * @author longjiazuo
 * @date 2017年4月3日 下午2:20:50
 */
public class DoubleTest {
	public static void main(String[] args) {
		System.out.println("0.05 + 0.01=" + (0.05 + 0.01));
		System.out.println("1.0 - 0.42=" + (1.0 - 0.42));
		System.out.println("4.015 * 100=" + (4.015 * 100));
		System.out.println("123.3 / 100=" + (123.3 / 100));
	}
}
