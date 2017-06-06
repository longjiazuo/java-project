package org.light4j.io.pushBack;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PushbackReader;

/**
 * PushbackReader推回输入流测试
 * 
 * <p>
 * 查找指定字符串，并输出其前面部分的内容
 * </p>
 * 
 * @author longjiazuo
 * 
 */
public class PushbackReaderTest {
	public static void main(String[] args) {
		// 获取工作目录
		String workDir = System.getProperty("user.dir");
		// 获取类名
		String className = Thread.currentThread().getStackTrace()[1].getClassName();
		// 类的路径
		String classPath = workDir + "\\src\\main\\java\\" + className;
		// 反斜杠替换掉"."
		String currentClass = classPath.replace(".", "\\") + ".java";

		try 
		(
				// 创建字符输入流，目标文件是当前类本身
				FileReader fr = new FileReader(currentClass);
				// 创建字符推回输入流，
				//需要设置缓冲区的大小，设置为字符数组的两倍或者更大，不然报Pushback buffer overflow异常
				PushbackReader pr = new PushbackReader(fr,112);// ①
		) 
		{
			// 新建字符数组
			char[] cbuff = new char[56];
			int hasRead = 0;

			// 保存上次读取的内容
			String lastContent = "";

			// 循环读取数据
			while ((hasRead = pr.read(cbuff)) > 0) {
				// 当前读取的内容，把其转换为字符串表示
				String currentContent = new String(cbuff, 0, hasRead);
				// 保存目标索引的值
				int targetIndex = 0;
				// 内容为上次读取的内容和当前读取内容的拼装
				String content = lastContent + currentContent;
				// 判断是否包含字符串"public class"
				targetIndex = content.indexOf("public class");
				// 如果包含字符串"public class"
				if (targetIndex > 0) {
					// 把内容推回到推回缓冲区，内容包含上次内容和本次读取内容之和
					pr.unread(content.toCharArray());
					// 读取前面length个字符的内容，防止数组溢出
					int length = targetIndex > 56 ? 56 : targetIndex;
					// 再次读取内容，读取目标串之前的内容，实际上是先从推回缓冲区里面读
					pr.read(cbuff, 0, length);
					System.out.println(new String(cbuff, 0, length));
					// 退出
					System.exit(0);
				} else {
					// 打印上次读取到的内容
					System.out.println(lastContent);
					// 将本次内容设置为上次读取的内容
					lastContent = currentContent;
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
}