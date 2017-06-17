package org.light4j.io.redirect;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 * 重定向输入测试类
 * 
 * <p>
 * 读取自身文件内容然后输出到控制台
 * </p>
 * 
 * @author longjiazuo
 * 
 */
public class RedirectInput {
	public static void main(String[] args) {
		// 获取工作目录
		String workDir = System.getProperty("user.dir");
		// 获取类名
		String className = Thread.currentThread().getStackTrace()[1].getClassName();
		// 类的路径
		String classPath = workDir + "\\src\\main\\java\\" + className;
		// 反斜杠替换掉"."
		String currentClass = classPath.replace(".", "\\") + ".java";
		Scanner sc=null;
		try
		(
			//新建字节输入流，读取文件自身内容
			FileInputStream fis = new FileInputStream(currentClass);
			
		) 
		{
			//重定向标准输入流到FileInputStream
			System.setIn(fis);
			
			//使用System.in获取标准输入，创建Scanner对象
			//下面的代码sc = new Scanner(System.in)不能和上面的代码System.setIn(fis)位置互换
			//必须先重定向输入流
			sc = new Scanner(System.in);
			//使用回车作为分隔符
			sc.useDelimiter("\n");
			
			while(sc.hasNextLine()){
				//输出内容到标准输出
				System.out.println(sc.nextLine());
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}finally{
			if(sc!=null){
				sc.close();
			}
		}
	}
}