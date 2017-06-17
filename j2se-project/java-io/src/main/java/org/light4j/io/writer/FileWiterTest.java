package org.light4j.io.writer;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * FileWriter类的使用
 * <p>
 * 使用FileReader读取自身文件的内容，然后使用FileWriter写入到一个新的文件里面
 * </p>
 * 
 * @author longjiazuo
 * 
 */
public class FileWiterTest {
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
				//新建文件字符输入流
				FileReader fr = new FileReader(currentClass);
				//新建文件字节输出流,文件内容写入到newWriterFile.java
				FileWriter fw = new FileWriter("newWriterFile.java");
		)
		{
			int hasRead=0;
			char[] cbuff = new char[1024];
			while((hasRead = fr.read(cbuff))>0){
				//读取多少就写入多少
				fw.write(cbuff, 0, hasRead);
			}
			System.out.println("操作结束....");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}