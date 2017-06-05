package org.light4j.io.printStream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

/**
 * PrintStream打印流测试
 * 
 * <p>
 * PrintStream流是处理流，可以对结点流进行包装使得对流的处理更加方便
 * </p>
 * 
 * <p>
 * 使用打印流可以直接打印文本内容到文件
 * </p>
 * 
 * @author longjiazuo
 * 
 */
public class PrintStreamTest {
	public static void main(String[] args) {
		try 
		(
			FileOutputStream fos = new FileOutputStream("printStream.txt");
			PrintStream ps = new PrintStream(fos);
		) 
		{
			ps.println("忆高考");
			ps.println("年年忆今朝，忙忙赶国考；");
			ps.println("不成真秀才，只图自逍遥。");
			System.out.println("操作结束....");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
}