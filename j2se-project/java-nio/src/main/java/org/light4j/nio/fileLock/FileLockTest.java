package org.light4j.nio.fileLock;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

/**
 * FileLcok文件锁测试
 * 
 * @author longjiazuo
 * 
 */
public class FileLockTest {
	public static void main(String[] args) {
		try
		(
			//创建文件输出流
			FileOutputStream fos = new FileOutputStream("testFile\\fileLock.txt");
			//获取FileChannel对象
			FileChannel fileChannel = fos.getChannel();
		) 
		{
			//使用阻塞方式对文件加锁，非阻塞方式加锁是fileChannel.tryLock()
			//lock()或者tryLock()获取的都是排它锁
			FileLock lock = fileChannel.lock();
			System.out.println("成功获取锁....");
			//程序暂停10s
			Thread.sleep(10000);
			//释放锁
			lock.release();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}