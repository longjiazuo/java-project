package org.light4j.tool.system;

/**
 * <p>
 * System类提供的identityHashCode方法返回指定对象的精确hashCode值,也就是根据该对象的地址计算得到的hashCode值。
 * <p>
 * <p>
 * 当某个类的hashCode()方法被重写后,该类实例的hashCode()方法就不能唯一地标识该对象;但通过identityHashCode()
 * 方法返回的hashCode值 ,依然是根据该对象的地址计算得到的hashCode值。
 * <p>
 * <p>
 * 所以,如果两个对象的identityHashCode值相同,则两个对象绝对是同一个对象。
 * <p>
 * 
 * @author longjiazuo
 * @date 2017年4月2日 下午9:50:04
 */
public class IdentityHashTest {
	public static void main(String[] args) {
		// 下面程序中s1和s2是两个不同对象
		String s1 = new String("Hello");
		String s2 = new String("Hello");
		// String重写了hashCode()方法：改为根据字符序列计算hashCode值,因为s1和s2的字符序列相同,所以它们的hashCode方法返回值相同
		System.out.println(s1.hashCode() + "-------" + s2.hashCode());
		// s1和s2是不同的字符串对象,所以它们的identityHashCode值不同
		System.out.println(System.identityHashCode(s1) + "-------"
				+ System.identityHashCode(s2));
		String s3 = "Java";
		String s4 = "Java";
		// s3和s4是相同的字符串对象,所以它们的identityHashCode
		System.out.println(System.identityHashCode(s3) + "-------"
				+ System.identityHashCode(s4));
	}
}
