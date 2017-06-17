package org.light4j.nio.channel;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.CharBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;

/**
 * FileChannel测试
 * 
 * @author longjiazuo
 * 
 */
public class FileChannelTest {
	public static void main(String[] args) {
		try (
		// 创建文件输入流
		FileInputStream fis = new FileInputStream("testFile\\inFileChannel.txt");
				// 获取输入流的FileChannel对象
				FileChannel inFileChannel = fis.getChannel();

				// 创建文件输出流
				FileOutputStream fos = new FileOutputStream(
						"testFile\\outFileChannel.txt");
				// 获取输出流的FileChannel对象
				FileChannel outFileChannel = fos.getChannel();) {
			// 将FileChannel里面的全部数据映射成ByteBuffer
			MappedByteBuffer buffer = inFileChannel.map(
					FileChannel.MapMode.READ_ONLY, 0, inFileChannel.size());
			// 将buffer里面的数据全部输出到outFileChannel
			outFileChannel.write(buffer);
			// 调用clear()方法复原位置
			buffer.clear();

			/**
			 * 由于我的文件的编码是UTF-8，如果设置为GBK解码会报如下错误：
			 * <p>
			 * java.nio.charset. UnmappableCharacterException: Input length = 2
			 * </p>
			 */
			// 使用UTF-8字符集创建解码器
			Charset charset = Charset.forName("UTF-8");
			// 创建解码器对象
			CharsetDecoder charsetDecoder = charset.newDecoder();
			// 解码，将ByteBuffer转成CharBuffer
			CharBuffer charBuffer = charsetDecoder.decode(buffer);
			System.out.println(charBuffer);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
}