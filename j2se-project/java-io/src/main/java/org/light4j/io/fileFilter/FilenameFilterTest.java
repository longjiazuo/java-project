package org.light4j.io.fileFilter;

import java.io.File;

/**
 * 文件名过滤器测试
 * 
 * <p>
 * 列出当前工作目录下符合条件的所有子文件名和路径名
 * </p>
 * 
 * @author longjiazuo
 * 
 */
public class FilenameFilterTest {
	public static void main(String[] args) {
		// 获取工作目录
		String workDir = System.getProperty("user.dir");
		File file = new File(workDir);
		// 列举当前工作目录下的所有文件
		String[] files = file.list(new MyFilenameFilter());
		// 循环遍历
		for (String string : files) {
			System.out.println(string);
		}
	}
}
