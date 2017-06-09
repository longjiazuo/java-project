package org.light4j.nio.charset;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;

/**
 * 编解码转换
 * 
 * @author longjiazuo
 * 
 */
public class CharsetTransform {
	public static void main(String[] args) {
		// 创建charset对象
		Charset charset = Charset.forName("GBK");
		// 创建编码器
		CharsetEncoder encoder = charset.newEncoder();
		// 创建解码器
		CharsetDecoder decoder = charset.newDecoder();
		// 创建CharBuffer
		CharBuffer cbuff = CharBuffer.allocate(8);
		// 放入元素
		cbuff.put('孙');
		cbuff.put('悟');
		cbuff.put('空');
		// 执行flip()方法，表示已经为读取数据准备就绪
		cbuff.flip();
		try {
			// 将CharsetBuffer转成ByteBuffer
			ByteBuffer bbuff = encoder.encode(cbuff);
			// 输出字节序列
			// 由于编码不同导致的分配字节不同，所以GBK编码循环遍历的时候可以使用capacity()作为条件，而UTF-8只能使用limit()
			for (int i = 0; i < bbuff.limit(); i++) {
				System.out.println(bbuff.get(i) + " ");
			}
			// 将字节序列转成字符序列并输出
			System.out.println("字符是：" + decoder.decode(bbuff));
		} catch (CharacterCodingException e) {
			e.printStackTrace();
		}
	}
}