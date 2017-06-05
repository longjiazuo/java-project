package org.light4j.io.inputStream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * FileInputStream测试
 * 
 * @author longjiazuo
 * 
 */
public class FileInputStreamTest {
	public static void main(String[] args) {
		try {
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
			@SuppressWarnings("resource")
			FileInputStream fis = new FileInputStream(currentClass);
			byte[] buff = new byte[1024];
			int hasRead = 0;
			while ((hasRead = fis.read(buff)) > 0) {
				System.out.println(new String(buff, 0, hasRead));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}