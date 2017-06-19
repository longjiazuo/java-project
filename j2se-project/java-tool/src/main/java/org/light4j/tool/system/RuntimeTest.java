package org.light4j.tool.system;

/**
 * <p>
 * Runtime类代表Java程序的运行时环境,每个Java程序都有一个与之对应的Runtime实例,应用程序通过该对象与其运行时环境相连。
 * 应用程序不能创建自己的Runtime实例,但是可以通过getRuntime()方法获取与之关联的Runtime对象。
 * <p>
 * <p>
 * Runtime类代表Java程序的运行时环境,可以访问JVM的相关信息,如处理器数量,内存信息等。
 * <p>
 * 
 * @author longjiazuo
 * @date 2017年4月2日 下午10:16:33
 */
public class RuntimeTest {
	public static void main(String[] args) {
		// 获取Java程序关联的运行时对象,下面就是Runtime类提供的访问JVM相关信息的方法。
		Runtime rt = Runtime.getRuntime();
		System.out.println("处理器数量:" + rt.availableProcessors());
		System.out.println("空闲内存数:" + rt.freeMemory());
		System.out.println("可用最大内存数:" + rt.maxMemory());
	}
}