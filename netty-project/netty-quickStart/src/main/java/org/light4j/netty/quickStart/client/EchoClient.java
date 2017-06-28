package org.light4j.netty.quickStart.client;

import java.net.InetSocketAddress;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * 客户端引导类
 * 
 * @author longjiazuo
 * 
 */
public class EchoClient {
	private final String host;
	private final int port;

	public EchoClient(String host, int port) {
		this.host = host;
		this.port = port;
	}

	public void start() throws Exception {
		// 创建EventLoopGroup
		EventLoopGroup group = new NioEventLoopGroup();
		try {
		//创建Bootstrap
		Bootstrap b =new Bootstrap();
		//指定EventLoopGroup以处理客户端事件需要适用于NIO的实现
		b.group(group);
		//适用于NIO传输的Channel类型
		b.channel(NioSocketChannel.class);
		//设置服务器的InetSocketAddress;
		b.remoteAddress(new InetSocketAddress(host, port));
		b.handler(new ChannelInitializer<SocketChannel>() {

			@Override
			protected void initChannel(SocketChannel ch) throws Exception {
				//在创建Channel时，向ChannelPipeline中添加一个EchoClientHandler实例
				ch.pipeline().addLast(new EchoClientHandler());
			}
		});
		//连接到远程节点，阻塞等到直到连接完成
		ChannelFuture f = b.connect().sync();
		//阻塞，直到Channel关闭
		f.channel().closeFuture().sync();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally{
			//关闭线程池并且释放所有的资源
			group.shutdownGracefully().sync();
		}
	}
	
	public static void main(String[] args) throws Exception {
		new EchoClient("127.0.0.1", 30000).start();
	}
}