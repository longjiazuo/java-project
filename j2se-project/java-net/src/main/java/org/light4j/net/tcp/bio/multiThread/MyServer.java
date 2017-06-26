package org.light4j.net.tcp.bio.multiThread;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class MyServer {
	// 定义保存所有Socket的ArrayList
	public static ArrayList<Socket> socketList = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		@SuppressWarnings("resource")
		ServerSocket ss = new ServerSocket(30000);
		while (true) {
			// 此行代码会阻塞,将一直等待别人的连接
			Socket s = ss.accept();
			socketList.add(s);
			// 每当客户端连接之后启动一个ServerThread线程为该客户端服务
			new Thread(new ServerThread(s)).start();
		}
	}
}