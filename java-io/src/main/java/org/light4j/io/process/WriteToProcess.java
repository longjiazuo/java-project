package org.light4j.io.process;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Scanner;

/**
 * 输出数据让别的进程可以读取
 * 
 * @author longjiazuo
 * 
 */
public class WriteToProcess {
	public static void main(String[] args) throws IOException {
		Process process = Runtime.getRuntime().exec("java ReadStandard");
		// 获取输出流
		OutputStream os = process.getOutputStream();
		// 创建打印流
		PrintStream ps = new PrintStream(os);
		// 写入内容
		ps.println("忆高考");
		ps.println("年年忆今朝，忙忙赶国考；");
		ps.println("不成真秀才，只图自逍遥。");
		ps.println(new WriteToProcess());
	}
}

class ReadStandard {
	public static void main(String[] args) {
		try
		(
			// 获取标准输入
			Scanner sc = new Scanner(System.in);
			//创建文件输出流，输出到文件output.txt
			FileOutputStream fos = new FileOutputStream("output.txt");
			//创建打印流
			PrintStream ps = new PrintStream(fos);
		)
		{
			//设置回车作为分割符
			sc.useDelimiter("\n");
			//循环写入数据
			while(sc.hasNextLine()){
				ps.println("输入的内容是:"+sc.nextLine());
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
}