package org.light4j.nio.nio2;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.DosFileAttributeView;
import java.nio.file.attribute.FileOwnerAttributeView;
import java.nio.file.attribute.UserDefinedFileAttributeView;
import java.nio.file.attribute.UserPrincipal;
import java.util.Date;
import java.util.List;

/**
 * AttributeView测试
 * 
 * @author longjiazuo
 * 
 */
public class AttributeViewTest {
	public static void main(String[] args) throws IOException {
		// 获取将要操作的文件
		Path testPath = Paths.get("testFile\\attributes.txt");
		// 获取访问基本属性的BasicFileAttributeView对象
		BasicFileAttributeView basicView = Files.getFileAttributeView(testPath,
				BasicFileAttributeView.class);
		// 获取访问基本属性的BasicFileAttributes
		BasicFileAttributes basicAttribute = basicView.readAttributes();
		// 访问文件的基本属性
		System.out.println("创建时间："
				+ new Date(basicAttribute.creationTime().toMillis()));
		System.out.println("最后访问时间："
				+ new Date(basicAttribute.lastModifiedTime().toMillis()));
		System.out.println("文件大小：" + basicAttribute.size());

		
		// 获取访问文件属主信息的FileOwnerAttributeView
		FileOwnerAttributeView owerView = Files.getFileAttributeView(testPath,
				FileOwnerAttributeView.class);
		// 获取该文件所属的用户
		System.out.println(owerView.getOwner());
		// 获取系统中guest对应的用户
		UserPrincipal user = FileSystems.getDefault()
				.getUserPrincipalLookupService().lookupPrincipalByName("guest");
		// 修改用户
		owerView.setOwner(user);

		
		// 获取访问自定义属性的UserDefinedFileAttributeView
		UserDefinedFileAttributeView userView = Files.getFileAttributeView(
				testPath, UserDefinedFileAttributeView.class);
		// 获取所有的自定义属性
		List<String> attrNames = userView.list();
		// 遍历所有的自定义属性
		for (String name : attrNames) {
			ByteBuffer buf = ByteBuffer.allocate(userView.size(name));
			userView.read(name, buf);
			buf.flip();
			String value = Charset.defaultCharset().decode(buf).toString();
			System.out.println(value);
		}
		// 添加一个自定义属性
		userView.write("发行者", Charset.defaultCharset().encode("人生设计师"));

		
		// 获取访问DOS属性的DosFileAttributeView
		DosFileAttributeView dosView = Files.getFileAttributeView(testPath,
				DosFileAttributeView.class);
		// 将文件设置隐藏，只读
		dosView.setHidden(true);
		dosView.setReadOnly(true);
	}
}