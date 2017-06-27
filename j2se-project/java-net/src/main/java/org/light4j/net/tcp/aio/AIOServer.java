package org.light4j.net.tcp.aio;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousChannelGroup;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AIOServer {
	// 端口号
	private final int PORT = 30000;
	// UTF-8编码
	final static String UTF_8 = "utf-8";
	static List<AsynchronousSocketChannel> channelList = new ArrayList<>();

	public void startListen() throws IOException {
		// 创建一个线程池
		ExecutorService executor = Executors.newFixedThreadPool(20);
		// 以指定线程池来创建一个AsynchronousChannelGroup
		AsynchronousChannelGroup channelGroup = AsynchronousChannelGroup
				.withThreadPool(executor);
		// 以指定线程池来创建一个AsynchronousServerSocketChannel
		AsynchronousServerSocketChannel serverChannel = AsynchronousServerSocketChannel
				.open(channelGroup).bind(new InetSocketAddress(PORT));
		// 使用CompletionHandler接收来自客户端的连接请求
		serverChannel.accept(null, new AcceptHandler(serverChannel));
	}

	public static void main(String[] args) throws IOException {
		AIOServer server = new AIOServer();
		server.startListen();
	}
}

// 实现自己的监听客户端请求的CompletionHandler类
class AcceptHandler implements
		CompletionHandler<AsynchronousSocketChannel, Object> {

	private AsynchronousServerSocketChannel serverChannel;

	// 定义一个ByteBuffer准备读取数据
	ByteBuffer buff = ByteBuffer.allocate(1024);

	public AcceptHandler(AsynchronousServerSocketChannel serverChannel) {
		this.serverChannel = serverChannel;
	}

	/**
	 * 当实际IO操作完成时触发该方法
	 */
	@Override
	public void completed(AsynchronousSocketChannel sc, Object attachment) {
		// 记录新连接进来的Channel
		AIOServer.channelList.add(sc);
		// 准备接收客户端的下一次连接
		serverChannel.accept(null, this);
		// 读取数据
		sc.read(buff, null, new ReadHandler(serverChannel, buff));
	}

	@Override
	public void failed(Throwable exc, Object attachment) {
		System.out.println("连接失败：" + exc);
	}

}

// 实现自己的读取数据的CompletionHandler类
class ReadHandler implements CompletionHandler<Integer, Object> {
	private AsynchronousServerSocketChannel serverChannel;

	// 定义一个ByteBuffer准备读取数据
	private ByteBuffer buff;

	public ReadHandler(AsynchronousServerSocketChannel serverChannel,
			ByteBuffer buff) {
		this.buff = buff;
	}

	@Override
	public void completed(Integer result, Object attachment) {
		buff.flip();
		// 将buff中的内容转换为字符串
		String content = StandardCharsets.UTF_8.decode(buff).toString();
		// 遍历每个Channel,将收到的信息写入个Channel中
		for (AsynchronousSocketChannel sc : AIOServer.channelList) {
			try {
				sc.write(ByteBuffer.wrap(content.getBytes(AIOServer.UTF_8))).get();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void failed(Throwable exc, Object attachment) {
		System.out.println("读取数据失败：" + exc);
		// 从该Channel中读取数据失败，就将该Channel移除
		AIOServer.channelList.remove(serverChannel);
	}
}