package org.light4j.net.tcp.bio.multiThread;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

/**
 * <p>
 * 客户端包含两个线程,一个负责读取用户的键盘输入,并将用户输入的数据写入Socket对应的输出流中;一个负责读取Socket对应输入流中的数据(
 * 从服务器端发送过来的数据),并将这些数据打印输出。其中负责读取用户输入的线程由MyClient负责,也就是由程序的主线程负责。
 * <p>
 * 
 * @author longjiazuo
 * @date 2017年4月9日 下午7:56:24
 */
public class MyClient {
	// 端口
	static final int PORT = 30000;

	public static void main(String[] args) throws Exception {
		Socket s = new Socket("127.0.0.1", PORT);
		// 客户端启动ClientThread线程不断地读取来自服务器的数据
		new Thread(new ClientThread(s)).start();
		// 获取该Socket对应的输出流
		PrintStream ps = new PrintStream(s.getOutputStream());
		String line = null;
		// 不断地读取键盘输入
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while ((line = br.readLine()) != null) {
			// 将用户的键盘输入内容写入Socket对应的输出流
			ps.println(line);
		}
	}
}