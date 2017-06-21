package org.light4j.net.basic;

import java.net.InetAddress;

/**
 * <p>
 * InetAddress代表一个IP地址对象,是网络通信的基础
 * <p>
 * <p>
 * Java提供了InetAddress类来代表IP地址,InetAddress下面还有两个子类：Inet4Address,Inet6Address,
 * 它们分别代表Internet Protocol version4(IPv4)地址和Internet Protocol version6(IPv6)地址。
 * <p>
 * 
 * @author longjiazuo
 * @date 2017年4月8日 下午9:26:46
 */
public class InetAddressTest {
	public static void main(String[] args) throws Exception {
		// 根据主机名来获取对应的InetAddress实例
		InetAddress ip = InetAddress.getByName("blog.longjiazuo.com");
		// 判断是否可达
		System.out.println("blog.longjiazuo.com是否可达:" + ip.isReachable(2000));
		// 获取该InetAddress实例的IP字符串
		System.out.println(ip.getHostAddress());
		// 根据原始IP地址来获取对应的InetAddress实例
		InetAddress local = InetAddress
				.getByAddress(new byte[] { 127, 0, 0, 1 });
		System.out.println("本机是否可达：" + local.isReachable(5000));
		// 获取该InetAddress实例对应的全限定域名
		System.out.println(local.getCanonicalHostName());
	}
}