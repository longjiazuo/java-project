package org.light4j.io.randomAccessFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * <p>
 * 给文件任意位置插入内容
 * </p>
 * <p>
 * 实现方式为：
 * </p>
 * <p>
 * 1. 创建一个临时文件保存需要插入位置之后的内容;
 * </p>
 * <p>
 * 2. 把要插入的内容追加到指针后面的位置;
 * </p>
 * <p>
 * 3. 取出临时文件的内容追加到此时的文件后面。
 * </p>
 * 
 * @author longjiazuo
 * 
 */
public class InsertContent {
	public static void main(String[] args) {
		try {
			insert("insert.txt", 10, "高考来了");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void insert(String fileName, int pos, String insertContent) throws IOException {
		// 再临时目录下创建临时文件temp
		File tempFile = File.createTempFile("temp", null);
		// 当程序正常停止的时候会删除该临时文件
		tempFile.deleteOnExit();
		try 
		(
			// 以临时文件创建文件输入流
			FileInputStream fis = new FileInputStream(tempFile);
			// 以临时文件创建文件输出流
			FileOutputStream fos = new FileOutputStream(tempFile);
			//创建RandomAccessFile流对象，并指定文件访问模式为读写rw
			RandomAccessFile raf = new RandomAccessFile("insert.txt", "rw");
		)
		{
			//移动文件指针
			raf.seek(pos);
			
			int hasRead=0;
			byte[] buff = new byte[32];
			//循环把数据写入到临时文件
			while((hasRead=raf.read(buff))>0){
				fos.write(buff,0,hasRead);
			}
			//重新定位文件指针
			raf.seek(pos);
			//追加需要插入的内容
			raf.write(insertContent.getBytes());
			
			//循环追加临时文件中的内容
			while((hasRead=raf.read(buff))>0){
				raf.write(buff, 0, hasRead);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}