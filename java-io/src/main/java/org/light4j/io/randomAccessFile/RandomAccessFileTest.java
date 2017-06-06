package org.light4j.io.randomAccessFile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * RandomAccessFile测试
 * 
 * @author longjiazuo
 * 
 */
public class RandomAccessFileTest {
	public static void main(String[] args) {
		// 获取工作目录
		String workDir = System.getProperty("user.dir");
		// 获取类名
		String className = Thread.currentThread().getStackTrace()[1]
				.getClassName();
		// 类的路径
		String classPath = workDir + "\\src\\main\\java\\" + className;
		// 反斜杠替换掉"."
		String currentClass = classPath.replace(".", "\\") + ".java";
		
		try
		(
			//创建RandomAccessFile流对象，并指定访问模式为只读模式r
			RandomAccessFile raf = new RandomAccessFile(currentClass,"r");	
		) 
		{
			//获取RandomAccessFile对象记录的指针位置，初始位置为0
			System.out.println("文件指针的初始位置是:"+raf.getFilePointer());
			//移动记录文件的指针
			raf.seek(300);
			System.out.println("现在的文件指针位置是:"+raf.getFilePointer());
			int hasRead=0;
			byte[] cbuff = new byte[1024];
			//循环读取数据
			while((hasRead=raf.read(cbuff))>0){
				//字节转换成字符并输出到控制台
				System.out.println(new String(cbuff,0,hasRead));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
}