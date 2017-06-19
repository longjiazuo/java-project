package org.light4j.tool.system;

import java.io.FileOutputStream;
import java.util.Map;
import java.util.Properties;

/**
 * <p>
 * 1. System类代表当前Java程序的运行平台,程序不能创建System类的对象,System类提供了一些类Filed和类方法,
 * 允许直接通过System类来调用这些Field和方法。
 * <p>
 * <p>
 * 2. System类提供了标准输入,标准输出和错误输出的类Field,并提供了一些静态方法用于访问环境变量,系统属性的方法,
 * 还提供了加载文件和动态链接库的方法。
 * <p>
 * 注意项：
 * <p>
 * 加载文件和动态链接库主要对native方法有用,对于一些特殊的功能(比如访问操作系统底层硬件设备等)java程序无法实现,必须借助c语言来完成,
 * 此时需要使用c语言为Java方法提供实现。其实现步骤如下:
 * <p>
 * <p>
 * (1).Java程序中声明native()方法,类似于abstract方法,只有方法签名,没有实现。编译该java程序,生成一个class文件。
 * <p>
 * <p>
 * (2).用javah编译第一步生成的class文件,将产生一个.h文件。
 * <p>
 * (3). 写一个.app文件实现native方法,其中需要包含第二步产生的.h文件(.h文件中又包含了JDK带的jni.h文件)
 * <p>
 * <p>
 * (4). 将第三步的.cpp文件编译成动态链接库文件。
 * <p>
 * <p>
 * (5).
 * 在Java中用System类的loadLibrary..()方法或Runtime()类的loadLibrary()方法加载第4步产生的动态链接库文件
 * ,Java程序中就可以调用这个native()方法了。
 * <p>
 * 
 * 
 * @author longjiazuo
 * @date 2017年4月2日 下午7:52:42
 */
public class SystemTest {
	public static void main(String[] args) throws Exception {
		// 获取系统所有环境变量
		Map<String, String> env = System.getenv();
		for (String name : env.keySet()) {
			System.out.println(name + "  ------>" + env.get(name));
		}
		// 获取指定环境变量的值
		System.out.println(System.getenv("JAVA_HOME"));
		// 获取所有系统属性
		Properties prop = System.getProperties();
		// 将所有系统属性保存到props.txt文件中
		prop.store(new FileOutputStream("e://props.txt"), "System Properties");
		// 输出特定的系统属性
		System.out.println(System.getProperty("os.name"));
		/**
		 * System类还有两个获取系统当前时间的方法:currentTimeMillis()和nanoTime(),它们都返回一个long整数。
		 * 实际上它们返回的都是当前时间与UTC 1970年1月1日午夜的时间差,前者以毫秒作为测量单位,后者以纳秒作为测量单位。必须指出的是,
		 * 这两个方法的返回值的粒度取决于底层操作系统
		 * ,可能所在的操作系统根本不支持以毫秒,纳秒作为计时单位。例如,许多操作系统以几十毫秒为单位测量时间
		 * ,currentTimeMillis()不可能返回精确的毫秒数
		 * ;而nanoTime()方法很少使用,因为大部分操作系统都不支持使用纳秒作为计时单位。
		 */
		System.out.println(System.currentTimeMillis());
		System.out.println(System.nanoTime());
	}
}
