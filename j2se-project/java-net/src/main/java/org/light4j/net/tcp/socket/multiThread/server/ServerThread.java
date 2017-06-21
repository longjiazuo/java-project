package org.light4j.net.tcp.socket.multiThread.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

/**
 * 负责处理每个线程通信的线程类
 * 
 * @author longjiazuo
 * @date 2017年4月9日 下午6:39:00
 */
public class ServerThread implements Runnable {
	// 定义当前线程所处理
	Socket s = null;
	// 该线程所处理的Socket对应的输入流
	BufferedReader br = null;

	public ServerThread(Socket s) throws IOException {
		this.s = s;
		// 初始化该Socket对应的输入流
		br = new BufferedReader(new InputStreamReader(s.getInputStream()));
	}

	@Override
	public void run() {
		try {
			String content = null;
			while ((content = readFromClient()) != null) {
				// 遍历socketList中的每个Socket,将读到的内容向每个Socket发送一次
				for (Socket s : MyServer.socketList) {
					PrintStream ps = new PrintStream(s.getOutputStream());
					ps.println(content);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private String readFromClient() {
		try {
			return br.readLine();
		}
		// 如果捕获到异常,则表明该Socket对应的客户端已经关闭
		catch (IOException e) {
			// 删除该Socket
			MyServer.socketList.remove(s);
		}
		return null;
	}
}