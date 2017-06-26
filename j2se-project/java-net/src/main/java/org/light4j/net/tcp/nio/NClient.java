package org.light4j.net.tcp.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Scanner;
import java.util.Set;

public class NClient {
	// 定义检测SocketChannel的Selector对象
	private Selector selector = null;
	// 端口
	static final int PORT = 30000;
	// 定义处理编码和解码的字符集
	private Charset charset = Charset.forName("UTF-8");
	// 客户端SocketChannel
	private SocketChannel sc = null;

	public void init() throws IOException {
		selector = Selector.open();
		InetSocketAddress isa = new InetSocketAddress("127.0.0.1", PORT);
		// 调用open()静态方法创建连接到指定主机的SocketChannel
		sc = SocketChannel.open(isa);
		// 设置该SocketChannel以非阻塞方式工作
		sc.configureBlocking(false);
		// 将SocketChannel注册到指定的Selector
		sc.register(selector, SelectionKey.OP_READ);
		// 启动读取服务器端数据的线程
		new ClientThread().start();
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		while (scan.hasNextLine()) {
			// 读取键盘输入
			String line = scan.nextLine();
			// 将键盘输入的内容输出到ScoketChannel中
			sc.write(charset.encode(line));
		}
	}

	private class ClientThread extends Thread {

		@Override
		public void run() {
			try {
				while (selector.select() > 0) {
					Set<SelectionKey> keys = selector.selectedKeys();
					// 遍历每个有可用IO操作的Channel对应的SelectionKey
					for (SelectionKey sk : keys) {
						// 删除正在处理的SelectionKey
						keys.remove(sk);
						// 如果该SelectionKey对应的Channel中有可读的数据
						if (sk.isReadable()) {
							// 使用NIO读取Channel中的数据
							SocketChannel sc = (SocketChannel) sk.channel();
							ByteBuffer buff = ByteBuffer.allocate(1024);
							String content = "";
							while (sc.read(buff) > 0) {
								System.out.println("======");
								buff.flip();
								content += charset.decode(buff);
							}
							// 打印读取到的数据
							System.out.println("聊天信息：" + content);
							// 为下一次读取做准备
							sk.interestOps(SelectionKey.OP_READ);
						}
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) throws IOException {
		new NClient().init();
	}
}