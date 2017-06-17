package org.light4j.io.randomAccessFile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * <p>
 * 先在工程目录下建立文件append.txt，使用RandomAccessFile流给文件追加内容
 * </p>
 * @author longjiazuo
 * 
 */
public class AppendContent {
	public static void main(String[] args) {
		try 
		(
			//创建RandomAccessFile流对象，并指定访问模式为读写模式rw
			RandomAccessFile raf = new RandomAccessFile("testFile\\append.txt", "rw"); //①
		) 
		{
			//记录指针移动到文件末尾
			raf.seek(raf.length()); //②
			raf.write("\r\n忆高考".getBytes());
			raf.write("\r\n年年忆今朝，茫茫赶国考；".getBytes());
			raf.write("\r\n不成真秀才，只图自逍遥。".getBytes());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
}