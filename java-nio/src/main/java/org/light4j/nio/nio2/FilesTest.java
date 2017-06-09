package org.light4j.nio.nio2;

import java.io.FileOutputStream;
import java.nio.charset.Charset;
import java.nio.file.FileStore;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * Files测试类
 * 
 * @author longjiazuo
 * 
 */
public class FilesTest {
	public static void main(String[] args) throws Exception {
		// 获取工作目录
		String workDir = System.getProperty("user.dir");
		// 获取类名
		String className = Thread.currentThread().getStackTrace()[1]
				.getClassName();
		// 类的路径
		String classPath = workDir + "\\src\\main\\java\\" + className;
		// 反斜杠替换掉"."
		String currentClass = classPath.replace(".", "\\") + ".java";

		// 复制文件，把currentClass内容复制到files.txt
		Files.copy(Paths.get(currentClass), new FileOutputStream(
				"testFile\\files.txt"));
		// 判读FilesTest.java是否为隐藏文件
		System.out.println(Files.isHidden(Paths.get(currentClass)));
		// 一次性读取FilesTest.java文件的所有行
		List<String> lines = Files.readAllLines(Paths.get(currentClass),
				Charset.forName("UTF-8"));
		System.out.println(lines);
		// 获取指定文件的大小
		System.out.println("FilesTest.java文件大小："
				+ Files.size(Paths.get(currentClass)));
		List<String> poem = new ArrayList<String>();
		poem.add("年年忆今朝");
		poem.add("茫茫赶国考");
		// 将多个字符串内容写入指定文件files.txt中
		Files.write(Paths.get("testFile\\files.txt"), poem,
				Charset.forName("UTF-8"));
		// 判断C盘的总空间和可用空间
		FileStore cStore = Files.getFileStore(Paths.get(currentClass));
		System.out.println("C盘共有空间：" + cStore.getTotalSpace());
		System.out.println("C盘的可用空间：" + cStore.getUsableSpace());
	}
}