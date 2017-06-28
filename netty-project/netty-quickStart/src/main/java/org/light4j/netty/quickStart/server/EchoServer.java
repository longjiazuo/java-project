package org.light4j.netty.quickStart.server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

import java.net.InetSocketAddress;

/**
 * 服务器端引导类
 * 
 * @author longjiazuo
 * 
 */
public class EchoServer {
	// 端口
	private final int port;
	
	public EchoServer(int port){
		this.port = port;
	}

	public void start() throws Exception {
		final EchoServerHandler serverHandler = new EchoServerHandler();
		// 创建EventLoopGroup
		EventLoopGroup group = new NioEventLoopGroup();
		try {
		// 创建ServerBootstrap
		ServerBootstrap b = new ServerBootstrap();
		b.group(group)
		//指定所使用的NIO传输Channel
		.channel(NioServerSocketChannel.class)
		//使用指定的端口设置套接字地址
		.localAddress(new InetSocketAddress(port))
		//添加一个EchoServerHandler的子Channel的ChannelPipeline
		.childHandler(new ChannelInitializer<Channel>() {
			@Override
			protected void initChannel(Channel ch) throws Exception {
				//EchoServerHandler被标注为@Sharable，所以我们总是使用同样的实例
				ch.pipeline().addLast(serverHandler);
			}
		});
		//异步地绑定服务器，调用sync()方法阻塞等待直到绑定完成
		ChannelFuture f = b.bind().sync();
		//获取Channel的CloseFuture，并且阻塞当前线程直到它完成
		f.channel().closeFuture().sync();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally{
			//关闭EventLoopGroup，释放所有的资源
			group.shutdownGracefully().sync();
		}
	}
	
	public static void main(String[] args) throws Exception {
		new EchoServer(30000).start();
	}
}