package org.light4j.net.basic;

import java.io.*;
import java.net.*;
import java.util.*;

/**
 *  <p>
 * 通常创建一个和URL的连接m并发送请求,读取此URL引用的资源需要如下几个步骤。
 * (1). 通过调用URL对象的openConnection()方法来创建URLConnection对象。
 * (2). 设置URLConnection的参数和普通请求属性。
 * (3). 如果只是发送GET方式请求,则使用connect()方法建立和远程资源之间的实际连接即可;如果需要发送POST方式的请求,
 *      则需要获取URLConnection实例对应的输出流来发送请求参数。
 * (4). 远程资源变为可用,程序可以访问远程资源的头字段或通过输入流读取远程资源的数据。
 * <p>
 * 
 * <p>
 * 如果既要使用输入流读取URLConnection响应的内容,又要使用输出流发送请求参数,则一定要先使用输出流,再使用输入流。
 * <p>
 * 
 * @author longjiazuo
 * @date 2017年4月9日 下午12:06:48
 */
public class GetPostTest {
	/**
	 * 向指定URL发送GET方法的请求
	 * 
	 * @param url
	 *            发送请求的URL
	 * @param param
	 *            请求参数，格式满足name1=value1&name2=value2的形式。
	 * @return URL所代表远程资源的响应
	 */
	public static String sendGet(String url, String param) {
		String result = "";
		String urlName = url + "?" + param;
		try {
			URL realUrl = new URL(urlName);
			// 打开和URL之间的连接
			URLConnection conn = realUrl.openConnection();
			// 设置通用的请求属性
			conn.setRequestProperty("accept", "*/*");
			conn.setRequestProperty("connection", "Keep-Alive");
			conn.setRequestProperty("user-agent",
					"Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1)");
			// 建立实际的连接
			conn.connect();
			// 获取所有响应头字段
			Map<String, List<String>> map = conn.getHeaderFields();
			// 遍历所有的响应头字段
			for (String key : map.keySet()) {
				System.out.println(key + "--->" + map.get(key));
			}
			try (
			// 定义BufferedReader输入流来读取URL的响应
			BufferedReader in = new BufferedReader(new InputStreamReader(
					conn.getInputStream(), "utf-8"))) {
				String line;
				while ((line = in.readLine()) != null) {
					result += "\n" + line;
				}
			}
		} catch (Exception e) {
			System.out.println("发送GET请求出现异常！" + e);
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * 向指定URL发送POST方法的请求
	 * 
	 * @param url
	 *            发送请求的URL
	 * @param param
	 *            请求参数，格式应该满足name1=value1&name2=value2的形式。
	 * @return URL所代表远程资源的响应
	 */
	public static String sendPost(String url, String param) {
		String result = "";
		try {
			URL realUrl = new URL(url);
			// 打开和URL之间的连接
			URLConnection conn = realUrl.openConnection();
			// 设置通用的请求属性
			conn.setRequestProperty("accept", "*/*");
			conn.setRequestProperty("connection", "Keep-Alive");
			conn.setRequestProperty("user-agent",
					"Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1)");
			// 发送POST请求必须设置如下两行
			conn.setDoOutput(true);
			conn.setDoInput(true);
			try (
			// 获取URLConnection对象对应的输出流
			PrintWriter out = new PrintWriter(conn.getOutputStream())) {
				// 发送请求参数
				out.print(param);
				// flush输出流的缓冲
				out.flush();
			}
			try (
			// 定义BufferedReader输入流来读取URL的响应
			BufferedReader in = new BufferedReader(new InputStreamReader(
					conn.getInputStream(), "utf-8"))) {
				String line;
				while ((line = in.readLine()) != null) {
					result += "\n" + line;
				}
			}
		} catch (Exception e) {
			System.out.println("发送POST请求出现异常！" + e);
			e.printStackTrace();
		}
		return result;
	}

	// 提供主方法，测试发送GET请求和POST请求
	public static void main(String args[]) {
		// 发送GET请求
		String s = GetPostTest.sendGet("http://localhost:8888/abc/a.jsp", null);
		System.out.println(s);
		// 发送POST请求
		String s1 = GetPostTest.sendPost("http://localhost:8888/abc/login.jsp",
				"name=crazyit.org&pass=leegang");
		System.out.println(s1);
	}
}