package org.light4j.netty.quickStart.client;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.ChannelHandler.Sharable;
import io.netty.util.CharsetUtil;

/**
 * 客户端处理业务逻辑的ChannelHandlder
 * 
 * @author longjiazuo
 * 
 */
// 标记该类的实例可以被多个Channel共享
@Sharable
public class EchoClientHandler extends SimpleChannelInboundHandler<ByteBuf> {

	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		// 当被通知Channel是活跃的时候，发送一条消息
		ctx.writeAndFlush(Unpooled.copiedBuffer("Netty Rocks",
				CharsetUtil.UTF_8));
	}

	@Override
	protected void channelRead0(ChannelHandlerContext ctx, ByteBuf in)
			throws Exception {
		// 记录已接收消息的转储
		System.out.println("Client received：" + in.toString(CharsetUtil.UTF_8));
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause)
			throws Exception {
		// 打印异常信息
		cause.printStackTrace();
		// 关闭Channel
		ctx.close();
	}
}