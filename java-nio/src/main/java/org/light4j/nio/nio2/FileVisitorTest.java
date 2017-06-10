package org.light4j.nio.nio2;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

/**
 * FileVisitor测试类
 * 
 * @author longjiazuo
 * 
 */
public class FileVisitorTest {
	public static void main(String[] args) throws IOException {
		// 遍历当前工作目录下的所有文件和子目录
		Files.walkFileTree(Paths.get("."), new SimpleFileVisitor<Path>() {
			@Override
			public FileVisitResult visitFile(Path file,
					BasicFileAttributes attrs) throws IOException {
				System.out.println("正在访问" + file + "文件");
				if (file.endsWith("read.txt")) {
					System.out.println("已经找到目标文件");
					// TERMINATE表示终止访问
					return FileVisitResult.TERMINATE;
				}
				// CONTINUE表示继续访问
				return FileVisitResult.CONTINUE;
			}

			@Override
			public FileVisitResult preVisitDirectory(Path dir,
					BasicFileAttributes attrs) throws IOException {
				System.out.println("正在访问" + dir + " 路径");
				return FileVisitResult.CONTINUE;
			}

			@Override
			public FileVisitResult postVisitDirectory(Path dir, IOException exc)
					throws IOException {
				System.out.println("访问" + dir + " 路径结束");
				return FileVisitResult.CONTINUE;
			}
		});
	}
}