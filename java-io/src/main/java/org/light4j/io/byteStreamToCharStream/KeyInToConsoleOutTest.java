package org.light4j.io.byteStreamToCharStream;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

/**
 * 转换流的使用：字节流转字符流
 * 
 * <p>
 * 读取键盘输入，转大写后输出到控制台
 * </p>
 * 
 * @author longjiazuo
 * 
 */
public class KeyInToConsoleOutTest {
	public static void main(String[] args) {
		try
		(
			// 标准输入流：键盘输入流
			InputStream inputStream = System.in;
			// 流的转换：字节流转字符流
			InputStreamReader reader = new InputStreamReader(inputStream);
			// 流的包装
			BufferedReader br = new BufferedReader(reader);

			//标准输出流：显示器
			OutputStream otputStream=System.out;
			// 流的转换：字节流转字符流
			OutputStreamWriter writer = new OutputStreamWriter(otputStream);
			// 流的包装
			BufferedWriter bw = new BufferedWriter(writer);	
		) 
		{
			String keyInStr = null;
			//读取整行
			while((keyInStr=br.readLine())!=null){
				//如果输入的内容是quit则退出
				if(keyInStr.equals("quit")){
					System.exit(1);
				}
				bw.write(keyInStr.toUpperCase());
				//换行
				bw.newLine();
				//使用缓冲流需要使用执行flush()才能将流刷新到物理结点
				bw.flush();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}