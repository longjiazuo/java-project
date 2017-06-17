package org.light4j.nio.channel;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * RandomAccessFile集合FileChannel的使用测试
 * 
 * @author longjiazuo
 * 
 */
public class RandomAccessFileChannelTest {
	public static void main(String[] args) {
		try
		(
			//创建RandomAccessFile对象
			RandomAccessFile raf = new RandomAccessFile("testFile\\randomAccess.txt", "rw");
			//获取FileChannel对象
			FileChannel  randomFileChannel=raf.getChannel();
		)
		{
			//将FileChannel中的所有数据全部映射成ByteBuffer
			ByteBuffer buffer=randomFileChannel.map(FileChannel.MapMode.READ_ONLY, 0, raf.length());
			//将Channel的记录指针移动到最后
			randomFileChannel.position(raf.length());
			//将buffer的所有数据输出，在末尾追加内容
			randomFileChannel.write(buffer);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
}