package org.light4j.nio.channel;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;

/**
 * 测试按照字节读取内容，而不是使用map()一次映射的方式
 * 
 * @author longjiazuo
 * 
 */
public class ReadTest {
	public static void main(String[] args) {
		try
		(
				//创建文件输入流
				FileInputStream fis = new FileInputStream("testFile\\read.txt");
				//获取FileChannel对象
				FileChannel fileChannel=fis.getChannel();
		)
		{
			//创建一个128个字节的ByteBuffer
			ByteBuffer buffer = ByteBuffer.allocate(128);
			
			/**
			 * <p>
			 * 文本内容如果是汉字，UTF-8编码下一个汉字占三个字节，而buffer大小如果不能一次性读取全部内容，
			 * 而是读取部分数据到buffer里面，有可能会报错，
			 * 原因是读取半个汉字会造成乱码，解码会出现异常。
			 * </p>
			 */
			//将FileChannel中的数据放入buffer中
			while(fileChannel.read(buffer)!=-1){
				//执行flip()方法开始读取数据
				buffer.flip();
				//创建Charset对象
				Charset charset = Charset.forName("UTF-8");
				//创建解码器对象
				CharsetDecoder decoder= charset.newDecoder();
				//解码，把ByteBuffer转成CharBuffer
				CharBuffer charBuffer = decoder.decode(buffer);
				System.out.println(charBuffer);
				//执行clear()方法，为下次读取数据做准备
				buffer.clear();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
}