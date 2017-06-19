package org.light4j.tool.tools;

/**
 * <p>
 * Math类是一个工具类,它的构造器被定义成private的,因此无法创建Math类的对;Math类中的所有方法都是类方法,可以直接通过类名来调用。
 * Math类除了大量静态方法wait,还提供了两个静态Field：PI和E,它们的值分别等于π和e
 * <p>
 * <p>
 * 下面程序关于Math类的用法几乎覆盖了Math类的所有数学计算功能,具体使用时候可以进行参考。
 * <p>
 * 
 * @author longjiazuo
 * @date 2017年4月3日 下午12:04:01
 */
public class MathTest {
	public static void main(String[] args) {
		/** ----------下面是三角运算------------------ */
		System.out.println("----------下面是三角运算------------------");
		// 将弧度转换为角度
		System.out.println(Math.toDegrees(1.57));
		// 将角度转换为弧度
		System.out.println(Math.toRadians(90));
		// 计算反余弦,返回的角度范围在0.0到pi之间
		System.out.println(Math.acos(1.2));
		// 计算反正弦,返回的角度范围在-pi/2到pi/2之间
		System.out.println(Math.asin(0.8));
		// 计算反正切,返回的角度范围在-pi/2到pi/2之间
		System.out.println(Math.atan(2.3));
		// 计算三角余弦
		System.out.println(Math.cos(1.57));
		// 计算双曲余弦
		System.out.println(Math.cosh(1.2));
		// 计算正弦
		System.out.println(Math.sin(1.57));
		// 计算双曲正弦
		System.out.println(Math.sinh(1.2));
		// 计算三角正切
		System.out.println(Math.tan(0.8));
		// 计算双曲正切
		System.out.println(Math.tanh(2.1));
		// 将矩形坐标(x,y)转换成极坐标(r,thet)
		System.out.println(Math.atan2(0.1, 0.2));

		/** ----------下面是取整运算------------------ */
		System.out.println("----------下面是取整运算------------------");
		// 取整,返回小于目标数的最大整数
		System.out.println(Math.floor(-1.2));
		// 取整,返回大于目标数的最大整数
		System.out.println(Math.ceil(1.2));
		// 四舍五入取整
		System.out.println(Math.round(2.3));

		/** ----------下面是乘方,开方,指数运算------------------ */
		System.out.println("----------下面是乘方,开方,指数运算------------------");
		// 计算平方根
		System.out.println(Math.sqrt(2.3));
		// 计算立方根
		System.out.println(Math.cbrt(9));
		// 返回欧拉数e的n次幂
		System.out.println(Math.exp(2));
		// 返回sqrt(x2+y2),没有中间溢出或下溢
		System.out.println(Math.hypot(4, 4));
		// 按照IEE 754标准的规定,对两个参数进行余数运算
		System.out.println(Math.IEEEremainder(5, 2));
		// 计算乘方
		System.out.println(Math.pow(3, 2));
		// 计算自然对数
		System.out.println(Math.log(12));
		// 计算底数为10的对数
		System.out.println(Math.log10(9));
		// 返回参数与1之和的自然对数
		System.out.println(Math.log1p(9));

		/** ----------下面是符号相关的运算------------------ */
		System.out.println("----------下面是符号相关的运算------------------");
		// 计算绝对值
		System.out.println(Math.abs(-4.5));
		// 符号赋值,返回带有第二个浮点数符号的第一个浮点参数
		System.out.println(Math.copySign(1.2, -1.0));
		// 符号函数,如果参数为0,返回0;如果参数大于0,则返回1.0;如果参数小于0,则返回-1.0
		System.out.println(Math.signum(2.3));

		/** ----------下面是大小相关的运算------------------ */
		System.out.println("----------下面是大小相关的运算------------------");
		// 找下最大值
		System.out.println(Math.max(2.3, 4.5));
		// 计算最小值
		System.out.println(Math.min(1.2, 3.4));
		// 返回第一个参数和第二个参数之间与第一个参数相邻的浮点数
		System.out.println(Math.nextAfter(1.2, 1.0));
		// 返回比目标数略大的浮点数
		System.out.println(Math.nextUp(1.2));
		// 返回一个伪随机数,该值大于等于0.0且小于1.0
		System.out.println(Math.random());
	}
}