package org.light4j.io.outputStream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * FileOutputStream流测试类
 * <p>
 * 使用FileInputStream读取自身文件的内容，然后使用FileOutputStream写入到一个新的文件里面
 * </p>
 * 
 * @author longjiazuo
 * 
 */
public class FileOutputStreamTest {
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
				//新建文件字节输入流
				FileInputStream fis =new FileInputStream(currentClass);
				//新建文件字节输出流，内容写入到文件newOutputFile.java
				FileOutputStream fos = new FileOutputStream("newOutputFile.java");
				
		)
		{
			byte[] buff=new byte[2014];
			int hasRead=0;
			while((hasRead=fis.read(buff))>0){
				//每次读多少就写入多少
				fos.write(buff,0,hasRead);
			}
			System.out.println("操作结束....");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
}
