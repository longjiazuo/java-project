package org.light4j.net.tcp.bio.basic;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

public class Client {
	// 端口
	static final int PORT = 30000;

	public static void main(String[] args) throws Exception {
		Socket socket = new Socket("127.0.0.1", PORT);
		// 将Socket对应的输入流包装成BufferedReader
		BufferedReader br = new BufferedReader(new InputStreamReader(
				socket.getInputStream()));
		// 进行普通的IO操作
		String line = br.readLine();
		System.out.println("来自服务器的数据：" + line);
		// 关闭输入流,关闭Socket
		br.close();
		socket.close();
	}
}
