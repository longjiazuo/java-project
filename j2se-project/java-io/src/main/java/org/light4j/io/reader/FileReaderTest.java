package org.light4j.io.reader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * FileReader类测试
 * <p>
 * 使用Reader流来读取自身内容
 * </p>
 * 
 * @author longjiazuo
 * 
 */
public class FileReaderTest {
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
			// 新建文件字符输入流
			FileReader fr = new FileReader(currentClass)
		)
		{
			char[] cbuff = new char[1024];
			int hasRead = 0;
			while ((hasRead = fr.read(cbuff)) > 0) {
				System.out.println(new String(cbuff, 0, hasRead));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}