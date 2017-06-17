package org.light4j.nio.nio2;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Path类测试
 * 
 * @author longjiazuo
 * 
 */
public class PathTest {
	public static void main(String[] args) {
		// 获取当前工作目录
		Path path = Paths.get(System.getProperty("user.dir"));
		// 列出当前工作目录path下包含的路径数量
		System.out.println("path包含的路径数量：" + path.getNameCount());
		// 获取path的根路径
		System.out.println("path的根路径：" + path.getRoot());
		// 获取path对应的绝对路径
		Path absolutePath = path.toAbsolutePath();
		System.out.println("absolutePath路径：" + absolutePath);
		// 获取绝对路径的根路径
		System.out.println("absolutePath的根路径：" + absolutePath.getRoot());
		// 获取绝对路径下所包含的路径数量
		System.out.println("absolutePath里包含的路径数量："
				+ absolutePath.getNameCount());
		// 返回绝对路径索引为2 的路径名
		System.out.println(absolutePath.getName(2));
		// 以多个String来构建Path对象
		Path path2 = Paths.get("g:", "publish", "codes");
		System.out.println(path2);
	}
}