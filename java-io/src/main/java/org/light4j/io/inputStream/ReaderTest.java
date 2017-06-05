package org.light4j.io.inputStream;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * FileReader类测试
 * 
 * @author longjiazuo
 * 
 */
public class ReaderTest {
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

		// 读取当前类的内容
		try {
			@SuppressWarnings("resource")
			FileReader fr = new FileReader(currentClass);
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